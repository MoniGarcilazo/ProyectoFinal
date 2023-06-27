/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.DaoLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Usuario;
import ventanas.Login;
import javax.swing.JOptionPane;
import modelo.Funcion;
import modelo.ObraTeatral;
import ventanas.VentanaPrincipal;

/**
 *
 * @author josep
 */
public class ControlLogin implements ActionListener{
    
    Login login = new Login();
    DaoLogin daoLogin = new DaoLogin();
    
    VentanaPrincipal menu = new VentanaPrincipal();
    ControlVentanaPrincipal controlMenu = new ControlVentanaPrincipal(menu);

    Usuario usuario = new Usuario();
    ControlUsuario controlUsuario = new ControlUsuario( usuario, menu);
                        
    ObraTeatral obra = new ObraTeatral();                     
    ControlObras controlObra = new ControlObras( obra, menu);
                        
    Funcion funcion = new Funcion();
    ControlFuncion controlFuncion = new ControlFuncion(funcion, menu);
                        
//    Boleto boleto = new Boleto();
//    ControlVentaBoleto controlVentaBoleto = new ControlVentaBoleto(boleto, menu);
  
    

    public ControlLogin( Login login) {
        
        this.login = login;
        this.login.getBtnIniciarSesion().addActionListener(this);
        this.login.getBtnSalir().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        accionarBotonSalir(e);
        accionarBotonIniciarSesion(e);
    }
    
    public void accionarBotonSalir(ActionEvent e){
        if(this.login.getBtnSalir() == e.getSource()) {
            System.exit(0);
        }
    }
    
    public void accionarBotonIniciarSesion(ActionEvent e){
        if ( login.getBtnIniciarSesion() == e.getSource()) {      
            capturarDatos();
            
           Usuario usuarioAux = daoLogin.autentificarUsuario(this.usuario);
           verificarRolUsuario(usuarioAux);
            
        }
    }
    public void verificarRolUsuario(Usuario usuario){
        if (  null != usuario.getRol()) 
            switch (usuario.getRol()) {
                case "Administrador":
                    menu.setVisible(true);
                    login.dispose();
                    break;
                case "Vendedor":
                    menu.getMenuUsuario().setEnabled(false);
                    menu.getMenuFuncion().setEnabled(false);
                    menu.getMenuObra().setEnabled(false);
                    menu.setVisible(true);
                    login.dispose();
                    break;
                case "nada":
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectas");
                    break;
                default:
                    break;
            }
    }
   
    
    public void capturarDatos( ) {
        usuario.setUsuario(login.getTxtUsuarioLogin().getText());
        usuario.setContraseña(login.getTxtPassword().getText());
    }
    
}
