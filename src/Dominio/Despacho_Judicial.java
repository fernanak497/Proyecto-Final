package Dominio;

public class Despacho_Judicial {
    private String nombreDespacho;
    private int codigo;
    private String categoria ;

    public Despacho_Judicial() {
    }

    public Despacho_Judicial(String nombreDespacho, int codigo, String categoria) {
        this.nombreDespacho = nombreDespacho;
        this.codigo = codigo;
        this.categoria = categoria;
    }

    public String getNombreDespacho() {
        return nombreDespacho;
    }

    public void setNombreDespacho(String nombreDespacho) {
        this.nombreDespacho = nombreDespacho;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "\nNombre Despacho: " + nombreDespacho + "\nCodigo: " + codigo 
                +"\nCategoria: " + categoria;
    }

}
