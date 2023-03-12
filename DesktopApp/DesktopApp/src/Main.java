import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        DesktopForm desktopForm = new DesktopForm();
        JFrame frame = new JFrame("DesktopForm");
        frame.setContentPane(desktopForm.getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}