/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import vista.VentanaPrincipal;

/**
 *
 * @author erick
 */
public class GestorVentanas {
    
    /**
     * Método que asigna las coordenadas a la ventana a mostrar
     * @param ventana Jpanel el cual se va a mostrar en pantalla
    **/
    public static void asignarPosicionVentana(JPanel ventana){
        ventana.setSize(1460, 720);
        ventana.setLocation(0, 0);
    }
    
    /**
     * Método remueve a la ventana anterior
     * @param ventana Jpanel el cual se va a quitar de la pantalla
     * @param menu Ventana principal donse se muestra toda la pantalla del sistema
    **/
    public static void mostrarNuevaVentana(JPanel ventana, VentanaPrincipal menu){
        menu.getPanelContenido().removeAll();
        menu.getPanelContenido().add(ventana, BorderLayout.CENTER);
        menu.getPanelContenido().revalidate();
        menu.getPanelContenido().repaint();
    }
}
