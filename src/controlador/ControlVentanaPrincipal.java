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
import ventanas.Login;
import ventanas.RegistroBoleto;
import ventanas.Sala;
import ventanas.VentanaPrincipal;

/**
 *
 * @author josep
 */
public class ControlVentanaPrincipal implements ActionListener {
    
    VentanaPrincipal menu = new VentanaPrincipal();
    DaoFuncion daoFuncion = new DaoFuncion();
    DaoObras daoObra = new DaoObras();
    DaoVentaBoleto daoVentaBoleto = new DaoVentaBoleto();

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

    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {      
        accionarBotonUsuarios(e);        
        accionarBotonObra(e);
        accionarBotonFuncion(e);       
        accionarBotonBoleto(e);        
        accionarBotonPago(e);       
        accionarBotonReporte(e);
        accionarBotonSalir(e);        
        accionarBotonDeslogear(e);
    }
    
    public void accionarBotonUsuarios(ActionEvent e){
        if (this.menu.getMenuUsuario() == e.getSource() ) {
            asignarPosicionVentana(this.menu.getPanelUsuario());
            mostrarNuevaVentana(this.menu.getPanelUsuario());
        }  
    }
    
    public void accionarBotonObra(ActionEvent e){
        if (this.menu.getMenuObra()== e.getSource() ) {
            asignarPosicionVentana(this.menu.getPanelObra());
            mostrarNuevaVentana(this.menu.getPanelObra());          
            //RESETEAR LA TABLA DE LAS OBRAS
            this.menu.getPanelObra().setTblObras(daoObra.cargarTabla(menu.getPanelObra().getTblObras()));
        }
    }
    
    public void accionarBotonFuncion(ActionEvent e){
        if (this.menu.getMenuFuncion()== e.getSource() ) {
            asignarPosicionVentana(this.menu.getPanelFuncion());
            mostrarNuevaVentana(this.menu.getPanelFuncion());
            
            //RESETEAR EL COMBOBOX DE LAS OBRAS EN EL PANEL DE FUNCIONES   
            menu.getPanelFuncion().getComboBoxObras().removeAllItems();
            menu.getPanelFuncion().setComboBoxObras(daoFuncion.cargarComboBox(menu.getPanelFuncion().getComboBoxObras()));
            
            //RESETEAR LA TABLA DE LAS FUNCIONES
            daoFuncion.cargarTabla(menu.getPanelFuncion().getTblFunciones());
        }
    }
    
    public void accionarBotonBoleto(ActionEvent e){
        if( this.menu.getMenuBoleto() == e.getSource()) {
            
            crearPanelBoleto();
            asignarPosicionVentana(this.menu.getPanelBoleto());           
            mostrarNuevaVentana(this.menu.getPanelBoleto());
            // Borrar los botones de la sala cada vez que se desee volver a registrar una funcion
            Sala sala = new Sala();
            this.menu.setSala(sala);
            borrarTextoControlPago();
            Boleto boleto = new Boleto();
            ControlVentaBoleto controlVentaBoleto = new ControlVentaBoleto(boleto, this.menu);      
        }
    }
    
    public void accionarBotonPago(ActionEvent e){
        if ( this.menu.getMenuPago() == e.getSource()) {
            asignarPosicionVentana(this.menu.getPanelPago());
            mostrarNuevaVentana(this.menu.getPanelPago());
        }
    }
    
    public void accionarBotonReporte(ActionEvent e){
        if ( this.menu.getMenuReporte() == e.getSource()) {
            asignarPosicionVentana(this.menu.getPanelReportes());           
            mostrarNuevaVentana(this.menu.getPanelReportes());        
        }
    }
    
    public void accionarBotonSalir(ActionEvent e){
       if( this.menu.getBtnSalir() == e.getSource()) { //Presionar boton cerrar programa
            System.exit(0);
        } 
    }
    
    public void accionarBotonDeslogear(ActionEvent e){
        if ( this.menu.getBtnLogOut() == e.getSource()) {
            Login login = new Login();
            ControlLogin controlLogin = new ControlLogin(login);
            login.setVisible(true);
            this.menu.dispose();
        }
    }
    
    public void borrarTextoControlPago(){
        // BORRAR el texto del control de pago
        menu.getPanelPago().getTxtAreaBoletos().setText("");
        menu.getPanelPago().getTxtAreaTicket().setText("");
        menu.getPanelPago().getTxtCambio().setText("");
        menu.getPanelPago().getTxtEfectivoRecibido().setText("");
    }
    
    public void asignarPosicionVentana(JPanel ventana){
        ventana.setSize(1460, 720);
        ventana.setLocation(0, 0);
    }
    
    public void crearPanelBoleto(){
        RegistroBoleto panelBoleto = new RegistroBoleto();
        this.menu.setPanelBoleto(panelBoleto);
    }
    
    public void mostrarNuevaVentana(JPanel ventana){
        this.menu.getPanelContenido().removeAll();
        this.menu.getPanelContenido().add(ventana, BorderLayout.CENTER);
        this.menu.getPanelContenido().revalidate();
        this.menu.getPanelContenido().repaint();
    }
}
