
package Dominio;

import java.util.ArrayList;
import java.util.*;


public class Metadato_Expediente {
    private int numradicado;
    private Localidad localidad;
    private Despacho_Judicial despacho_Judicial;
    private Serie serie;
    private Cuaderno nCuaderno;
    private List<Parte_Procesal> ParteA;
    private List<Parte_Procesal> ParteB;

    public Metadato_Expediente(int numradicado) {
        this.numradicado = numradicado;
    }
    
    public Metadato_Expediente() {
        this.ParteA = new ArrayList<>();
        this.ParteB = new ArrayList<>();
    }

    public Metadato_Expediente(int numradicado, Localidad localidad, Despacho_Judicial despacho_Judicial, Serie serie, Cuaderno nCuaderno) {
        this();
        this.numradicado = numradicado;
        this.localidad = localidad;
        this.despacho_Judicial = despacho_Judicial;
        this.serie = serie;
        this.nCuaderno = nCuaderno;
        
    }
    
    public int getNumradicado() {
        return numradicado;
    }

    public void setNumradicado(int numradicado) {
        this.numradicado = numradicado;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public Despacho_Judicial getDespacho_Judicial() {
        return despacho_Judicial;
    }

    public void setDespacho_Judicial(Despacho_Judicial despacho_Judicial) {
        this.despacho_Judicial = despacho_Judicial;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Cuaderno getnCuaderno() {
        return nCuaderno;
    }

    public void setnCuaderno(Cuaderno nCuaderno) {
        this.nCuaderno = nCuaderno;
    }

    public List<Parte_Procesal> getParteA() {
        return ParteA;
    }

    public void setParteA(List<Parte_Procesal> ParteA) {
        this.ParteA = ParteA;
    }

    public List<Parte_Procesal> getParteB() {
        return ParteB;
    }

    public void setParteB(List<Parte_Procesal> ParteB) {
        this.ParteB = ParteB;
    }

    @Override
    public String toString() {
        return "\nNumero Radicado: " + numradicado + "\nLocalidad: " + localidad 
                + "\nDespacho Judicial: " + despacho_Judicial + "\nSerie: " + serie 
                + "Numero Cuaderno: " + nCuaderno + "\nDemandando: " + ParteA + "\nDemandante: " 
                + ParteB;
    }

}
