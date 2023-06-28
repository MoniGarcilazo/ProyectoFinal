/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import controlador.ControlLogin;
import controlador.ControlObras;
import controlador.ControlUsuario;
import java.beans.Visibility;
import modelo.ObraTeatral;
import modelo.Usuario;
import vista.Login;
import vista.RegistroUsuario;
import vista.VentanaPrincipal;

/**
 *
 * @author josep
 */
public class MainPrueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Usuario usuario = new Usuario();
//        RegistroUsuario vistaUsuario = new RegistroUsuario();
//        VentanaPrincipal menu = new VentanaPrincipal();
//        ControlUsuario control = new ControlUsuario( usuario, menu,  vistaUsuario);
//        
//        
//        menu.setVisible(true);
        
//        ObraTeatral obra = new ObraTeatral();
//        FormularioObras vistaObras = new FormularioObras();
//        ControlObras controlObras = new ControlObras(obra, vistaObras);
//        
//        vistaObras.setVisible(true);
        
        
        Login login = new Login();
        ControlLogin control = new ControlLogin( login );
        
        login.setVisible(true);
        
    }
    
}
