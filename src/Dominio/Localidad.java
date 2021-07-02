package Dominio;

public  class Localidad {
    private String nombreCiudad, nombreDepto;

    public Localidad() {
    }

    public Localidad(String nombreCiudad, String nombreDepto) {
        this.nombreCiudad = nombreCiudad;
        this.nombreDepto = nombreDepto;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getNombreDepto() {
        return nombreDepto;
    }

    public void setNombreDepto(String nombreDepto) {
        this.nombreDepto = nombreDepto;
    }

    @Override
    public String toString() {
        return "\nCiudad: " + nombreCiudad + "\nDepartamento: " + nombreDepto;
    }

}
