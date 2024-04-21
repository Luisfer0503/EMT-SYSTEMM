package login;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class menu extends JFrame implements ActionListener {
    private JPanel Jpanel2;
    private JButton cerrarsesionButton;
    private JButton datosPersonalesButton;
    private JButton datosEmpresarialesButton;
    private JButton contratosButton;
    public JPanel getJpanel2(){
        return Jpanel2;
    }
    public menu(){
        cerrarsesionButton.addActionListener(this);
        datosPersonalesButton.addActionListener(this);
        datosEmpresarialesButton.addActionListener(this);
        contratosButton.addActionListener((this));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cerrarsesionButton)
        {
            System.exit(0);
        }
        if(e.getSource()==datosPersonalesButton){


        }
    }
}
