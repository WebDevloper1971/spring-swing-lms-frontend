package view;

import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        MainPanel panel = new MainPanel();

        add(panel);
        pack();
        setTitle("Library Management System");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
