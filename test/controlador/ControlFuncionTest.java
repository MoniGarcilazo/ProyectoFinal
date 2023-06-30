/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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
        ControlFuncion instance = null;
        instance.agregarFuncion();
        fail("The test case is a prototype.");
    }





    @Test
    public void testAgregarFuncion_NumFuncionesMenosDeDos() {
        // Arrange
        MiClase miClase = new MiClase();
        DAO.DaoFuncion daoFuncionMock = mock(DAO.DaoFuncion.class);
        DAOAsientos daoAsientosMock = mock(DAOAsientos.class);
        Menu menuMock = mock(Menu.class);
        PanelFuncion panelFuncionMock = mock(PanelFuncion.class);
        JTable tblFuncionesMock = mock(JTable.class);

        miClase.setDaoFuncion(daoFuncionMock);
        miClase.setDaoAsientos(daoAsientosMock);
        miClase.setMenu(menuMock);
        when(menuMock.getPanelFuncion()).thenReturn(panelFuncionMock);
        when(panelFuncionMock.getTblFunciones()).thenReturn(tblFuncionesMock);
        
        Funcion funcion = new Funcion();
        funcion.setFecha("2023-06-29");
        funcion.setHorario("18:00");
        when(daoFuncionMock.verificarFuncionesPorDia(funcion)).thenReturn(0);
        when(daoFuncionMock.verificarHorariosFunciones(funcion)).thenReturn(0);
        
        // Act
        miClase.agregarFuncion();

        // Assert
        verify(daoFuncionMock).agregarFuncion(funcion);
        verify(daoAsientosMock).agregarSala(anyInt());
        verify(daoFuncionMock).cargarTabla(tblFuncionesMock);
        assertNull(miClase.getFuncion());
    }
    
    @Test
    public void testAgregarFuncion_NumFuncionesMasDeDos() {
        // Arrange
        MiClase miClase = new MiClase();
        DAO.DAOFuncion daoFuncionMock = mock(DAOFuncion.class);
        Menu menuMock = mock(Menu.class);

        miClase.setDaoFuncion(daoFuncionMock);
        miClase.setMenu(menuMock);
        
        Funcion funcion = new Funcion();
        funcion.setFecha("2023-06-29");
        funcion.setHorario("18:00");
        when(daoFuncionMock.verificarFuncionesPorDia(funcion)).thenReturn(3);
        
        // Act
        miClase.agregarFuncion();

        // Assert
        verify(daoFuncionMock, never()).agregarFuncion(funcion);
        verify(menuMock, never()).getPanelFuncion();
        verifyNoMoreInteractions(daoFuncionMock);
    }



    @Test
    public void testModificarFuncion() {
        System.out.println("modificarFuncion");
        ControlFuncion instance = null;
        instance.modificarFuncion();
        fail("The test case is a prototype.");
    }

    @Test
    public void testEliminarFuncion() {
        System.out.println("eliminarFuncion");
        ControlFuncion instance = null;
        instance.eliminarFuncion();
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
