/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.DaoFuncion;
import DAO.DaoObras;
import DAO.DaoVentaBoleto;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import modelo.Boleto;
import utils.GestorVentanas;
import vista.Login;
import vista.RegistroBoleto;
import vista.Sala;
import vista.VentanaPrincipal;

/**
 *Clase que controla la ventana principal
 */
public class ControlVentanaPrincipal implements ActionListener {
    
    VentanaPrincipal menu = new VentanaPrincipal();
    DaoFuncion daoFuncion = new DaoFuncion();
    DaoObras daoObra = new DaoObras();
    DaoVentaBoleto daoVentaBoleto = new DaoVentaBoleto();

    /**
     * Método constructor de la clase ControlVentanaPrincipal, este le asigna a los bonotes de los paneles el ActionListener
     * @param menu Ventana principal requerida para todas las acciones 
     **/
    public ControlVentanaPrincipal( VentanaPrincipal menu ) {
        
        this.menu = menu;
        
        this.menu.getMenuUsuario().addActionListener(this);
        this.menu.getMenuObra().addActionListener(this);
        this.menu.getMenuFuncion().addActionListener(this);
        this.menu.getMenuReporte().addActionListener(this);
        this.menu.getPanelReportes().getBtnReporteMensual().addActionListener(this);
        this.menu.getMenuBoleto().addActionListener(this);
        this.menu.getPanelBoleto().getBtnHorario1().addActionListener(this);
        this.menu.getPanelBoleto().getBtnHorario2().addActionListener(this);
        this.menu.getMenuPago().addActionListener(this);
        this.menu.getMenuRegistro().addActionListener(this);
        this.menu.getSala().getBtnAceptar() .addActionListener(this);
        this.menu.getBtnLogOut() .addActionListener(this);
        this.menu.getBtnSalir() .addActionListener(this);
         
    }

    
    
    /**
     * Método que detecta las pulsaciones de los botones 
     * @param e ActionEvent requerida para todas las acciones  
     **/
    @Override
    public void actionPerformed(ActionEvent e) {      
        boolean accionarBotonUsuario = this.menu.getMenuUsuario() == e.getSource() ;
        boolean accionarBotonObra = this.menu.getMenuObra()== e.getSource() ;
        boolean accionarBotonFuncion = this.menu.getMenuFuncion()== e.getSource();
        boolean accionarBotonBoleto = this.menu.getMenuBoleto() == e.getSource();
        boolean accionarBotonPago =  this.menu.getMenuPago() == e.getSource();
        boolean accionarBotonReporte = this.menu.getMenuReporte() == e.getSource();
        boolean accionarBotonSalir = this.menu.getBtnSalir() == e.getSource();
        boolean accionarBotonDesLoguear =  this.menu.getBtnLogOut() == e.getSource();
        
        if (accionarBotonUsuario) {
            accionarBotonUsuarios();        
        }
        if (accionarBotonObra) {
            accionarBotonObra();
        }
        if (accionarBotonFuncion) {
            accionarBotonFuncion();       
        }
        if(accionarBotonBoleto) {
            accionarBotonBoleto();   
        }
        if (accionarBotonPago) {
            accionarBotonPago();       
        }
        if (accionarBotonReporte) {
            accionarBotonReporte();
        }
         if(accionarBotonSalir) {
             System.exit(0);
         }     
         if (accionarBotonDesLoguear) {
            accionarBotonDeslogear();
         }
    }
    
    /**
     * Método que muestra la ventana Usuarios  
     **/
    public void accionarBotonUsuarios() {
        GestorVentanas.asignarPosicionVentana(this.menu.getPanelUsuario());
        GestorVentanas.mostrarNuevaVentana(this.menu.getPanelUsuario(), menu);
    }
    
    /**
     * Método que muestra la ventana Obras 
     **/
    public void accionarBotonObra() {
        GestorVentanas.asignarPosicionVentana(this.menu.getPanelObra());
        GestorVentanas.mostrarNuevaVentana(this.menu.getPanelObra(), menu);
        this.menu.getPanelObra().setTblObras(daoObra.cargarTabla(menu.getPanelObra().getTblObras()));
    }

    /**
     * Método que muestra la ventana Funciones  
     **/
    public void accionarBotonFuncion() {
        GestorVentanas.asignarPosicionVentana(this.menu.getPanelFuncion());
        GestorVentanas.mostrarNuevaVentana(this.menu.getPanelFuncion(), menu);
        menu.getPanelFuncion().getComboBoxObras().removeAllItems();
        menu.getPanelFuncion().setComboBoxObras(daoFuncion.cargarComboBox(menu.getPanelFuncion().getComboBoxObras()));
        daoFuncion.cargarTabla(menu.getPanelFuncion().getTblFunciones());
    }

    /**
     * Método que muestra la ventana Boleto 
     **/
    public void accionarBotonBoleto() {
        crearPanelBoleto();
        GestorVentanas.asignarPosicionVentana(this.menu.getPanelBoleto());
        GestorVentanas.mostrarNuevaVentana(this.menu.getPanelBoleto(), menu);
        Sala sala = new Sala();
        this.menu.setSala(sala);
        borrarTextoControlPago();
        ControlVentaBoleto controlVentaBoleto = new ControlVentaBoleto(this.menu);
    }

    /**
     * Método que muestra la ventana Pago 
     **/
    public void accionarBotonPago() {
        GestorVentanas.asignarPosicionVentana(this.menu.getPanelPago());
        GestorVentanas.mostrarNuevaVentana(this.menu.getPanelPago(), menu);
    }

    /**
     * Método que muestra la ventana Reportes 
     **/
    public void accionarBotonReporte() {
        GestorVentanas.asignarPosicionVentana(this.menu.getPanelReportes());
        GestorVentanas.mostrarNuevaVentana(this.menu.getPanelReportes(), menu);
    }

    /**
     * Método que regresa a la ventana Login 
     **/
    public void accionarBotonDeslogear() {
        Login login = new Login();
        ControlLogin controlLogin = new ControlLogin(login);
        login.setVisible(true);
        this.menu.dispose();
    }

    /**
     * Método que resetea todos los textos de la ventana Pago
     **/
    public void borrarTextoControlPago(){
        menu.getPanelPago().getTxtAreaBoletos().setText("");
        menu.getPanelPago().getTxtAreaTicket().setText("");
        menu.getPanelPago().getTxtCambio().setText("");
        menu.getPanelPago().getTxtEfectivoRecibido().setText("");
    }

    /**
     * Método que instancia la ventana Boleto
     **/
    public void crearPanelBoleto(){
        RegistroBoleto panelBoleto = new RegistroBoleto();
        this.menu.setPanelBoleto(panelBoleto);
    }

}