/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import daos.DaoReporte;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Ticket;
import vista.VentanaPrincipal;

/**
 *Clase que controla la ventana de ventas de reportes
 */
public class ControlReporte implements ActionListener{
    
    VentanaPrincipal menu = new VentanaPrincipal();
    DaoReporte daoReporte = new DaoReporte();
    
    
    /**
     * Método principal que administra el apartado de adquisición y pago de
     * boletos
     * @param menu, ventana principal donde se ejecuta el proceso
     */
    public ControlReporte( VentanaPrincipal menu) {

        this.menu = menu;
       
        this.menu.getPanelReportes().getBtnReporteMensual().addActionListener(this);
        this.menu.getPanelReportes().getBtnReporteDiario().addActionListener(this);
    }

        /**
     * Metodo que detecta el uso de botones
     * @param e acción de los botones
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        boolean accionarBotonMensual = this.menu.getPanelReportes().getBtnReporteMensual() == e.getSource();
        boolean accionarBotonDiario = this.menu.getPanelReportes().getBtnReporteDiario() == e.getSource();
        
        if (accionarBotonMensual) {           
            accionarBotonMensual();
        }
        
        if (accionarBotonDiario) {
            accionarBotonDiario();
        }

    }
    
    /**
     * Metodo que detecta el uso del boton Mensual
     */
    public void accionarBotonMensual() {
        ArrayList<Ticket> listaTickets = daoReporte.recuperarTickets();
        ArrayList<Ticket> listaReporTickets = new ArrayList<Ticket>();
        
        String mes = this.menu.getPanelReportes().getComboBoxMeses().getSelectedItem().toString();
        listaReporTickets = getListaReporteMensual(listaTickets, mes);

        if (!listaReporTickets.isEmpty()) {
            cargarDatosVentanaReporte(listaReporTickets);
        } else {
            JOptionPane.showMessageDialog(null, "No hay Registros guardados con esa fecha");
        }
    }
    
    /**
     * Metodo que detecta el uso del boton Diario
     */
    public void accionarBotonDiario(){
        ArrayList<Ticket> listaTickets = daoReporte.recuperarTickets();
        ArrayList<Ticket> listaReporTickets = new ArrayList<Ticket>();
        try {
            Date date = this.menu.getPanelReportes().getjCalendarFecha().getDate();
            long d = date.getTime();

            java.sql.Date fecha = new java.sql.Date(d);
            listaReporTickets = getListaReporteDiario(listaTickets, fecha);

            if (!listaReporTickets.isEmpty()) {
                cargarDatosVentanaReporte(listaReporTickets);
            } else {
                JOptionPane.showMessageDialog(null, "No hay Registros guardados con esa fecha");
            }
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado una fecha");
        }
    }
    
    /**
     * Metodo que muestra la informacion del reporte 
     * @param listaTickets lista de tickets para el reporte 
     */
    public void cargarDatosVentanaReporte(ArrayList<Ticket> listaTickets) {
        cargarTabla(menu.getPanelReportes().getTblTickets(), listaTickets);
        this.menu.getPanelReportes().getTxtTickets().setText(Integer.toString(listaTickets.size()));
        this.menu.getPanelReportes().getTxtBoletos().setText(Integer.toString(getCantidadBoletos(listaTickets)));
        this.menu.getPanelReportes().getTxtMontoTotal().setText(Double.toString(getCantidadMontoTotal(listaTickets)));
    }
    
    /**
     * Metodo que devuelve la lista de tickets para el reporte mensual
     * @param listaTickets lista de todos los tickets  
     * @param mesSeleccionado mes que se haya seleccionado
     * @return listaTicketsAuxiliar
     */
    public ArrayList<Ticket> getListaReporteMensual(ArrayList<Ticket> listaTickets, String mesSeleccionado) {
        ArrayList<Ticket> listaTicketsAuxiliar = new ArrayList<Ticket>();
        String nombre[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre",};
        for (int mes = 0; mes < 12; mes++) {
            if (mesSeleccionado.equals(nombre[mes])) {
                for (Ticket ticketAux : listaTickets) {
                    String mesAux = ticketAux.getFechaVenta().toString();
                    
                    StringTokenizer st = new StringTokenizer(mesAux, "-");
                    st.nextToken();
                    String token = st.nextToken();
                    int mesTicket = Integer.parseInt(token);
                    if (mes + 1 == mesTicket) {
                        listaTicketsAuxiliar.add(ticketAux);
                    }
                }
            }
        }
        return listaTicketsAuxiliar;
    }
    
    /**
     * Metodo que devuelve la lista de tickets para el reporte mensual
     * @param listaTickets lista de todos los tickets  
     * @param fecha fecha que se haya seleccionado
     * @return listaTicketsAuxiliar
     */
    public ArrayList<Ticket> getListaReporteDiario(ArrayList<Ticket> listaTickets, java.sql.Date fecha) {
        ArrayList<Ticket> listaTicketsAuxiliar = new ArrayList<Ticket>();
        String fechaAuxiliar = fecha.toString();
        for (Ticket ticketAux : listaTickets) {
            if (ticketAux.getFechaVenta().toString().equals(fechaAuxiliar)) {
                listaTicketsAuxiliar.add(ticketAux);
            }
        }
        return listaTicketsAuxiliar;
    }
    
    /**
     * Metodo que carga los datos en una tabla
     * @param tblTicket tabla que se usa para mostrar los datos  
     * @param listaTicket lista de tickets a mostrar
     * @return tblTicket
     */
    public JTable cargarTabla(JTable tblTicket, ArrayList<Ticket> listaTicket) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tblTicket.getModel();
        modeloTabla.setRowCount(0);
        int[] anchos
                = {
                    10, 40, 40, 40, 40, 40, 40
                };
        for (int i = 0; i < tblTicket.getColumnCount(); i++) {
            tblTicket.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        for (Ticket ticket : listaTicket) {
            Object[] row = new Object[]{ticket.getNumDeVenta(), ticket.getBoletosVendidos(), ticket.getFechaVenta(),
                ticket.getHoraVenta(), ticket.getTotal(), ticket.getMontoEntregado(), ticket.getCambio()};
            modeloTabla.addRow(row);
        }
        return tblTicket;
    }

    /**
     * Metodo que obtiene la cantidad de boletos vendidos
     * @param listaTickets lista de tickets 
     * @return cantBoletos
     */
    public int getCantidadBoletos(ArrayList<Ticket> listaTickets) {
        int cantBoletos = 0;
        for (Ticket ticketAux: listaTickets) {
            int contBoleto = ticketAux.getBoletosVendidos();
            cantBoletos = cantBoletos + contBoleto;
        }
        return cantBoletos;
    }

    /**
     * Metodo que obtiene la cantidad del monto total vendido
     * @param listaTickets lista de tickets 
     * @return cantMontoTotal
     */
    public double getCantidadMontoTotal(ArrayList<Ticket> listaTickets) {
        double cantMontoTotal = 0;
        for (Ticket ticketAux: listaTickets) {
            double contMontoTotal = ticketAux.getTotal();
            cantMontoTotal = cantMontoTotal + contMontoTotal;
        }
        return cantMontoTotal;
    }
}
