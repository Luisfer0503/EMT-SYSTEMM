package login;

import gestor.archivos.ArchivoTexto;
import gestor.empresarial.datos.DatosPersonales;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DatosPersonalesFuncionalidad extends JFrame implements ActionListener {
    private JPanel JpanelDatos;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton agregarPersonalButton;
    private JButton cerrarButton;
    private JButton mostrarPersonalButton;
    private JTextArea textArea1;
    private JTextField textField4;
    private ArchivoTexto archivoTexto;

    private int id;
    private String nombre;
    private String correo;
    private String whatsapp;

    public JPanel getJPanelDatos(){
        return JpanelDatos;
    }

    public DatosPersonalesFuncionalidad(){
        agregarPersonalButton.addActionListener( this);
        cerrarButton.addActionListener((this));
        mostrarPersonalButton.addActionListener( this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==agregarPersonalButton){
            agregarDatosPersonales();
        }

        else if (e.getSource()==mostrarPersonalButton){
            verListaDatosPersonales();
        }
    }

    public void agregarDatosPersonales(){
        archivoTexto = new ArchivoTexto();
        try {
            archivoTexto.crearArchivo(2);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        id = Integer.parseInt(textField1.getText());
        nombre = textField2.getText();
        correo = textField3.getText();
        whatsapp = textField4.getText();

        try{
            FileWriter fw = new FileWriter("archivoDatosPersonales.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(getId() + " , " + getNombre() + " , " + getCorreo()+ " , " + getWhatsapp() + "\n");
            bw.close();
            fw.close();
        }
        catch(IOException ex){
            System.out.println("Error " + ex.getMessage());
        }
    }

    public void verListaDatosPersonales(){
        File file = new File("archivoDatosPersonales.txt");
        ArrayList lista = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String linea = scanner.nextLine();
                Scanner delimitar = new Scanner(linea);
                delimitar.useDelimiter("\\s*,");
                DatosPersonales datosPersonales = new DatosPersonales();

                datosPersonales.setId(Integer.parseInt(delimitar.next()));
                datosPersonales.setNombre(delimitar.next());
                datosPersonales.setCorreo((delimitar.next()));
                datosPersonales.setWhatsapp((delimitar.next()));

                lista.add(datosPersonales);
            }
            scanner.close();

            String texto = "";
            DatosPersonales personales;
            for(Object obj : lista){
                personales = (DatosPersonales)obj;
                texto = texto + personales.getId() + "\t\t\t" + personales.getNombre() + "\t\t\t" + personales.getCorreo()
                        + "\t\t\t" + personales.getWhatsapp() + "\n\n";
            }
            textArea1.setText("Id" + "\t\t\t" + "Nombre completo" + "\t\t\t" + "Correo" + "\t\t\t" + "WhatsApp" + "\n\n" + texto);
        }
        catch (FileNotFoundException exe){
            System.out.println("Error" + exe.getMessage());
        }
    }

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String getCorreo(){
        return correo;
    }

    public String getWhatsapp(){
        return whatsapp;
    }
}
