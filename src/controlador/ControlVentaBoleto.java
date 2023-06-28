/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.DaoVentaBoleto;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Boleto;
import modelo.Funcion;
import vista.VentanaPrincipal;

/**
 *
 * @author josep
 */
public class ControlVentaBoleto implements ActionListener {
    
    Boleto boleto = new Boleto();
    VentanaPrincipal menu = new VentanaPrincipal();
    DaoVentaBoleto daoVentaBoleto = new DaoVentaBoleto();
    Funcion funcion1 = new Funcion();
    Funcion funcion2 = new Funcion();
    ArrayList<Funcion> listaFunciones;
    ArrayList<Funcion> listaFuncionesAuxiliar;
    
    public ControlVentaBoleto(Boleto boleto, VentanaPrincipal menu) {
        this.boleto = boleto;
        this.menu = menu;
        
        this.menu.getPanelBoleto().setComboBoxFechasFunciones(daoVentaBoleto.cargarComboBox(menu.getPanelBoleto().getComboBoxFechasFunciones()));
        
        //Agregar los ActionListeners
        this.menu.getPanelBoleto().getComboBoxFechasFunciones().addActionListener(this);
        this.menu.getPanelBoleto().getBtnHorario1().addActionListener(this);
        this.menu.getPanelBoleto().getBtnHorario2().addActionListener(this);
        this.menu.getMenuBoleto().addActionListener(this);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(this.menu.getPanelBoleto().getComboBoxFechasFunciones() == e.getSource()) {
            listaFunciones = new ArrayList<Funcion>();
            listaFuncionesAuxiliar = new ArrayList<Funcion>();
            
            listaFunciones = daoVentaBoleto.recuperarFunciones();
             String fecha = this.menu.getPanelBoleto().getComboBoxFechasFunciones().getSelectedItem().toString();
//            filtrarFechas(); //Para filtrar las fechas correctas que se ha seleccionado

            for( int i = 0; i < listaFunciones.size(); i++) {
                
                String fechaAux = listaFunciones.get(i).getFechaDePresentacion().toString();
                
                if(fecha.equals(fechaAux)) {
                
                    listaFuncionesAuxiliar.add(listaFunciones.get(i));
            }
                
            }
            
            if( listaFuncionesAuxiliar.size() == 2) {
                this.menu.getPanelBoleto().getTxtNombreFuncion1().setText(listaFuncionesAuxiliar.get(0).getObra().getNombreObra());
                this.menu.getPanelBoleto().getTxtNombreFuncion2().setText(listaFuncionesAuxiliar.get(1).getObra().getNombreObra());

                this.menu.getPanelBoleto().getTxtDuracionFuncion1().setText(String.valueOf(listaFuncionesAuxiliar.get(0).getObra().getDuracion()));
                this.menu.getPanelBoleto().getTxtDuracionFuncion2().setText(String.valueOf(listaFuncionesAuxiliar.get(1).getObra().getDuracion()));
                
                this.menu.getPanelBoleto().getBtnHorario1().setText(String.valueOf(listaFuncionesAuxiliar.get(0).getHora()));
                this.menu.getPanelBoleto().getBtnHorario2().setText(String.valueOf(listaFuncionesAuxiliar.get(1).getHora()));
                
                this.menu.getPanelBoleto().getTxtIDFuncion1().setText(String.valueOf(listaFuncionesAuxiliar.get(0).getID()));
                this.menu.getPanelBoleto().getTxtIDFuncion2().setText(String.valueOf(listaFuncionesAuxiliar.get(1).getID()));
                
                funcion1 = listaFuncionesAuxiliar.get(0);
                funcion2 = listaFuncionesAuxiliar.get(1);
                
                this.menu.getPanelBoleto().getBtnHorario2().setEnabled(true);
            } else if (listaFuncionesAuxiliar.size() == 1) {
                this.menu.getPanelBoleto().getTxtNombreFuncion1().setText(listaFuncionesAuxiliar.get(0).getObra().getNombreObra());
                this.menu.getPanelBoleto().getTxtNombreFuncion2().setText("Sin funcion");

                this.menu.getPanelBoleto().getTxtDuracionFuncion1().setText(String.valueOf(listaFuncionesAuxiliar.get(0).getObra().getDuracion()));
                this.menu.getPanelBoleto().getTxtDuracionFuncion2().setText(String.valueOf("Sin funcion"));
                
                this.menu.getPanelBoleto().getBtnHorario1().setText(String.valueOf(listaFuncionesAuxiliar.get(0).getHora()));
                this.menu.getPanelBoleto().getBtnHorario2().setText("Sin funcion");
                
                this.menu.getPanelBoleto().getTxtIDFuncion1().setText(String.valueOf(listaFuncionesAuxiliar.get(0).getID()));
                this.menu.getPanelBoleto().getTxtIDFuncion2().setText("xd");
                
                funcion1 = listaFuncionesAuxiliar.get(0);
                
                this.menu.getPanelBoleto().getBtnHorario2().setEnabled(false);
                
            } 
       
            
        }
        
        if(this.menu.getPanelBoleto().getBtnHorario1() == e.getSource() ) {

            try {
                if(!listaFuncionesAuxiliar.isEmpty()) {
                ControlAsientos controlAsientos = new ControlAsientos(menu , funcion1);
                menu.getSala().setSize(1460, 720);
                menu.getSala().setLocation(0, 0);

                menu.getPanelContenido().removeAll();
                menu.getPanelContenido().add(menu.getSala(), BorderLayout.CENTER);
                menu.getPanelContenido().revalidate();
                menu.getPanelContenido().repaint();
            } else {
                JOptionPane.showMessageDialog(null, "No ha seleccionado una fecha");
            }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado una fecha");
            }
            
            
        }
        
        if(this.menu.getPanelBoleto().getBtnHorario2() == e.getSource() ) {

            try {
                if(!listaFuncionesAuxiliar.isEmpty()) {
                ControlAsientos controlAsientos = new ControlAsientos(menu , funcion2);
                menu.getSala().setSize(1460, 720);
                menu.getSala().setLocation(0, 0);

                menu.getPanelContenido().removeAll();
                menu.getPanelContenido().add(menu.getSala(), BorderLayout.CENTER);
                menu.getPanelContenido().revalidate();
                menu.getPanelContenido().repaint();
                } else {
                JOptionPane.showMessageDialog(null, "No ha seleccionado una fecha");
            }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado una fecha");
            }
            
        }
        
    }
    
    
    
    public void capturarDatosFuncion1( ) {
        ArrayList<Funcion> listaFunciones = new ArrayList<Funcion>();
        listaFunciones = daoVentaBoleto.recuperarFunciones();
        
        for (int i = 0; i < listaFunciones.size(); i++ ) {
            
            if( this.menu.getPanelBoleto().getTxtNombreFuncion1().getText() == listaFunciones.get(i).getObra().getNombreObra() ) {
                boleto.setFuncion(listaFunciones.get(i));
            }
            
        }
        
    }
    
//    public void filtrarFechas() { 
//            
//            for( int i = 0; i < listaFunciones.size(); i++) {
//                
//                String fechaAux = listaFunciones.get(i).getFechaDePresentacion().toString();
//                
//                if(fecha.equals(fechaAux)) {
//                
//                    listaFuncionesAuxiliar.add(listaFunciones.get(i));
//            }
//                
//            }
//    }
    
    
}
