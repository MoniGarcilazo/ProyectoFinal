/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.DaoObras;
import Exceptions.CamposObligatoriosException;
import Exceptions.TiempoMaximoException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.ObraTeatral;
import vista.VentanaPrincipal;

/**
 *Clase que controla la ventana Obras
 */
public class ControlObras implements ActionListener, MouseListener {
    
    ObraTeatral obra = null;
    VentanaPrincipal menu = new VentanaPrincipal();
    DaoObras daoObra = new DaoObras();
    
    /**
     * Método constructor de la clase ControlObras, este le asigna a los bonotes de los paneles el ActionListener
     * @param obra Obra Teatral que se utiliza para las acciones de los botones
     * @param menu Ventana principal requerida para todas las acciones 
     **/
    public ControlObras(ObraTeatral obra, VentanaPrincipal menu) {
        
        this.obra = obra;
        this.menu = menu;
        
        //Establecerle a la tabla de mi vista los datos de la tabla.
        this.menu.getPanelObra().setTblObras(daoObra.cargarTabla(menu.getPanelObra().getTblObras()));
        
        this.menu.getPanelObra().getBtnAgregar().addActionListener(this);
        this.menu.getPanelObra().getBtnEliminar().addActionListener(this);
        this.menu.getPanelObra().getBtnModificar().addActionListener(this);
        this.menu.getPanelObra().getBtnLimpiar().addActionListener(this);
        //Añadir MouseListener a la tabla
        this.menu.getPanelObra().getTblObras().addMouseListener(this);
        limpiar();
    }
    
    
    /**
     * Método que detecta las pulsaciones de los botones 
     * @param e ActionEvent requerida para todas las acciones  
     **/
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean accionarBotonAgregar = this.menu.getPanelObra().getBtnAgregar() == e.getSource();
        boolean accionarBotonModificar = this.menu.getPanelObra().getBtnModificar() == e.getSource();
        boolean accionarBotonEliminar = this.menu.getPanelObra().getBtnEliminar() == e.getSource();
        boolean accionarBotonLimpiar = this.menu.getPanelObra().getBtnLimpiar() == e.getSource(); 
        
       if (accionarBotonAgregar) {
            accionarBotonAgregar();
       }
       if (accionarBotonModificar) {
            accionarBotonModificar();
       }
       if (accionarBotonEliminar) {
            accionarBotonEliminar();
       }
        if(accionarBotonLimpiar) { 
            resetearObra();
        }   
    }
    
    /**
     * Método que agrega una obra a la base de datos   
     **/
    public void accionarBotonAgregar() {
        try {
            agregarObra();
            resetearObra();
        } catch (CamposObligatoriosException e1) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
        } catch (TiempoMaximoException e2) {
            JOptionPane.showMessageDialog(null, "Duracion Incorrecta");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos con el formato correcto");
        }
    }

    /**
     * Método que modifica una obra de la base de datos   
     **/
    public void accionarBotonModificar() {
        try {
            modificarObra();
            resetearObra();
        } catch (CamposObligatoriosException e1) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
        } catch (TiempoMaximoException e2) {
            JOptionPane.showMessageDialog(null, "Duracion Incorrecta");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos con el formato correcto");
        }
    }

    /**
     * Método que elimina una obra de la base de datos   
     **/
    public void accionarBotonEliminar() {
        try {
            eliminarObra();
            resetearObra();
        } catch (CamposObligatoriosException e1) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
        } catch (TiempoMaximoException e2) {
            JOptionPane.showMessageDialog(null, "Duracion Incorrecta");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos con el formato correcto");
        }
    }

    /**
     * Método que captura los datos de la ventana para luego asignarselo a una obra para subirlo la base de datos   
     **/
    public void agregarObra() {
        capturarDatos();
        daoObra.agregarObra(obra);
    }

    /**
     * Método que captura los datos de la ventana para luego modificar esos datos de una obra de la base de datos   
     **/
    public void modificarObra() {
        capturarDatos();
        this.obra.setID(Integer.parseInt(menu.getPanelObra().getTxtID().getText()));
        this.daoObra.modificarObra(obra);
    }

    /**
     * Método que captura los datos de la ventana para luego eliminar esos datos de una obra de la base de datos   
     **/
    public void eliminarObra() {
        capturarDatos();
        this.obra.setID(Integer.parseInt(menu.getPanelObra().getTxtID().getText()));
        this.daoObra.eliminarObra(obra);
    }

    /**
     * Método que limpia los datos de la ventana y actualiza la tabla    
     **/
    public void resetearObra() {
        limpiar();
        cargarTabla();
        this.obra = null;
    }

    /**
     * Método que limpia los datos de la ventana
     **/
    public void limpiar() {
        menu.getPanelObra().getTxtID().setText("");
        menu.getPanelObra().getTxtNombreObra().setText("");
        menu.getPanelObra().getTxtGenero().setText("");
        menu.getPanelObra().getTxtResumen().setText("");
        menu.getPanelObra().getTxtDuracion().setText("");
        menu.getPanelObra().getTxtActorPrincipal().setText("");
        menu.getPanelObra().getTxtActorSecundario().setText("");
        menu.getPanelObra().getTxtPrecioBoleto().setText("");
    }

    /**
     * Método que captura los datos de la ventana para asignarselos a una obra
     **/
    public void capturarDatos() throws CamposObligatoriosException, TiempoMaximoException {
         this.obra = new ObraTeatral();
        this.obra.setNombreObra(menu.getPanelObra().getTxtNombreObra().getText());
        this.obra.setGenero(menu.getPanelObra().getTxtGenero().getText());
        this.obra.setResumen(menu.getPanelObra().getTxtResumen().getText());
        this.obra.setDuracion(Integer.parseInt(menu.getPanelObra().getTxtDuracion().getText()));
        this.obra.setActorPrincipal(menu.getPanelObra().getTxtActorPrincipal().getText());
        this.obra.setActorSecundario(menu.getPanelObra().getTxtActorSecundario().getText());
        this.obra.setPrecioBoleto(Double.parseDouble(menu.getPanelObra().getTxtPrecioBoleto().getText()));
    }

    /**
     * Método que detecta los datos que quieres seleccionar de la tabla y los muestra en lo texto de la ventana  
     **/
    @Override
    public void mouseClicked(MouseEvent e) {
        this.obra = daoObra.regresarDatosEnCasillas(menu.getPanelObra().getTblObras());

        menu.getPanelObra().getTxtID().setText(String.valueOf(obra.getID()));
        menu.getPanelObra().getTxtNombreObra().setText(obra.getNombreObra());
        menu.getPanelObra().getTxtGenero().setText(obra.getGenero());
        menu.getPanelObra().getTxtResumen().setText(obra.getResumen());
        menu.getPanelObra().getTxtDuracion().setText(String.valueOf(obra.getDuracion()));
        menu.getPanelObra().getTxtActorPrincipal().setText(obra.getActorPrincipal());
        menu.getPanelObra().getTxtActorSecundario().setText(obra.getActorSecundario());
        menu.getPanelObra().getTxtPrecioBoleto().setText(String.valueOf(obra.getPrecioBoleto()));
    }

    /**
     * Método que carga la tabla de las obras 
     **/
    public void cargarTabla() {
        this.daoObra.cargarTabla(menu.getPanelObra().getTblObras());
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