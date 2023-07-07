}
package modelo;

import Exceptions.CamposObligatoriosException;

/**
 *
 * @author josep
 */
public class Usuario {
    
    private int ID;
    
    private String nombre;
    
    private String apellido;
    
    private String CURP;
    
    private String nombreUsuario;
    
    private String contraseña;
    
    private String rol;
    
    private String usuario;

    // CONSTRUCTORES
    public Usuario() {
    }
    
    public Usuario(int ID, String nombre, String apellido, String CURP, String nombreUsuario, String contraseña, String rol, String usuario) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.CURP = CURP;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.rol = rol;
        this.usuario = usuario;
    }
    
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
          if( " ".equals(usuario)){
            throw new CamposObligatoriosException();
        }else{
           if("".equals(usuario)){
               throw new CamposObligatoriosException();
           }else{
             this.usuario = usuario;
           }
        }
       
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // SETTER'S AND GETTER'S
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
          if( " ".equals(nombre)){
            throw new CamposObligatoriosException();
        }else{
           if("".equals(nombre)){
               throw new CamposObligatoriosException();
           }else{
            this.nombre = nombre;
           }
        }
        
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
          if( " ".equals(apellido)){
            throw new CamposObligatoriosException();
        }else{
           if("".equals(apellido)){
               throw new CamposObligatoriosException();
           }else{
              this.apellido = apellido;
           }
        }
      
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
          if( " ".equals(CURP)){
            throw new CamposObligatoriosException();
        }else{
           if("".equals(CURP)){
               throw new CamposObligatoriosException();
           }else{
             this.CURP = CURP;
           }
        }
       
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
          if( " ".equals(nombreUsuario)){
            throw new CamposObligatoriosException();
        }else{
           if("".equals(nombreUsuario)){
               throw new CamposObligatoriosException();
           }else{
             this.nombreUsuario = nombreUsuario;
           }
        }
       
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
          if( " ".equals(contraseña)){
            throw new CamposObligatoriosException();
        }else{
           if("".equals(contraseña)){
               throw new CamposObligatoriosException();
           }else{
              this.contraseña = contraseña;
           }
        }
      
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    
    
    
    
    
}
