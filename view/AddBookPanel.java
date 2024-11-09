package view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

import models.Book;
import service.ApiClient;

public class AddBookPanel extends JPanel {

    private JTextField title, author, isbn, quantity;
    private JButton add;
    public static final int INPUT_WIDTH = 250;
    public static final int INPUT_HEIGHT = 40;
    int x = 20;
    int y = 80;
    int gap = 20;

    public AddBookPanel() {

        title = new JTextField();
        author = new JTextField();
        isbn = new JTextField();
        quantity = new JTextField();

        add = new JButton("ADD BOOK");

        styleTextfield(title, "enter title of the book");
        styleTextfield(author, "enter book author name");
        styleTextfield(isbn, "enter book ISBN number");
        styleTextfield(quantity, "enter book stock");

        title.setBounds(MainPanel.SUBCONTENT_PANEL_WIDTH - MainPanel.SUBCONTENT_PANEL_WIDTH / 2 - 125, y, INPUT_WIDTH,
                INPUT_HEIGHT);
        author.setBounds(MainPanel.SUBCONTENT_PANEL_WIDTH - MainPanel.SUBCONTENT_PANEL_WIDTH / 2 - 125,
                title.getY() + title.getHeight() + gap, INPUT_WIDTH, INPUT_HEIGHT);
        isbn.setBounds(MainPanel.SUBCONTENT_PANEL_WIDTH - MainPanel.SUBCONTENT_PANEL_WIDTH / 2 - 125,
                author.getY() + author.getHeight() + gap, INPUT_WIDTH, INPUT_HEIGHT);
        quantity.setBounds(MainPanel.SUBCONTENT_PANEL_WIDTH - MainPanel.SUBCONTENT_PANEL_WIDTH / 2 - 125,
                isbn.getY() + isbn.getHeight() + gap, INPUT_WIDTH, INPUT_HEIGHT);

        styleButton(add);
        add.setBounds(MainPanel.SUBCONTENT_PANEL_WIDTH - MainPanel.SUBCONTENT_PANEL_WIDTH / 2 - 125,
                quantity.getY() + quantity.getHeight() + gap, 250,
                INPUT_HEIGHT);
        add.addActionListener(e -> {
            Book book = new Book();
            book.setTitle(title.getText());
            book.setAuthor(author.getText());
            book.setIsbn(isbn.getText());
            book.setQuantity(Integer.parseInt(quantity.getText()));
            try {
                Book bk = ApiClient.addBook(book);
                if (bk != null) {
                    JOptionPane.showMessageDialog(this, "Book added successfully");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getLocalizedMessage());
            }
        });

        add(title);
        add(author);
        add(isbn);
        add(quantity);
        add(add);
        setLayout(null);
        setBackground(Color.white);
    }

    private void styleButton(JButton button) {
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setBorder(null);
    }

    private void styleTextfield(JTextField textField, String placeholder) {
        textField.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().equals("")) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.lightGray);
                }
            }

        });
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);
        textField.setBackground(Color.white);
        textField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
    }
}
