package Dominio;

public class Subserie {
    private  int codigo;
    private String descripcion;
    private Tipo_Documental tipo_Documental;
    
    public Subserie() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tipo_Documental getTipo_Documental() {
        return tipo_Documental;
    }

    public void setTipo_Documental(Tipo_Documental tipo_Documental) {
        this.tipo_Documental = tipo_Documental;
    }

    @Override
    public String toString() {
        return "\nCodigo: " + codigo + "\nDscripcion: " + descripcion;
    }

}
