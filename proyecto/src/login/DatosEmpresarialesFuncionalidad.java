package login;

import gestor.archivos.ArchivoTexto;
import gestor.empresarial.datos.DatosEmpresariales;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DatosEmpresarialesFuncionalidad extends JFrame implements ActionListener{
    private JPanel JpanelDatos;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton agregarButton;
    private JButton cerrarButton;
    private JButton verButton;
    private JTextArea textArea1;
    private JTextField textFieldPuesto;
    private ArchivoTexto archivoTexto;

    private String id;
    private String adscripcion;
    private String telefonoExterior;
    private String puesto;

    public JPanel getJPanelDatos(){
        return JpanelDatos;
    }

    /*
     * Constructor de la clase y detección de evento sobre botones
     */
    public DatosEmpresarialesFuncionalidad(){
        agregarButton.addActionListener( this);
        cerrarButton.addActionListener((this));
        verButton.addActionListener( this);

    }

    /*
    Validacion para ver si se desea agregar un egistro nuevo o
    ver la lista de los registros
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==agregarButton){
            agregarDatosEmpresariales();
        }

        else if (e.getSource()==verButton){
            verListaDatosEmpresariales();
        }
    }

    /*
    Proceso para agregar registro en un artivo.txt
     */
    public void agregarDatosEmpresariales(){
        archivoTexto = new ArchivoTexto();
        try {
            archivoTexto.crearArchivo(1);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        id= textField1.getText();
        adscripcion = textField2.getText();
        telefonoExterior = textField3.getText();
        puesto = textFieldPuesto.getText();
        if (textField1.getText().isEmpty() || textField2.getText().isEmpty() || textField3.getText().isEmpty()
                || textFieldPuesto.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"No debe haber campos vacíos");
        }
        else{
            /* excepcion que puede ser lanzada si se producen mientras se tiene acceso a
        la información mediante archivos y directorios.
        */
            try{
                FileWriter fw = new FileWriter("archivoDatosEmpresariales.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(getId() + " , " + getAdscripcion() + " , " + getTelefonoExterior()+ " , " + getPuesto() + "\n");
                bw.close();
                fw.close();
            }
            catch(IOException ex){
                System.out.println("Error " + ex.getMessage());
            }
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textFieldPuesto.setText("");
            JOptionPane.showMessageDialog(null,"Los datos se han registrado de manera exitosa");
        }

    }

    /*
    Proceso para leer los registros almacenados dentro del archivo txt
     */
    public void verListaDatosEmpresariales(){
        File file = new File("archivoDatosEmpresariales.txt");
        ArrayList lista = new ArrayList<>();
        int cant = 0;
        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String linea = scanner.nextLine();
                Scanner delimitar = new Scanner(linea);
                delimitar.useDelimiter("\\s*,");
                DatosEmpresariales datosEmpresariales = new DatosEmpresariales();
                datosEmpresariales.setId(Integer.parseInt(delimitar.next()));
                datosEmpresariales.setAdscripcion(delimitar.next());
                datosEmpresariales.setTelefonoExterior((delimitar.next()));
                datosEmpresariales.setPuesto((delimitar.next()));

                lista.add(datosEmpresariales);
            }
            scanner.close();
            /*
            Recuperación de datos para mostrar el listado en pantalla
             */
            String texto = "";
            DatosEmpresariales empresariales;
            for(Object obj : lista){
                empresariales = (DatosEmpresariales)obj;
                texto = texto + empresariales.getId() + "\t\t\t" + empresariales.getAdscripcion() + "\t\t\t" + empresariales.getTelefonoExterior()
                        + "\t\t\t" + empresariales.getPuesto() + "\n\n";
            }
            textArea1.setText("Id" + "\t\t\t" + "Adscripción" + "\t\t\t" + "Tel. Exterior" + "\t\t\t" + "Puesto" + "\n\n" + texto);
        }
        catch (FileNotFoundException exe){
            System.out.println("Error" + exe.getMessage());
        }
    }

    /*
    metodos para obtener el valor de los atributos tecleados
     */
    public String getId(){
        return id;
    }

    public String getAdscripcion(){
        return adscripcion;
    }

    public String getTelefonoExterior(){
        return telefonoExterior;
    }

    public String getPuesto(){
        return puesto;
    }
}
