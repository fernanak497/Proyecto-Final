package Dominio;

public  class Serie {
    private  int codigo;
    private String descripcion;
    private Subserie subserie;
    public Serie() {
    }

    public Serie(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
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

    public Subserie getSubserie() {
        return subserie;
    }

    public void setSubserie(Subserie subserie) {
        this.subserie = subserie;
    }

    @Override
    public String toString() {
        return "\nCodigo: " + codigo + "\nDescripcion: " + descripcion;
    }
    
    
}
