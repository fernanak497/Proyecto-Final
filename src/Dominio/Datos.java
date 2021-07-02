
package Dominio;

public class Datos {
    private String nombreDocumento;
    private int numpaginas, inicio, fin;
    private String origenDocumento;

    public Datos() {
    }

    public Datos(String nombreDocumento, int numpaginas, int inicio, int fin, String origenDocumento) {
        this.nombreDocumento = nombreDocumento;
        this.numpaginas = numpaginas;
        this.inicio = inicio;
        this.fin = fin;
        this.origenDocumento = origenDocumento;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public int getNumpaginas() {
        return numpaginas;
    }

    public void setNumpaginas(int numpaginas) {
        this.numpaginas = numpaginas;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public String getOrigenDocumento() {
        return origenDocumento;
    }

    public void setOrigenDocumento(String origenDocumento) {
        this.origenDocumento = origenDocumento;
    }

    @Override
    public String toString() {
        return "\nNombre Documento: " + nombreDocumento + "\nNumero Paginas: " + numpaginas + 
                "\nInicio: " + inicio + "\nFin: " + fin + "\nOrigen Documento: " + origenDocumento;
    }

}

