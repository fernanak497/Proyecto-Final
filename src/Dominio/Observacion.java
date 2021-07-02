
package Dominio;

public class Observacion {
    private String observacion;

    public Observacion() {
    }

    public Observacion(String observacion) {
        this.observacion = observacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public String toString() {
        return "\nObservacion: " + observacion;
    }
 
}
