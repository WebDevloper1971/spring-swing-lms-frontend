package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

    private static final int MAIN_WIDTH = 800;
    private static final int MAIN_HEIGHT = 600;
    private SidePanel sidePanel;
    private static JPanel contentPanel;

    Dimension size = new Dimension(MAIN_WIDTH, MAIN_HEIGHT);

    private static int x = 10;
    private static int y = 30;
    private static int gap = 10;

    public static int SUBCONTENT_PANEL_WIDTH = MAIN_WIDTH - MAIN_WIDTH / 4 - 3 * gap;
    public static int SUBCONTENT_PANEL_HEIGHT = MAIN_HEIGHT - 2 * y;

    public MainPanel() {

        sidePanel = new SidePanel();
        contentPanel = new JPanel();

        sidePanel.setBounds(x, y, MAIN_WIDTH / 4, MAIN_HEIGHT - 2 * y);
        contentPanel.setBounds(x + sidePanel.getWidth() + gap, y, MAIN_WIDTH - MAIN_WIDTH / 4 - 3 * gap,
                MAIN_HEIGHT - 2 * y);

        contentPanel.setLayout(new BorderLayout());
        setPanel(new BorrowPanel());

        add(contentPanel);
        add(sidePanel);
        setPreferredSize(size);
        setLayout(null);
        setBackground(Color.white);

    }

    public static void setPanel(JPanel panel) {
        contentPanel.removeAll();
        contentPanel.add(panel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

}
