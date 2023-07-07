
package modelo;

import java.sql.Time;

/**
 *
 * @author Monica Garcilazo
 */
public class Funcion {
    
    private int ID;
    
    private ObraTeatral obra;
    
    private java.sql.Date fechaDePresentacion;
    
    private Time hora;
    
    private Asiento[][] zonaA = new Asiento[2][5];
    
    private Asiento[][] zonaB = new Asiento[5][2];
    
    private Asiento[][] zonaB2 = new Asiento[5][2];
    
    private Asiento[][] zonaC = new Asiento[2][5];

    public Funcion() {
    }
    
    public Funcion(int ID, ObraTeatral obra, java.sql.Date fechaDePresentacion, Time hora) {
        this.ID = ID;
        this.obra = obra;
        this.fechaDePresentacion = fechaDePresentacion;
        this.hora = hora;
    }
    
    
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ObraTeatral getObra() {
        return obra;
    }

    public void setObra(ObraTeatral obra) {
        this.obra = obra;
    }

    public java.sql.Date getFechaDePresentacion() {
        return fechaDePresentacion;
    }

    public void setFechaDePresentacion(java.sql.Date fechaDePresentacion) {
        this.fechaDePresentacion = fechaDePresentacion;
    }

    public Asiento[][] getZonaA() {
        return zonaA;
    }

    public void setZonaA(Asiento[][] zonaA) {
        this.zonaA = zonaA;
    }

    public Asiento[][] getZonaB() {
        return zonaB;
    }

    public void setZonaB(Asiento[][] zonaB) {
        this.zonaB = zonaB;
    }

    public Asiento[][] getZonaC() {
        return zonaC;
    }

    public void setZonaC(Asiento[][] zonaC) {
        this.zonaC = zonaC;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Asiento[][] getZonaB2() {
        return zonaB2;
    }

    public void setZonaB2(Asiento[][] zonaB2) {
        this.zonaB2 = zonaB2;
    }
    
    
    
    
    
}
