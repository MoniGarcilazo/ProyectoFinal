/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import vista.VentanaPrincipal;

/**
 *
 * @author erick
 */
public class ControlVentanaPrincipalTest {
    private VentanaPrincipal menu;
    private ControlVentanaPrincipal controlMenu;
    
    public ControlVentanaPrincipalTest() {
    }
    @Before
    public void setup() {
        // Inicializar el objeto Menu para la prueba
        menu = new VentanaPrincipal();
        controlMenu = new ControlVentanaPrincipal(menu);
    }
     
     
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        ControlVentanaPrincipal instance = null;
        instance.actionPerformed(e);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAccionarBotonUsuarios() {
        ActionEvent event = new ActionEvent(menu.getMenuUsuario(), ActionEvent.ACTION_PERFORMED, "");
        controlMenu.actionPerformed(event);
        assertEquals(1460, menu.getPanelUsuario().getWidth());
        assertEquals(720, menu.getPanelUsuario().getHeight());
        assertEquals(0, menu.getPanelUsuario().getLocation().x);
        assertEquals(0, menu.getPanelUsuario().getLocation().y);

    }

    @Test
    public void testAccionarBotonObra() {
        ActionEvent event = new ActionEvent(menu.getMenuObra(), ActionEvent.ACTION_PERFORMED, ""); 
        controlMenu.actionPerformed(event);
        assertEquals(1460, menu.getPanelObra().getWidth());
        assertEquals(720, menu.getPanelObra().getHeight());
        assertEquals(0, menu.getPanelObra().getLocation().x);
        assertEquals(0, menu.getPanelObra().getLocation().y);
        
    }

    @Test
    public void testAccionarBotonFuncion() {
        ActionEvent event = new ActionEvent(menu.getMenuFuncion(), ActionEvent.ACTION_PERFORMED, ""); 
        controlMenu.actionPerformed(event);
        assertEquals(1460,  menu.getPanelFuncion().getWidth());
        assertEquals(720,  menu.getPanelFuncion().getHeight());
        assertEquals(0,  menu.getPanelFuncion().getLocation().x);
        assertEquals(0,  menu.getPanelFuncion().getLocation().y);
    }

    @Test
    public void testAccionarBotonBoleto() {
        ActionEvent event = new ActionEvent(menu.getMenuBoleto(), ActionEvent.ACTION_PERFORMED, ""); 
        controlMenu.actionPerformed(event);
        assertEquals(1460,  menu.getPanelBoleto().getWidth());
        assertEquals(720,  menu.getPanelBoleto().getHeight());
        assertEquals(0,  menu.getPanelBoleto().getLocation().x);
        assertEquals(0,  menu.getPanelBoleto().getLocation().y);
    }

    @Test
    public void testAccionarBotonPago() {
        ActionEvent event = new ActionEvent(menu.getMenuPago(), ActionEvent.ACTION_PERFORMED, ""); 
        controlMenu.actionPerformed(event);
        assertEquals(1460,  menu.getPanelPago().getWidth());
        assertEquals(720,  menu.getPanelPago().getHeight());
        assertEquals(0,  menu.getPanelPago().getLocation().x);
        assertEquals(0,  menu.getPanelPago().getLocation().y);
    }

    @Test
    public void testAccionarBotonReporte() {
        ActionEvent event = new ActionEvent(menu.getMenuReporte(), ActionEvent.ACTION_PERFORMED, ""); 
        controlMenu.actionPerformed(event);
        assertEquals(1460,  menu.getPanelReportes().getWidth());
        assertEquals(720,  menu.getPanelReportes().getHeight());
        assertEquals(0,  menu.getPanelReportes().getLocation().x);
        assertEquals(0,  menu.getPanelReportes().getLocation().y);
    }
   
    @Test
    public void testBorrarTextoControlPago() {
        menu.getPanelPago().getTxtAreaBoletos().setText("h");
        menu.getPanelPago().getTxtAreaTicket().setText("h");
        menu.getPanelPago().getTxtCambio().setText("h");
        menu.getPanelPago().getTxtEfectivoRecibido().setText("h");
        
        String resultadoEsperado = "";
        controlMenu.borrarTextoControlPago();
        assertEquals(resultadoEsperado,  menu.getPanelPago().getTxtAreaBoletos().getText());
        assertEquals(resultadoEsperado,  menu.getPanelPago().getTxtAreaTicket().getText());
        assertEquals(resultadoEsperado,  menu.getPanelPago().getTxtCambio().getText());
        assertEquals(resultadoEsperado,  menu.getPanelPago().getTxtEfectivoRecibido().getText());
    }
    
}
