/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.JToggleButton;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Monica Garcilazo
 */
public class ControlAsientosTest {
    
    public ControlAsientosTest() {
    }

    /**
     * Test of actionPerformed method, of class ControlAsientos.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        ControlAsientos instance = null;
        instance.actionPerformed(e);
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarAsientosSeleccionados method, of class ControlAsientos.
     */
    @Test
    public void testActualizarAsientosSeleccionados() {
        System.out.println("actualizarAsientosSeleccionados");
        ControlAsientos instance = null;
        instance.actualizarAsientosSeleccionados();
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearBoletos method, of class ControlAsientos.
     */
    @Test
    public void testCrearBoletos() {
        System.out.println("crearBoletos");
        ControlAsientos instance = null;
        instance.crearBoletos();
        fail("The test case is a prototype.");
    }

    /**
     * Test of creacionAsientosZonaB1 method, of class ControlAsientos.
     */
    @Test
    public void testCreacionAsientosZonaB1() {
        System.out.println("creacionAsientosZonaB1");
        ControlAsientos instance = null;
        JToggleButton[][] expResult = null;
        JToggleButton[][] result = instance.creacionAsientosZonaB1();
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of creacionAsientosZonaB2 method, of class ControlAsientos.
     */
    @Test
    public void testCreacionAsientosZonaB2() {
        System.out.println("creacionAsientosZonaB2");
        ControlAsientos instance = null;
        JToggleButton[][] expResult = null;
        JToggleButton[][] result = instance.creacionAsientosZonaB2();
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of creacionAsientosZonaA method, of class ControlAsientos.
     */
    @Test
    public void testCreacionAsientosZonaA() {
        System.out.println("creacionAsientosZonaA");
        ControlAsientos instance = null;
        JToggleButton[][] expResult = null;
        JToggleButton[][] result = instance.creacionAsientosZonaA();
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of creacionAsientosZonaC method, of class ControlAsientos.
     */
    @Test
    public void testCreacionAsientosZonaC() {
        System.out.println("creacionAsientosZonaC");
        ControlAsientos instance = null;
        JToggleButton[][] expResult = null;
        JToggleButton[][] result = instance.creacionAsientosZonaC();
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of colocarImagenSilla method, of class ControlAsientos.
     */
    @Test
    public void testColocarImagenSilla() {
        System.out.println("colocarImagenSilla");
        String imagen = "";
        ControlAsientos instance = null;
        Icon expResult = null;
        Icon result = instance.crearIconoSilla(imagen);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearIconoSilla method, of class ControlAsientos.
     */
    @Test
    public void testCrearIconoSilla() {
        System.out.println("crearIconoSilla");
        String imagen = "";
        ControlAsientos instance = null;
        Icon expResult = null;
        Icon result = instance.crearIconoSilla(imagen);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
