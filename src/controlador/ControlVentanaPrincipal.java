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
import modelo.Boleto;
import vista.Login;
import vista.RegistroBoleto;
import vista.Sala;
import vista.VentanaPrincipal;

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
        
        if (this.menu.getMenuUsuario() == e.getSource() ) {
            menu.getPanelUsuario().setSize(1460, 720);
            menu.getPanelUsuario().setLocation(0, 0);
      
            menu.getPanelContenido().removeAll();
            menu.getPanelContenido().add(menu.getPanelUsuario(), BorderLayout.CENTER);
            menu.getPanelContenido().revalidate();
            menu.getPanelContenido().repaint();
        }
        
        if (this.menu.getMenuObra()== e.getSource() ) {
            menu.getPanelObra().setSize(1460, 720);
            menu.getPanelObra().setLocation(0, 0);
      
            menu.getPanelContenido().removeAll();
            menu.getPanelContenido().add(menu.getPanelObra(), BorderLayout.CENTER);
            menu.getPanelContenido().revalidate();
            menu.getPanelContenido().repaint();
            
            //RESETEAR LA TABLA DE LAS OBRAS
            this.menu.getPanelObra().setTblObras(daoObra.cargarTabla(menu.getPanelObra().getTblObras()));
        }
        
        if (this.menu.getMenuFuncion()== e.getSource() ) {
            menu.getPanelFuncion().setSize(1460, 720);
            menu.getPanelFuncion().setLocation(0, 0);
      
            menu.getPanelContenido().removeAll();
            menu.getPanelContenido().add(menu.getPanelFuncion(), BorderLayout.CENTER);
            menu.getPanelContenido().revalidate();
            menu.getPanelContenido().repaint();
            
            //RESETEAR EL COMBOBOX DE LAS OBRAS EN EL PANEL DE FUNCIONES   
            menu.getPanelFuncion().getComboBoxObras().removeAllItems();
            menu.getPanelFuncion().setComboBoxObras(daoFuncion.cargarComboBox(menu.getPanelFuncion().getComboBoxObras()));
            
            //RESETEAR LA TABLA DE LAS FUNCIONES
            daoFuncion.cargarTabla(menu.getPanelFuncion().getTblFunciones());
        }

        
       if( this.menu.getMenuBoleto() == e.getSource()) {
           
           RegistroBoleto panelBoleto = new RegistroBoleto();
           menu.setPanelBoleto(panelBoleto);
           
           menu.getPanelBoleto().setSize(1460, 720);
            menu.getPanelBoleto().setLocation(0, 0);
      
            menu.getPanelContenido().removeAll();
            menu.getPanelContenido().add(menu.getPanelBoleto(), BorderLayout.CENTER);
            menu.getPanelContenido().revalidate();
            menu.getPanelContenido().repaint();
      
            // Borrar los botones de la sala cada vez que se desee volver a registrar una funcion
            Sala sala = new Sala();
            menu.setSala(sala);
            
            // BORRAR el texto del control de pago
            menu.getPanelPago().getTxtAreaBoletos().setText("");
            menu.getPanelPago().getTxtAreaTicket().setText("");
            menu.getPanelPago().getTxtCambio().setText("");
            menu.getPanelPago().getTxtEfectivoRecibido().setText("");
            
            Boleto boleto = new Boleto();
            ControlVentaBoleto controlVentaBoleto = new ControlVentaBoleto(boleto, menu);
           
    }
       
       
        if ( this.menu.getMenuPago() == e.getSource()) {

            menu.getPanelPago().setSize(1460, 720);
            menu.getPanelPago().setLocation(0, 0);

            menu.getPanelContenido().removeAll();
            menu.getPanelContenido().add(menu.getPanelPago(), BorderLayout.CENTER);
            menu.getPanelContenido().revalidate();
            menu.getPanelContenido().repaint();

        }

        if ( this.menu.getMenuReporte() == e.getSource()) {
            menu.getPanelReportes().setSize(1460, 720);
            menu.getPanelReportes().setLocation(0, 0);

            menu.getPanelContenido().removeAll();
            menu.getPanelContenido().add(menu.getPanelReportes(), BorderLayout.CENTER);
            menu.getPanelContenido().revalidate();
            menu.getPanelContenido().repaint();
        }
       

        if( this.menu.getBtnSalir() == e.getSource()) { //Presionar boton cerrar programa
            System.exit(0);
        }
        
        if ( this.menu.getBtnLogOut() == e.getSource()) {
            Login login = new Login();
            ControlLogin controlLogin = new ControlLogin(login);
            login.setVisible(true);
            this.menu.dispose();
        }
    


    }
}
