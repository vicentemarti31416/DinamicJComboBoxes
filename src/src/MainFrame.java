package src;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

    public MainFrame() {
        setBounds(300, 250, 400, 400);
        Panel1 panel1 = new Panel1();
        add(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
    }
}
