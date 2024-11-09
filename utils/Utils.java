package utils;

import models.Book;

public class Utils {
    public static String[][] convertBooksTo2DArray(Book[] books) {

        // for 5 columns
        String[][] bookArray = new String[books.length][5];

        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            bookArray[i][0] = String.valueOf(book.getId());
            bookArray[i][1] = book.getTitle();
            bookArray[i][2] = book.getAuthor();
            bookArray[i][3] = book.getIsbn();
            bookArray[i][4] = String.valueOf(book.getQuantity());
        }
        return bookArray;
    }

}
