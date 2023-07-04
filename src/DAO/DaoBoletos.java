/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;;

/**
 *Clase que realiza la creación de archivos relacionado con los boletos
 */
public class DaoBoletos {

    private File archivo;
    
    /**
     * Método que crea un archivo txt con el nombre de Boletos
     **/
    public void crearArchivo() {
        File archivo = new File("Boletos.txt");

    }

    /**
     * Método que registra los boletos en un archivo txt con el nombre de Boletos
     * @param datosBoleto boleto generado en la ultima venta
     **/
    public void registrarBoletosEnArchivo(String datosBoleto) {
        if (archivo == null) {
            crearArchivo();
        }
        FileWriter fr;
        try {
            fr = new FileWriter("Boletos.txt");
            fr.write(datosBoleto);
            fr.close();
            JOptionPane.showMessageDialog(null, "Registro exitoso de los boletos en archivo");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error en la escritura del archivo" + ex.getMessage());
        }
    }
}
