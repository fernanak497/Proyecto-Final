
package Dominio;

public class Metadato_Documento {
    private Datos datos;
    private Fechas fechas;
    private FormaDoc formaDoc;
    private Observacion observacion;
    
    public Metadato_Documento() {
    }

    public Metadato_Documento(Datos datos, Fechas fechas, FormaDoc formaDoc, Observacion observacion) {
        this.datos = datos;
        this.fechas = fechas;
        this.formaDoc = formaDoc;
        this.observacion = observacion;
    }

    public Datos getDatos() {
        return datos;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    public Fechas getFechas() {
        return fechas;
    }

    public void setFechas(Fechas fechas) {
        this.fechas = fechas;
    }

    public FormaDoc getFormaDoc() {
        return formaDoc;
    }

    public void setFormaDoc(FormaDoc formaDoc) {
        this.formaDoc = formaDoc;
    }

    public Observacion getObservacion() {
        return observacion;
    }

    public void setObservacion(Observacion observacion) {
        this.observacion = observacion;
    }

    @Override
    public String toString() {
        return "\nDatos: " + datos + "\nFechas: " + fechas + "\nForma Documento: " 
                + formaDoc + "\nObservacion: " + observacion;
    }
  
}