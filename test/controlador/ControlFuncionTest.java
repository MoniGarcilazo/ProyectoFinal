/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import modelo.Funcion;
import modelo.ObraTeatral;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import vista.VentanaPrincipal;
import java.sql.Time;

/**
 *
 * @author jokag
 */
public class ControlFuncionTest {
     private VentanaPrincipal menu;
     private ControlFuncion controlFuncion;
     private Funcion funcion;
     private ObraTeatral obraTeatral;
    
    public ControlFuncionTest() {
    }
    
     @Before
    public void setup() {
        // Inicializar el objeto Menu para la prueba
        menu = new VentanaPrincipal();
        obraTeatral = new ObraTeatral(90, "MoniTest", "Terror", "Muchos Test", 90, "Moni", "Erick", 100);
        long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);  
        long now = System.currentTimeMillis();
        Time sqlTime = new Time(now);
        funcion = new Funcion(90, obraTeatral, date, sqlTime);
        controlFuncion = new ControlFuncion(funcion, menu);
        
        
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
        controlFuncion.agregarFuncion();
    }




    @Test
    public void testModificarFuncion() {
        System.out.println("modificarFuncion");
        controlFuncion.modificarFuncion();
  
    }

    @Test
    public void testEliminarFuncion() {
        System.out.println("eliminarFuncion");
        controlFuncion.eliminarFuncion();
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
