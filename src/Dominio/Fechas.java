
package Dominio;

public class Fechas  {
    private String fCreacion, fIncorporacion;

    public Fechas() {
    }

    public Fechas(String fCreacion, String fIncorporacion) {
        this.fCreacion = fCreacion;
        this.fIncorporacion = fIncorporacion;
    }

    public String getfCreacion() {
        return fCreacion;
    }

    public void setfCreacion(String fCreacion) {
        this.fCreacion = fCreacion;
    }

    public String getfIncorporacion() {
        return fIncorporacion;
    }

    public void setfIncorporacion(String fIncorporacion) {
        this.fIncorporacion = fIncorporacion;
    }

    @Override
    public String toString() {
        return "\nFecha Creacion: " + fCreacion + "\nFecha Incorporacion: " + fIncorporacion;
    }
   
}
