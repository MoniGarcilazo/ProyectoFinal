/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controlador;

import DAO.DaoUsuario;
import java.awt.event.ActionEvent;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import vista.VentanaPrincipal;

/**
 *
 * @author benit
 */
public class ControlUsuarioTest {
    private VentanaPrincipal menu;
    private ControlVentanaPrincipal controlMenu;
    private DaoUsuario daoUsuario;
    
    
    
    
    public ControlUsuarioTest() {
    }
    
    @Before
    public void setUp() {
        menu = new VentanaPrincipal();
        daoUsuario = new DaoUsuario();
        controlMenu = new ControlVentanaPrincipal(menu);
    }
    
    @Test
    public void hello(){
        System.out.println("Test");
    }
    
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        ControlVentanaPrincipal instance = null;
        instance.actionPerformed(e);
        fail("Prototipo");
    }
    
    
}
