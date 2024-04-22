package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class menu extends JFrame implements ActionListener {
    private JPanel Jpanel2;
    private JButton cerrarsesionButton;
    private JButton datosPersonalesButton;
    private JButton datosEmpresarialesButton;
    private JButton contratosButton;
    public JPanel getJpanel2(){
        return Jpanel2;
    }

    /*
     * Constructor de la clase y detección de evento sobre botones
     */
    public menu(){
        cerrarsesionButton.addActionListener(this);
        datosPersonalesButton.addActionListener(this);
        datosEmpresarialesButton.addActionListener(this);
        contratosButton.addActionListener((this));
    }

    /*
    Validaciond de botones para ver que pantalla (flujo) será llamada
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cerrarsesionButton)
        {
            System.exit(0);
        }
        else if(e.getSource()==datosEmpresarialesButton){
            datosEmpresariales();
        }
        else if (e.getSource()==datosPersonalesButton){
            datosPersonales();
        }
        else if(e.getSource()==contratosButton){
            contratos();
        }
    }

    /*
     Construccion del llamado del flujo de datos empresariales
     */
    public void datosEmpresariales(){
        JFrame frame = new JFrame();
        DatosEmpresarialesFuncionalidad datosEmpresarialesFuncionalidad =new DatosEmpresarialesFuncionalidad();
        frame.setContentPane(datosEmpresarialesFuncionalidad.getJPanelDatos());
        frame.setSize(1200,800);
        frame.setVisible(true);
    }

    /*
     Construccion del llamado del flujo de datos personales
     */
    public void datosPersonales(){
        JFrame frame = new JFrame();
        DatosPersonalesFuncionalidad datosPersonalesFuncionalidad =new DatosPersonalesFuncionalidad();
        frame.setContentPane(datosPersonalesFuncionalidad.getJPanelDatos());
        frame.setSize(1200,800);
        frame.setVisible(true);
    }

    /*
     Construccion del llamado del flujo de contratos
     */
    public void contratos(){
        JFrame frame = new JFrame();
        ContratosFuncionalidad contratosFuncionalidad =new ContratosFuncionalidad();
        frame.setContentPane(contratosFuncionalidad.getJPanelDatos());
        frame.setSize(1200,800);
        frame.setVisible(true);
    }


}
