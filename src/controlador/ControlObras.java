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
 *
 * @author josep
 */
public class ControlObras implements ActionListener, MouseListener {
    
    ObraTeatral obra = null;
    VentanaPrincipal menu = new VentanaPrincipal();
    DaoObras daoObra = new DaoObras();

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
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        accionarBotonAgregar(e);
        accionarBotonModificar(e);
        accionarBotonEliminar(e);
        accionarBotonLimpiar(e);   
    }
    
    public void accionarBotonAgregar(ActionEvent e){
        if (this.menu.getPanelObra().getBtnAgregar() == e.getSource()) {
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
    }
    
    public void accionarBotonModificar(ActionEvent e){
        if (this.menu.getPanelObra().getBtnModificar() == e.getSource()) {
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
    }
    
    public void accionarBotonEliminar(ActionEvent e){
        if (this.menu.getPanelObra().getBtnEliminar() == e.getSource()) {
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
    }
    
    public void accionarBotonLimpiar(ActionEvent e){
        if( this.menu.getPanelObra().getBtnLimpiar() == e.getSource()   ) { 
            resetearObra();
        } 
    }
    
    public void agregarObra(){
        capturarDatos(); //Capturar los datos de la ventanilla
        daoObra.agregarObra(obra);
    }
    
    public void modificarObra(){
        capturarDatos(); //Capturar los datos de la ventanilla
        this.obra.setID(Integer.parseInt(menu.getPanelObra().getTxtID().getText()));
        this.daoObra.modificarObra(obra);
    }
    
    public  void eliminarObra(){
        capturarDatos(); //Capturar los datos de la ventanilla
        this.obra.setID(Integer.parseInt(menu.getPanelObra().getTxtID().getText()));
        this.daoObra.eliminarObra(obra);
    }
    
    public void resetearObra(){
        limpiar();
        cargarTabla();
        this.obra = null;
    }
    
    public void limpiar ( ) {    
        menu.getPanelObra().getTxtID().setText("");
        menu.getPanelObra().getTxtNombreObra().setText("");
        menu.getPanelObra().getTxtGenero().setText("");
        menu.getPanelObra().getTxtResumen().setText("");
        menu.getPanelObra().getTxtDuracion().setText("");
        menu.getPanelObra().getTxtActorPrincipal().setText("");
        menu.getPanelObra().getTxtActorSecundario().setText("");
        menu.getPanelObra().getTxtPrecioBoleto().setText("");      
    }
    
    public void capturarDatos() throws CamposObligatoriosException, TiempoMaximoException  {
        this.obra = new ObraTeatral();
        this.obra.setNombreObra(menu.getPanelObra().getTxtNombreObra().getText());  
        this.obra.setGenero(menu.getPanelObra().getTxtGenero().getText());
        this.obra.setResumen(menu.getPanelObra().getTxtResumen().getText());
        this.obra.setDuracion(Integer.parseInt(menu.getPanelObra().getTxtDuracion().getText()));
        this.obra.setActorPrincipal(menu.getPanelObra().getTxtActorPrincipal().getText());
        this.obra.setActorSecundario(menu.getPanelObra().getTxtActorSecundario().getText());
        this.obra.setPrecioBoleto(Double.parseDouble(menu.getPanelObra().getTxtPrecioBoleto().getText()));       
    }

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
    
    public void cargarTabla(){
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
