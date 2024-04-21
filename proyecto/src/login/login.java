package login;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame implements ActionListener {
    private JTextField textFieldUser;
    private JPasswordField passwordFieldPass;
    private JPanel JPanelLogin;
    private JButton cerrarButton;
    private JButton ingresarButton;

    public JPanel getJPanelLogin()
    {
        return JPanelLogin;
    }

    public login(){
        cerrarButton.addActionListener(this);
        ingresarButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cerrarButton)
        {
            System.exit(0);
        }
        if(e.getSource()==ingresarButton)
        {
            String user=textFieldUser.getText();
            String password  = new String(passwordFieldPass.getPassword());

            if(user.equals("luis")&& password.equals("123"))
            {
                JOptionPane.showMessageDialog(null,"iniciar sesion");
                MostraMenu();
            }
            else{
                JOptionPane.showMessageDialog(null,"error");
            }
        }
    }

    private void MostraMenu()
    {
        JFrame frame=new JFrame("MENU");
        menu menu=new menu();
        frame.setContentPane(menu.getJpanel2());
        frame.setSize(600,400);
        frame.setVisible(true);

    }
}

