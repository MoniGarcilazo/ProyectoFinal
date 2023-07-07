
package modelo;

/**
 *
 * @author Monica GarcilaO
 */
public class Administrador extends Usuario { 

    public Administrador(int ID, String nombre, String apellido, String CURP, String nombreUsuario, String contraseña, String rol, String usuario) {
        super(ID, nombre, apellido, CURP, 
             nombreUsuario, contraseña, rol, usuario);
    }

    public Administrador() {
    }
   
}
