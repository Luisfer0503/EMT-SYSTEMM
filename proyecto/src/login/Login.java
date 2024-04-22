package login;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    private JTextField textFieldUser;
    private JPasswordField passwordFieldPass;
    private JPanel JPanelLogin;
    private JButton cerrarButton;
    private JButton ingresarButton;

    public JPanel getJPanelLogin()
    {
        return JPanelLogin;
    }

    /*
     * Constructor de la clase y detección de evento sobre botones
     */
    public Login(){
        cerrarButton.addActionListener(this);
        ingresarButton.addActionListener(this);

    }

    /*
     * Validacion de login y cierre de sesion
     */
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
                JOptionPane.showMessageDialog(null,"Sesion iniciada con éxito");
                MostraMenu();
            }
            else{
                JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrectos");
            }
        }
    }

    /*
    Llamado a la ventana del menú de opciones
     */
    private void MostraMenu()
    {
        JFrame frame=new JFrame("MENU");
        menu menu=new menu();
        frame.setContentPane(menu.getJpanel2());
        frame.setSize(600,400);
        frame.setVisible(true);
        //frame.dispose();

    }
}

