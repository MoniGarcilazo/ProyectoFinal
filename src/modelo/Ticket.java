
package modelo;

import java.text.DecimalFormat;

public class Ticket {
    
    private String nombreTeatro = "Chachita";
    
    private int numDeVenta; //ID
    
    private Funcion funcion;
   
    private java.sql.Date fechaVenta;
    
    private  java.sql.Time horaVenta;
    
    private int boletosVendidos;
    
    private double total;
    
    private double montoEntregado;
    
    private double cambio;


    public String getNombreTeatro() {
        return nombreTeatro;
    }

    public void setNombreTeatro(String nombreTeatro) {
        this.nombreTeatro = nombreTeatro;
    }

    public int getNumDeVenta() {
        return numDeVenta;
    }

    public void setNumDeVenta(int numDeVenta) {
        this.numDeVenta = numDeVenta;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public  /*java.time.LocalDate*/ java.sql.Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta( /*java.time.LocalDate fechaVenta*/ java.sql.Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public   java.sql.Time getHoraVenta() {
        return horaVenta;
    }

    public void setHoraVenta(  java.sql.Time horaVenta) {
        this.horaVenta = horaVenta;
    }

    public int getBoletosVendidos() {
        return boletosVendidos;
    }

    public void setBoletosVendidos(int boletosVendidos) {
        this.boletosVendidos = boletosVendidos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getMontoEntregado() {
        return montoEntregado;
    }

    public void setMontoEntregado(double montoEntregado) {
        this.montoEntregado = montoEntregado;
        
    }

    public double getCambio() {
        DecimalFormat cambioDecimal = new DecimalFormat("#.00");
        cambio = montoEntregado - total;
        
        return Double.parseDouble(cambioDecimal.format(cambio));
    }

    public void setCambio( double cambio) {
        this.cambio = cambio;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
