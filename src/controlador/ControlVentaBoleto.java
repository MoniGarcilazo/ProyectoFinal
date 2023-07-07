
package controlador;

import daos.DaoVentaBoleto;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Funcion;
import utils.GestorVentanas;
import vista.VentanaPrincipal;

/**
 *Clase que controla la ventana de ventas de boleto
 */
public class ControlVentaBoleto implements ActionListener {
    
    VentanaPrincipal menu = new VentanaPrincipal();
    
    DaoVentaBoleto daoVentaBoleto = new DaoVentaBoleto();
    
    Funcion funcion1 = new Funcion();
    
    Funcion funcion2 = new Funcion();
    
    ArrayList<Funcion> listaFunciones;
    
    ArrayList<Funcion> listaFuncionesPorDia;
    
    /**
     * Método constructor de la clase ControlObras, este le asigna a los bonotes de los paneles el ActionListener
     * @param menu Ventana principal requerida para todas las acciones 
     **/
    public ControlVentaBoleto(VentanaPrincipal menu) {
        this.menu = menu;
        
        this.menu.getPanelBoleto().setComboBoxFechasFunciones(daoVentaBoleto.cargarComboBox(menu.getPanelBoleto().getComboBoxFechasFunciones()));
        
        this.menu.getPanelBoleto().getComboBoxFechasFunciones().addActionListener(this);
        this.menu.getPanelBoleto().getBtnHorario1().addActionListener(this);
        this.menu.getPanelBoleto().getBtnHorario2().addActionListener(this);
        this.menu.getMenuBoleto().addActionListener(this);
        
    }
    
    /**
     * Método que detecta las pulsaciones de los botones 
     * @param e ActionEvent requerida para todas las acciones  
     **/
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(this.menu.getPanelBoleto().getComboBoxFechasFunciones() == e.getSource()) {
            accionarComboBoxFechas();
        }
        
        if(this.menu.getPanelBoleto().getBtnHorario1() == e.getSource() ) {           
            accionarBotonHorario(funcion1);
        }
        
        if(this.menu.getPanelBoleto().getBtnHorario2() == e.getSource() ) {
            accionarBotonHorario(funcion2);
        }
        
    }
    
    /**
     * Método que detecta que fecha se está seleccionando para mostrar las funciones que hay ese dia   
     **/
    public void accionarComboBoxFechas() {
        listaFunciones = new ArrayList<Funcion>();
        listaFuncionesPorDia = new ArrayList<Funcion>();

        listaFunciones = daoVentaBoleto.recuperarFunciones();
        String fecha = this.menu.getPanelBoleto().getComboBoxFechasFunciones().getSelectedItem().toString();
        listaFuncionesPorDia = selecFuncionesPorFecha(listaFunciones, fecha);
        
        
        switch(listaFuncionesPorDia.size()){
            case 1:
                funcion1 = listaFuncionesPorDia.get(0);
                mostrarInfoFuncion1(funcion1);
                
                String sinFuncion = "Sin funcion";
                mostrarInfoFuncion2(sinFuncion, sinFuncion, sinFuncion, "x");
                this.menu.getPanelBoleto().getBtnHorario2().setEnabled(false);
                break;
            case 2:
                funcion1 = listaFuncionesPorDia.get(0);
                mostrarInfoFuncion1(funcion1);
             
                funcion2 = listaFuncionesPorDia.get(1);
                mostrarInfoFuncion2(funcion2.getObra().getNombreObra(), String.valueOf(funcion2.getObra().getDuracion()),
                                    String.valueOf(funcion2.getHora()), String.valueOf((char) funcion2.getID()));
                this.menu.getPanelBoleto().getBtnHorario2().setEnabled(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "No hay funciones en esa fecha");
        }
    }
    
    /**
     * Método que muestra la informacion de la primera función 
     * @param funcion Funcion que se quiere mostar la información  
     **/
    public void mostrarInfoFuncion1(Funcion funcion) {
        this.menu.getPanelBoleto().getTxtNombreFuncion1().setText(funcion.getObra().getNombreObra());
        this.menu.getPanelBoleto().getTxtDuracionFuncion1().setText(String.valueOf(funcion.getObra().getDuracion()));
        this.menu.getPanelBoleto().getBtnHorario1().setText(String.valueOf(funcion.getHora()));
        this.menu.getPanelBoleto().getTxtIDFuncion1().setText(String.valueOf(funcion.getID()));
    }
    
    /**
     * Método que muestra la informacion de la segunda función 
     * @param nombreObra Cadena que representa el nombre de la obra
     * @param duracionObra Cadena que representa la duración de la obra
     * @param horaObra Cadena que representa la hora de la función
     * @param idObra Cadena que representa el ID de la función
     **/
    public void mostrarInfoFuncion2(String nombreObra, String duracionObra, String horaObra, String idObra) {
        this.menu.getPanelBoleto().getTxtNombreFuncion2().setText(nombreObra);
        this.menu.getPanelBoleto().getTxtDuracionFuncion2().setText(String.valueOf(duracionObra));
        this.menu.getPanelBoleto().getBtnHorario2().setText(String.valueOf(horaObra));
        this.menu.getPanelBoleto().getTxtIDFuncion2().setText(String.valueOf(idObra));
    }
    
    /**
     * Método que muestra la sala con sus asientos de la obra seleccionada 
     * @param funcion Funcion que se quiere mostar la información  
     **/
    public void accionarBotonHorario(Funcion funcion){
        try {
                if(!listaFuncionesPorDia.isEmpty()) {
                ControlAsientos controlAsientos = new ControlAsientos(menu , funcion);
                GestorVentanas.asignarPosicionVentana(menu.getSala());
                GestorVentanas.mostrarNuevaVentana(menu.getSala(), menu);
                } else {
                JOptionPane.showMessageDialog(null, "No ha seleccionado una fecha");
            }
            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado una fecha");
            }
    }
    
    /**
     * Método que agrega en un arraylist las funciones que hay en esa fecha 
     * @param listaFunciones arraylist que guarda todas las funciones
     * @param fecha fecha seleccionada
     * @return ArrayList<> arraylist guarda las funciones que hay en esa fecha
     **/
    public ArrayList<Funcion> selecFuncionesPorFecha(ArrayList<Funcion> listaFunciones, String fecha){
        ArrayList<Funcion> listaAuxiliar = new ArrayList<Funcion>();
        for (Funcion funcion: listaFunciones) {
            String fechaAux = funcion.getFechaDePresentacion().toString();
            if (fecha.equals(fechaAux)) {
                listaAuxiliar.add(funcion);
            }
        }
        return  listaAuxiliar;
    }
}