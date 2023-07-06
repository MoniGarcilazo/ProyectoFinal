/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Exceptions.CamposObligatoriosException;
import Exceptions.TiempoMaximoException;

public class ObraTeatral {
    
    private int ID;
    private String nombreObra;
    private String genero;
    private String resumen;
    private int duracion;
    private String actorPrincipal;
    private String actorSecundario;
    private double precioBoleto;

    public ObraTeatral() {
    }

    public ObraTeatral(int ID, String nombreObra, String genero, String resumen, int duracion, String actorPrincipal, String actorSecundario, double precioBoleto) {
        this.ID = ID;
        this.nombreObra = nombreObra;
        this.genero = genero;
        this.resumen = resumen;
        this.duracion = duracion;
        this.actorPrincipal = actorPrincipal;
        this.actorSecundario = actorSecundario;
        this.precioBoleto = precioBoleto;
    }
    
    

    public String getNombreObra() {
        return nombreObra;
    }

    public void setNombreObra(String nombreObra) {
           if( " ".equals(nombreObra)){
            throw new CamposObligatoriosException();
        }else{
           if("".equals(nombreObra)){
               throw new CamposObligatoriosException();
           }else{
            this.nombreObra = nombreObra;
           }
        }
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
           if( " ".equals(genero)){
            throw new CamposObligatoriosException();
        }else{
           if("".equals(genero)){
               throw new CamposObligatoriosException();
           }else{
          this.genero = genero;
           }
        }
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
           if( " ".equals(resumen)){
            throw new CamposObligatoriosException();
        }else{
           if("".equals(resumen)){
               throw new CamposObligatoriosException();
           }else{
            this.resumen = resumen;
           }
        }
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        if (duracion >0 && duracion < 151){
        this.duracion = duracion;
        }else{
            throw new TiempoMaximoException();
        }
    }

    public String getActorPrincipal() {
        return actorPrincipal;
    }

    public void setActorPrincipal(String actorPrincipal) {
           if( " ".equals(actorPrincipal)){
            throw new CamposObligatoriosException();
        }else{
           if("".equals(actorPrincipal)){
               throw new CamposObligatoriosException();
           }else{
            this.actorPrincipal = actorPrincipal;           }
           }
    }

    public String getActorSecundario() {
        return actorSecundario;
    }

    public void setActorSecundario(String actorSecundario) {
        if( " ".equals(actorSecundario)){
            throw new CamposObligatoriosException();
        }else{
           if("".equals(actorSecundario)){
               throw new CamposObligatoriosException();
           }else{
           this.actorSecundario = actorSecundario;
           }
        }
    }

    public double getPrecioBoleto() {
        return precioBoleto;
    }

    public void setPrecioBoleto(double precioBoleto) {
        if( " ".equals(precioBoleto)){
            throw new CamposObligatoriosException();
        }else{
           if("".equals(precioBoleto)){
               throw new CamposObligatoriosException();
           }else{
           this.precioBoleto = precioBoleto;
           }
        }
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    @Override
    public String toString() {
        return getNombreObra();
    }
    
}
