package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import models.Book;
import service.ApiClient;
import utils.Utils;

public class ViewBookPanel extends JPanel {

    private JScrollPane scrollPane;
    private JTable bookTable;
    private final String[] COLUMN_NAMES = { "Id", "Title", "Author", "ISBN", "Quantity" };

    public ViewBookPanel() {

        Book[] bookArr = ApiClient.getAllBooks();
        String[][] tableData = Utils.convertBooksTo2DArray(bookArr);

        bookTable = new JTable(tableData, COLUMN_NAMES);
        bookTable.setRowHeight(30);
        bookTable.setSelectionBackground(Color.black);
        bookTable.setSelectionForeground(Color.white);

        JTableHeader tableHeader = bookTable.getTableHeader();
        tableHeader.setPreferredSize(new Dimension(0, 30));
        tableHeader.setBackground(Color.BLACK);
        tableHeader.setForeground(Color.white);

        scrollPane = new JScrollPane(bookTable);
        scrollPane.getViewport().setBackground(Color.white);

        add(scrollPane, BorderLayout.CENTER);
        setLayout(new GridLayout(1, 1));
        setBackground(Color.yellow);
    }

}
