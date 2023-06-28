/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.DaoReporte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import modelo.Ticket;
import vista.VentanaPrincipal;

/**
 *
 * @author hp
 */
public class ControlReporte implements ActionListener{
    
    Ticket ticket = new Ticket();
    VentanaPrincipal menu = new VentanaPrincipal();
    DaoReporte daoReporte = new DaoReporte();
    
    
    
    public ControlReporte(Ticket ticket, VentanaPrincipal menu) {
        this.ticket = ticket;
        this.menu = menu;
       
        
        this.menu.getPanelReportes().getBtnReporteMensual().addActionListener(this);
        this.menu.getPanelReportes().getBtnReporteDiario().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        ArrayList<Ticket> listaTickets = new ArrayList<Ticket>();
        ArrayList<Ticket> listaTicketsAuxiliar = new ArrayList<Ticket>();
        
        if (this.menu.getPanelReportes().getBtnReporteMensual() == e.getSource()) {
           

            listaTickets = daoReporte.recuperarTickets();

            String mes = this.menu.getPanelReportes().getComboBoxMeses().getSelectedItem().toString();

            listaTicketsAuxiliar =getListaReporteMensual(listaTickets, mes);
            
            if (listaTicketsAuxiliar.isEmpty() == false) { 
                daoReporte.cargarTabla(menu.getPanelReportes().getTblTickets(), listaTicketsAuxiliar);
                this.menu.getPanelReportes().getTxtTickets().setText(Integer.toString(listaTicketsAuxiliar.size()));
                this.menu.getPanelReportes().getTxtBoletos().setText(Integer.toString(daoReporte.getCantidadBoletos(listaTicketsAuxiliar)));
                this.menu.getPanelReportes().getTxtMontoTotal().setText(Double.toString(daoReporte.getCantidadMontoTotal(listaTicketsAuxiliar)));
            } else {
                JOptionPane.showMessageDialog(null, "No hay Registros guardados con esa fecha");
            }
            

        }
        
        if (this.menu.getPanelReportes().getBtnReporteDiario() == e.getSource()) {
            listaTickets = daoReporte.recuperarTickets();
            
            try {
            Date date = this.menu.getPanelReportes().getjCalendarFecha().getDate();
            long d = date.getTime();

            //Conversion a SQL
            java.sql.Date fecha = new java.sql.Date(d);
            listaTicketsAuxiliar = getListaReporteDiario(listaTickets, fecha);

                if (!listaTicketsAuxiliar.isEmpty()) {
                    daoReporte.cargarTabla(menu.getPanelReportes().getTblTickets(), listaTicketsAuxiliar);
                    this.menu.getPanelReportes().getTxtTickets().setText(Integer.toString(listaTicketsAuxiliar.size()));
                    this.menu.getPanelReportes().getTxtBoletos().setText(Integer.toString(daoReporte.getCantidadBoletos(listaTicketsAuxiliar)));
                    this.menu.getPanelReportes().getTxtMontoTotal().setText(Double.toString(daoReporte.getCantidadMontoTotal(listaTicketsAuxiliar)));
                }else{
                    JOptionPane.showMessageDialog(null, "No hay Registros guardados con esa fecha");
                }
            
            } catch (Exception a) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado una fecha");
            }

        }

    }
    
    
    
    
    
    public ArrayList getListaReporteMensual(ArrayList<Ticket> listaTickets, String mes) {
        ArrayList<Ticket> listaTicketsAuxiliar = new ArrayList<Ticket>();

        String nombre[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre",};

        for (int j = 0; j < 12; j++) {
            if (mes.equals(nombre[j])) {
                for (int i = 0; i < listaTickets.size(); i++) {
                    String mesAux = listaTickets.get(i).getFechaVenta().toString();

                    StringTokenizer st = new StringTokenizer(mesAux, "-");
                    for (int k = 0; k < 2; k++) {
                        String token = st.nextToken();
                        if (k == 1) {
                            int numMes = Integer.parseInt(token);
                            if (j + 1 == numMes) {
                                listaTicketsAuxiliar.add(listaTickets.get(i));
                            }
                        }
                    }
                }
            }
        }

        return listaTicketsAuxiliar;
    }
    
    
    public ArrayList getListaReporteDiario(ArrayList<Ticket> listaTickets, java.sql.Date fecha) {
        ArrayList<Ticket> listaTicketsAuxiliar = new ArrayList<Ticket>();

            String fechaAuxiliar = fecha.toString();

            for (int i = 0; i < listaTickets.size(); i++) {

                if (listaTickets.get(i).getFechaVenta().toString().equals(fechaAuxiliar)) {
                    listaTicketsAuxiliar.add(listaTickets.get(i));

                } 
            }


        return listaTicketsAuxiliar;
    }
}
