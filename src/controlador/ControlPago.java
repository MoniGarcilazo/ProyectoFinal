/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.DaoAsientos;
import DAO.DaoBoletos;
import DAO.DaoReporte;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Boleto;
import modelo.Funcion;
import modelo.Ticket;
import vista.VentanaPrincipal;

/**
 *
 * @author josep
 */
public final class ControlPago implements ActionListener {

    ArrayList<Boleto> boletos = new ArrayList<>();
    VentanaPrincipal menu = new VentanaPrincipal();
    DaoBoletos daoBoletos = new DaoBoletos();
    DaoReporte daoTicket = new DaoReporte();
    DaoAsientos daoAsientos = new DaoAsientos();
    Ticket ticket = new Ticket();
    Funcion funcion = new Funcion();

    /**
     * Método principal que administra el apartado de adquisición y pago de
     * boletos
     *
     * @param menu, ventana principal donde se ejecuta el proceso
     * @param boletos, listado de boletos disponibles
     * @param funcion, parámetro que almacena la función seleccionada
     */
    public ControlPago(VentanaPrincipal menu, ArrayList<Boleto> boletos, Funcion funcion) {
        this.boletos = boletos;
        this.menu = menu;
        this.funcion = funcion;

        // Agregar Action listener a los botones
        this.menu.getPanelPago().getBtnImprimirTicket().addActionListener(this);
        this.menu.getPanelPago().getBtnPagar().addActionListener(this);

        this.menu.getPanelPago().getTxtTotalPagar().setText(String.valueOf(totalPago())); // Agregar el total por pagar en su textField
        this.menu.getPanelPago().getTxtAreaBoletos().setText(imprimirBoletosEnPantalla());
    }

    /**
     *Método que expone los boletos disponibles al usuario
     * @return imagen gráfica de los boletos disponibles
     */
    public String imprimirBoletosEnPantalla() {
        String textoBoletos = "";
        for (int i = 0; i < boletos.size(); i++) {
            textoBoletos
                    += "-------------------------------------------------------------------------------------------------\n"
                    + " Boleto " + (i + 1) + "\n"
                    + " Nombre de la obra: " + boletos.get(i).getFuncion().getObra().getNombreObra() + "\n"
                    + " Fecha de la función: " + boletos.get(i).getFechaFuncion().toString() + "\n"
                    + " Hora de la función: " + boletos.get(i).getHoraFuncion().toString() + "\n"
                    + " Asiento: " + boletos.get(i).getLugar().getNombre() + "\n"
                    + "-------------------------------------------------------------------------------------------------\n\n";
        }
        return textoBoletos;
    }
    /**
     * Método que muestra el recibo al usuario
     * @return imagen del ticket actual
     */
    public String imprimirTicketEnPantalla() {
        DecimalFormat cambioDecimal = new DecimalFormat("#.00");
        String textoTicket
                = "\t\t\tTeatro: " + ticket.getNombreTeatro() + "\n"
                + "\tNumero de venta : " + ticket.getNumDeVenta() + "\n"
                + "\tNombre de la función: " + ticket.getFuncion().getObra().getNombreObra() + "\n"
                + "\tTotal de boletos: " + ticket.getBoletosVendidos() + "\n"
                + "\tFecha de venta: " + ticket.getFechaVenta() + "\n"
                + "\tHora de venta: " + ticket.getHoraVenta() + "\n"
                + "\tCosto Total: " + ticket.getTotal() + "\n"
                + "\tMonto entregado: " + ticket.getMontoEntregado() + "\n"
                + "\tCambio: " + cambioDecimal.format(ticket.getCambio());

        return textoTicket;
    }
    /**
     * Método encargado de calcular el total de la funcion al usuario
     * @return total calculado
     */
    public double totalPago() {
        DecimalFormat totalDecimal = new DecimalFormat("#.00");
        double total = 0;
        for (int i = 0; i < boletos.size(); i++) {
            total += boletos.get(i).getPrecioBoleto();
        }
        total = Double.parseDouble(totalDecimal.format(total));
        return total;
    }
    /**
     * Método usado en caso de pago en efectivo, encargado de validar la cantidad de dinero recibida
     * @return 
     */
    public double montoEntregado() {
        double montoEntregado = 0;
        try {
            montoEntregado = Double.parseDouble(this.menu.getPanelPago().getTxtEfectivoRecibido().getText());
            if (montoEntregado < 0) {
                montoEntregado = 0;
                JOptionPane.showMessageDialog(null, "Efectivo inválido \n Por favor ingrese una cantidad igual o mayor que el total a pagar");
            } else if (montoEntregado < totalPago()) {
                montoEntregado = 0;
                JOptionPane.showMessageDialog(null, "El efectivo es insuficiente \n Por favor ingrese una cantidad igual o mayor que el total a pagar");
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Caracter inválido, por favor ingrese una cifra válida");
        }

        return montoEntregado;
    }
    /**
     * Metodo que detecta el uso de botones
     * @param evento o acción de los botones
     */
    @Override
    public void actionPerformed(ActionEvent evento) {

        if (this.menu.getPanelPago().getBtnPagar() == evento.getSource()) { //Capturar datos y creaer Ticket
            if (this.menu.getPanelPago().getTxtEfectivoRecibido() == null) {
                JOptionPane.showMessageDialog(null, "No se ha ingresado ninguna cantidad de efectivo");
            } else if (montoEntregado() != 0) {

                //Crear el ticket
                ticket.setFuncion(boletos.get(0).getFuncion());
                LocalDate fechaActual = LocalDate.now();
                java.sql.Date fechaSQL = java.sql.Date.valueOf(fechaActual);
                ticket.setFechaVenta(fechaSQL);
                java.util.Date utilDate = new java.util.Date();
                long lnMilisegundos = utilDate.getTime();
                java.sql.Time horaActual = new java.sql.Time(lnMilisegundos);
                ticket.setHoraVenta(horaActual);
                ticket.setBoletosVendidos(boletos.size());
                ticket.setTotal(totalPago());
                ticket.setMontoEntregado(montoEntregado());
                int idTicket = daoTicket.agregarTicket(ticket);
                ticket.setNumDeVenta(idTicket);

                JOptionPane.showMessageDialog(null, "Pago exitoso");

                daoAsientos.modificarSala(this.funcion);

                this.menu.getPanelPago().getTxtCambio().setText(String.valueOf(ticket.getCambio()));  // Poner el dato de cambio en su casilla despues de PAGAR

            } else {
                JOptionPane.showMessageDialog(null, "Pago No exitoso");
            }

        }

        // Presionar el boton IMPRIMIR TICKET 
        if (this.menu.getPanelPago().getBtnImprimirTicket() == evento.getSource()) {

            //Validar el monto entregado
            if (montoEntregado() != 0) {

                this.menu.getPanelPago().getTxtAreaTicket().setText(imprimirTicketEnPantalla());
                daoTicket.registrarTicketEnArchivo(imprimirTicketEnPantalla());
                daoBoletos.registrarBoletosEnArchivo(imprimirBoletosEnPantalla());

            } else {
                JOptionPane.showMessageDialog(null, "El efectivo entregado no es correcto, por favor ingrese una cantidad válida");
            }

        }

    }

}
