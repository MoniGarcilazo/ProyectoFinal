/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import modelo.Funcion;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author erick
 */
public class ControlVentaBoletoTest {
    
    public ControlVentaBoletoTest() {
    }

    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        ControlVentaBoleto instance = null;
        instance.actionPerformed(e);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAccionarComboBoxFechas() {
        System.out.println("accionarComboBoxFechas");
        ControlVentaBoleto instance = null;
        instance.accionarComboBoxFechas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testMostrarInfoFuncion1() {
        System.out.println("mostrarInfoFuncion1");
        Funcion funcion = null;
        ControlVentaBoleto instance = null;
        instance.mostrarInfoFuncion1(funcion);
        fail("The test case is a prototype.");
    }

    @Test
    public void testMostrarInfoFuncion2() {
        System.out.println("mostrarInfoFuncion2");
        String nombreObra = "";
        String duracionObra = "";
        String horaObra = "";
        String idObra = "";
        ControlVentaBoleto instance = null;
        instance.mostrarInfoFuncion2(nombreObra, duracionObra, horaObra, idObra);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAccionarBotonHorario() {
        System.out.println("accionarBotonHorario");
        Funcion funcion = null;
        ControlVentaBoleto instance = null;
        instance.accionarBotonHorario(funcion);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSelecFuncionesPorFecha() {
        System.out.println("selecFuncionesPorFecha");
        ArrayList<Funcion> listaFunciones = null;
        String fecha = "";
        ControlVentaBoleto instance = null;
        ArrayList<Funcion> expResult = null;
        ArrayList<Funcion> result = instance.selecFuncionesPorFecha(listaFunciones, fecha);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
