
package controlador;

import daos.DaoUsuario;
import exception.CamposObligatoriosException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Usuario;
import vista.VentanaPrincipal;


/**
 * 
 * Clase que controla la sección de usuarios
 */
public class ControlUsuario implements ActionListener, MouseListener {

    Usuario usuario;
    
    VentanaPrincipal menu = new VentanaPrincipal();
    
    DaoUsuario daoUsuario = new DaoUsuario();    
    
    /**
     * Constructor de la clase ControlUsuario
     * @param usuario con el que se comunicará los botones
     * @param menu, o interfaz gráfica para las acciones
     */
    public ControlUsuario(Usuario usuario, VentanaPrincipal menu) {

        this.usuario = usuario;
        this.menu = menu;

        this.menu.getPanelUsuario().setTblUsuarios(daoUsuario.cargarTabla(menu.getPanelUsuario().getTblUsuarios()));

        this.menu.getPanelUsuario().getBtnAgregar().addActionListener(this);
        this.menu.getPanelUsuario().getBtnEliminar().addActionListener(this);
        this.menu.getPanelUsuario().getBtnModificar().addActionListener(this);
        this.menu.getPanelUsuario().getBtnLimpiar().addActionListener(this);

        this.menu.getPanelUsuario().getTblUsuarios().addMouseListener(this);
    }

    /**
     * Metodo que detecta el uso de botones
     * @param evento o acción de los botones
     */
    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.menu.getPanelUsuario().getBtnAgregar()) {
            try {
                capturarDatos();
                if (this.usuario != null) {
                    daoUsuario.agregarUsuario(usuario);
                    limpiar();
                    daoUsuario.cargarTabla(menu.getPanelUsuario().getTblUsuarios());
                    this.usuario = null;
                }

            } catch (CamposObligatoriosException e) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese los datos con el formato correcto");
            }

        }
        if (evento.getSource() == this.menu.getPanelUsuario().getBtnModificar()) {

            try {
                capturarDatos();
                usuario.setID(Integer.parseInt(menu.getPanelUsuario().getTxtID().getText()));
                daoUsuario.modificarUsuario(usuario);
                limpiar();
                daoUsuario.cargarTabla(menu.getPanelUsuario().getTblUsuarios());
                this.usuario = null;
            } catch (CamposObligatoriosException | NullPointerException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado algún usuario");
            }

        }

        if (evento.getSource() == this.menu.getPanelUsuario().getBtnEliminar()) {
            try {

                capturarDatos();
                usuario.setID(Integer.parseInt(menu.getPanelUsuario().getTxtID().getText()));
                daoUsuario.eliminarUsuario(usuario);
                limpiar();
                daoUsuario.cargarTabla(menu.getPanelUsuario().getTblUsuarios());
                this.usuario = null;
            } catch (CamposObligatoriosException | NullPointerException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado algún usuario");
            }

        }

        if (evento.getSource() == this.menu.getPanelUsuario().getBtnLimpiar()) {
            limpiar();
            daoUsuario.cargarTabla(menu.getPanelUsuario().getTblUsuarios());
            this.usuario = null;
        }

    }
    
    /**
     * Metodo para limpiar los campos del menú
     */
    public void limpiar() {

        menu.getPanelUsuario().getTxtNombre().setText("");
        menu.getPanelUsuario().getTxtApellido().setText("");
        menu.getPanelUsuario().getTxtCURP().setText("");

        menu.getPanelUsuario().getTxtUsuario().setText("");
        menu.getPanelUsuario().getTxtContraseña().setText("");

        menu.getPanelUsuario().getBtnGr().clearSelection();
    }
    
    /**
     * Metodo que captura la información del usuario
     * @throws CamposObligatoriosException en caso de que los campos no se hayan llenado en su totalidad
     * @throws NullPointerException en caso de que el método se encuentre con apuntadores nulos
     */
    public void capturarDatos() throws CamposObligatoriosException, NullPointerException {

        this.usuario = new Usuario();
        this.usuario.setNombre(menu.getPanelUsuario().getTxtNombre().getText());
        this.usuario.setApellido(menu.getPanelUsuario().getTxtApellido().getText());
        this.usuario.setCURP(menu.getPanelUsuario().getTxtCURP().getText());

        if (menu.getPanelUsuario().getRbAdmin().isSelected()) {
            this.usuario.setRol("Administrador");
        } else if (menu.getPanelUsuario().getRbVendedor().isSelected()) {
            this.usuario.setRol("Vendedor");
        } else {
            this.usuario.setRol("Vendedor");
        }

        this.usuario.setUsuario(menu.getPanelUsuario().getTxtUsuario().getText());
        this.usuario.setContraseña(menu.getPanelUsuario().getTxtContraseña().getText());

    }
    /**
     * Método que detecta los datos seleccionados y los muestra en pantalla
     * @param event detección de puntero accionado
     */
    
    @Override
    public void mouseClicked(MouseEvent event) {
        this.usuario = daoUsuario.regresarDatosEnCasillas(menu.getPanelUsuario().getTblUsuarios());
        menu.getPanelUsuario().getTxtID().setText(String.valueOf(usuario.getID()));
        menu.getPanelUsuario().getTxtNombre().setText(usuario.getNombre());
        menu.getPanelUsuario().getTxtApellido().setText(usuario.getApellido());
        menu.getPanelUsuario().getTxtCURP().setText(usuario.getCURP());
        menu.getPanelUsuario().getTxtUsuario().setText(usuario.getUsuario());
        menu.getPanelUsuario().getTxtContraseña().setText(usuario.getContraseña());

        if (usuario.getRol().equals("Administrador")) {
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
