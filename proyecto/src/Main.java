import  login.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame=new JFrame("EMT-SYSTEM");

        Login login=new Login();
        frame.setContentPane(login.getJPanelLogin());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,400);
        frame.setVisible(true);

    }
}