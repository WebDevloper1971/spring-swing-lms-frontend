package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

import models.Book;
import service.ApiClient;

public class BorrowPanel extends JPanel {
    JComboBox<String> bookDropdown;

    public BorrowPanel() {

        Book[] books = ApiClient.getAllBooks();
        String bookNames[] = new String[books.length];

        // LibraryMember[] LibraryMembers = ApiClient.getAllLibraryMembers();
        // String[] libraryMemberNames = new String[libraryMembers.length];

        for (int i = 0; i < bookNames.length; i++) {
            bookNames[i] = books[i].getTitle();
        }
        bookDropdown = new JComboBox<String>(bookNames);

        add(bookDropdown, BorderLayout.CENTER);
        setBackground(Color.white);
    }
}
