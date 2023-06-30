/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controlador;

import DAO.DaoUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
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
    public void testActionPerformed(ActionEvent event) {
        System.out.println("actionPerformed");
        ControlVentanaPrincipal instance = null;
        instance.actionPerformed(event);
        fail("Prototipo");
    }
    
    @Test
    public void testCapturarDatos(){
        System.out.println("capturarDatos");
        ControlUsuario instance = null;
        instance.capturarDatos();
        fail("Prototipo");
    }
    
    @Test
    public void testMouseClicked(MouseEvent event){
        System.out.println("mouseClicked");
        ControlFuncion instance = null;
        instance.mouseClicked(event);
        fail("Prototipo");
    }
    
}
