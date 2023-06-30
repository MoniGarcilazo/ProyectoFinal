/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.DaoUsuario;
import Exceptions.CamposObligatoriosException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Usuario;
import vista.VentanaPrincipal;

/**
 *
 * @author josep
 */
public class ControlUsuario implements ActionListener,  MouseListener {
    
    Usuario usuario = null;
    VentanaPrincipal menu = new VentanaPrincipal();
    DaoUsuario daoUsuario = new DaoUsuario();

    public ControlUsuario(Usuario usuario, VentanaPrincipal menu) {
        
        this.usuario = usuario;
        this.menu = menu;
//        this.menu.setPanelUsuario(registroUsuario);
        //Establecerle a la tabla de mi vista los datos de la tabla.
         this.menu.getPanelUsuario().setTblUsuarios(daoUsuario.cargarTabla(menu.getPanelUsuario().getTblUsuarios()));
        
        this.menu.getPanelUsuario().getBtnAgregar().addActionListener(this);
        this.menu.getPanelUsuario().getBtnEliminar().addActionListener(this);
        this.menu.getPanelUsuario().getBtnModificar().addActionListener(this);
        this.menu.getPanelUsuario().getBtnLimpiar().addActionListener(this);
        //Añadir MouseListener a la tabla
        this.menu.getPanelUsuario().getTblUsuarios().addMouseListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent evento) { 
        
        //Agregar Usuario
        if( this.menu.getPanelUsuario().getBtnAgregar() == evento.getSource()    ) {  
            try
            {
                capturarDatos();
                if( this.usuario != null) {
                    daoUsuario.agregarUsuario(usuario);
                    limpiar();
                    daoUsuario.cargarTabla(menu.getPanelUsuario().getTblUsuarios());
                    this.usuario = null;
                }
            
            } catch(CamposObligatoriosException e ){
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            } catch(NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese los datos con el formato correcto");
            }
        
        }
        //Modificar Usuario
        if( this.menu.getPanelUsuario().getBtnModificar() == evento.getSource()    ) {
           
            try {
                  capturarDatos();
                  usuario.setID(Integer.parseInt(menu.getPanelUsuario().getTxtID().getText()) );
                daoUsuario.modificarUsuario(usuario);
                limpiar();
               daoUsuario.cargarTabla(menu.getPanelUsuario().getTblUsuarios());
               this.usuario = null;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado algún usuario");
            }
        
        }
        
        if( this.menu.getPanelUsuario().getBtnEliminar() == evento.getSource()   ) { 
            try {
                
                capturarDatos();
                usuario.setID(Integer.parseInt(menu.getPanelUsuario().getTxtID().getText()) );
                daoUsuario.eliminarUsuario(usuario);
                limpiar();
                daoUsuario.cargarTabla(menu.getPanelUsuario().getTblUsuarios());   
                this.usuario = null;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado algún usuario");
            }
         
        }
        
        if( this.menu.getPanelUsuario().getBtnLimpiar() == evento.getSource()    ) {  
         limpiar();  
         daoUsuario.cargarTabla(menu.getPanelUsuario().getTblUsuarios());   
         this.usuario = null;
        }
        
        
    }
    
    
    public void limpiar ( ) {
        
        menu.getPanelUsuario().getTxtNombre().setText("");
        menu.getPanelUsuario().getTxtApellido().setText("");
        menu.getPanelUsuario().getTxtCURP().setText("");
       
        menu.getPanelUsuario().getTxtUsuario().setText("");
        menu.getPanelUsuario().getTxtContraseña().setText("");

        menu.getPanelUsuario().getBtnGr().clearSelection();
    }
    
    public void capturarDatos() throws CamposObligatoriosException, NullPointerException {
        
        this.usuario = new Usuario();
                this.usuario.setNombre(menu.getPanelUsuario().getTxtNombre().getText());  
                this.usuario.setApellido(menu.getPanelUsuario().getTxtApellido().getText());
                this.usuario.setCURP(menu.getPanelUsuario().getTxtCURP().getText());
        
            if (menu.getPanelUsuario().getRbAdmin().isSelected() == true)
            {
                 this.usuario.setRol("Administrador");
            } else if (menu.getPanelUsuario().getRbVendedor().isSelected() == true)
            {
                  this.usuario.setRol("Vendedor");
            } else
            {
                 this.usuario.setRol("Vendedor");
            }
        
                this.usuario.setUsuario(  menu.getPanelUsuario().getTxtUsuario().getText() );
                this.usuario.setContraseña(menu.getPanelUsuario().getTxtContraseña().getText() );
            
        
    }
    

    //Crear la accion de click en mi tabla, funcion de MouseListener para mi tabla
    @Override
    public void mouseClicked(MouseEvent e) {
        this.usuario = daoUsuario.regresarDatosEnCasillas(menu.getPanelUsuario().getTblUsuarios());
        menu.getPanelUsuario().getTxtID().setText(String.valueOf(usuario.getID()));
        menu.getPanelUsuario().getTxtNombre().setText(usuario.getNombre());
        menu.getPanelUsuario().getTxtApellido().setText(usuario.getApellido());
        menu.getPanelUsuario().getTxtCURP().setText(usuario.getCURP());
        menu.getPanelUsuario().getTxtUsuario().setText(usuario.getUsuario());
        menu.getPanelUsuario().getTxtContraseña().setText(usuario.getContraseña());
        
        if(usuario.getRol().equals("Administrador")) {
                   menu.getPanelUsuario().getRbAdmin().setSelected(true);
               } else if (usuario.getRol().equals("Vendedor")) {
                   menu.getPanelUsuario().getRbVendedor().setSelected(true);
               }
    }

    
    
    
    
    
    
    
    
    
    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
      
    }
}
