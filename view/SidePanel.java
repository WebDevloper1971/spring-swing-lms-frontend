package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SidePanel extends JPanel {

    JButton viewBooks, addBooks, borrowBooks, returnBooks;
    int blank_buttons = 5;

    public SidePanel() {

        viewBooks = new JButton("View");
        addBooks = new JButton("Add");
        borrowBooks = new JButton("Borrow");
        returnBooks = new JButton("Return");

        buttonStyling(viewBooks);
        buttonStyling(addBooks);
        buttonStyling(borrowBooks);
        buttonStyling(returnBooks);

        add(viewBooks);
        add(addBooks);
        add(borrowBooks);
        add(returnBooks);

        for (int i = 0; i < blank_buttons; i++) {
            JButton blank = new JButton();
            blank.setBackground(null);
            blank.setEnabled(false);
            blank.setBorder(null);
            blank.setBorderPainted(false);
            blank.setFocusPainted(false);
            add(blank);
        }

        viewBooks.addActionListener(e -> MainPanel.setPanel(new ViewBookPanel()));
        addBooks.addActionListener(e -> MainPanel.setPanel(new AddBookPanel()));
        borrowBooks.addActionListener(e -> MainPanel.setPanel(new BorrowPanel()));
        returnBooks.addActionListener(e -> MainPanel.setPanel(new ReturnPanel()));

        setLayout(new GridLayout(0, 1, 2, 2));
        setBackground(Color.white);

    }

    private void buttonStyling(JButton button) {
        button.setBackground(null);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
    }

}
