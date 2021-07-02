
package Dominio;

import java.util.*;

public class Proceso  {
    private Metadato_Expediente metadato_Expediente;
    private List<Metadato_Documento> metadato_Documento;
    
    public Proceso() {
        this.metadato_Documento = new ArrayList<>();
    }

    public Proceso(int numRadicado) {
        this.metadato_Expediente = new Metadato_Expediente();
        this.metadato_Expediente.setNumradicado(numRadicado);
    }

    public Metadato_Expediente getMetadato_Expediente() {
        return metadato_Expediente;
    }

    public void setMetadato_Expediente(Metadato_Expediente metadato_Expediente) {
        this.metadato_Expediente = metadato_Expediente;
    }

    public List<Metadato_Documento> getMetadato_Documento() {
        return metadato_Documento;
    }

    public void setMetadato_Documento(List<Metadato_Documento> metadato_Documento) {
        this.metadato_Documento = metadato_Documento;
    }

    @Override
    public String toString() {
        return "\nMetadato Expediente: " + metadato_Expediente + "\nMetadato Documento: " 
                + metadato_Documento;
    }

}
