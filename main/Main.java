package main;

import javax.swing.SwingUtilities;

import view.MainWindow;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow app = new MainWindow();
            app.setVisible(true);
        });
    }
}
