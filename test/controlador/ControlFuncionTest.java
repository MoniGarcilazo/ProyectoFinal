/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jokag
 */
public class ControlFuncionTest {
    
    public ControlFuncionTest() {
    }

    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        ControlFuncion instance = null;
        instance.actionPerformed(e);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAgregarFuncion() {
        System.out.println("agregarFuncion");
        ActionEvent e = null;
        ControlFuncion instance = null;
        instance.agregarFuncion(e);
        fail("The test case is a prototype.");
    }

    @Test
    public void testModificarFuncion() {
        System.out.println("modificarFuncion");
        ActionEvent e = null;
        ControlFuncion instance = null;
        instance.modificarFuncion(e);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEliminarFuncion() {
        System.out.println("eliminarFuncion");
        ActionEvent e = null;
        ControlFuncion instance = null;
        instance.eliminarFuncion(e);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCapturarDatos() {
        System.out.println("capturarDatos");
        ControlFuncion instance = null;
        instance.capturarDatos();
        fail("The test case is a prototype.");
    }

    @Test
    public void testMouseClicked() {
        System.out.println("mouseClicked");
        MouseEvent e = null;
        ControlFuncion instance = null;
        instance.mouseClicked(e);
        fail("The test case is a prototype.");
    }

    @Test
    public void testMousePressed() {
        System.out.println("mousePressed");
        MouseEvent e = null;
        ControlFuncion instance = null;
        instance.mousePressed(e);
        fail("The test case is a prototype.");
    }

    @Test
    public void testMouseReleased() {
        System.out.println("mouseReleased");
        MouseEvent e = null;
        ControlFuncion instance = null;
        instance.mouseReleased(e);
        fail("The test case is a prototype.");
    }

    @Test
    public void testMouseEntered() {
        System.out.println("mouseEntered");
        MouseEvent e = null;
        ControlFuncion instance = null;
        instance.mouseEntered(e);
        fail("The test case is a prototype.");
    }

    @Test
    public void testMouseExited() {
        System.out.println("mouseExited");
        MouseEvent e = null;
        ControlFuncion instance = null;
        instance.mouseExited(e);
        fail("The test case is a prototype.");
    }
    
}
