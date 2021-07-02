package Dominio;

public class Parte_Procesal {
    private String tipoPersona;
    private String nombrePersona;
    private int identificacion;
    private String TipoId;
    
    public Parte_Procesal() {
    }

    public Parte_Procesal(String tipoPersona, String nombrePersona, int identificacion, String TipoId) {
        this.tipoPersona = tipoPersona;
        this.nombrePersona = nombrePersona;
        this.identificacion = identificacion;
        this.TipoId = TipoId;
    }

    public Parte_Procesal(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipoId() {
        return TipoId;
    }

    public void setTipoId(String TipoId) {
        this.TipoId = TipoId;
    }

    @Override
    public String toString() {
        return "\nTipo Persona: " + tipoPersona + "\nNombre Persona: " + nombrePersona
                + "\nIdentificacion: " + identificacion + "\nTipo Identificacion: " + TipoId;
    }

}
