
package Dominio;


public class FormaDoc  {
    private String formato;
    private double tamaño;

    public FormaDoc() {
    }

    public FormaDoc(String formato, double tamaño) {
        this.formato = formato;
        this.tamaño = tamaño;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String toString() {
        return "\nFormato: " + formato + "\nTamaño: " + tamaño;
    }
  
}
