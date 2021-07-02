
package Dominio;

public class Tipo_Documental {
    private String descripcion;
    private int codigo;

    public Tipo_Documental() {
    }

    public Tipo_Documental(String descripcion, int codigo) {
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "\nDescripcion: " + descripcion + "\nCodigo: " + codigo;
    }
   
}
