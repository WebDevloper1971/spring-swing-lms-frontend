package service;

import com.google.gson.Gson;

import models.Auth;
import models.Book;
import models.LibraryUser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiClient {

    private static final String BASE_URL = "http://localhost:8080/api";
    private static final Gson gson = new Gson();

    // get all books
    public static Book[] getAllBooks() {
        String res = sendRequest("GET", BASE_URL + "/books", null);
        Book[] books = gson.fromJson(res, Book[].class);
        return books;
    }

    public static Book getBook(Long id) {
        String res = sendRequest("GET", BASE_URL + "/books/" + id, null);
        Book book = gson.fromJson(res, Book.class);
        return book;
    }

    public static Book addBook(Book book) {
        String jsonBook = gson.toJson(book);
        String res = sendRequest("POST", BASE_URL + "/books", jsonBook);
        Book bookRes = gson.fromJson(res, Book.class);
        return bookRes;
    }

    public static String borrowBook(Long bookId, Long memberId) {
        String params = String.format("bookId=%d&memberId=%d", bookId, memberId);
        return sendRequest("POST", BASE_URL + "/borrowings/borrow?" + params, null);
    }

    public static String returnBook(Long borrowingId) {
        String params = String.format("borrowingId=%d", borrowingId);
        return sendRequest("POST", BASE_URL + "/borrowings/return?" + params, null);
    }

    public static LibraryUser addLibraryUser(LibraryUser user) {
        String jsonLibraryUser = gson.toJson(user);
        String res = sendRequest("POST", BASE_URL + "/members", jsonLibraryUser);
        LibraryUser libraryUser = gson.fromJson(res, LibraryUser.class);
        return libraryUser;
    }

    public static String login(Auth auth) {
        String jsonAuth = gson.toJson(auth);
        String res = sendRequest("POST", BASE_URL + "/members/login", jsonAuth);
        return res;
    }

    private static String sendRequest(String method, String urlString, String jsonInputString) {
        StringBuilder response = new StringBuilder();
        try {
            @SuppressWarnings("deprecation")
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");

            if (jsonInputString != null && !jsonInputString.isEmpty()) {
                connection.setDoOutput(true);
                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = jsonInputString.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
            }

        } catch (Exception e) {
            // e.printStackTrace();
            response.append("Error: ").append(e.getMessage());
        }
        return response.toString();
    }
}
