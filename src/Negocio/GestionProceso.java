
package Negocio;

import Datos.*;
import Dominio.*;
import java.io.IOException;
import java.util.List;

public class GestionProceso{
    
    private AsociarProcesos datos;

    public GestionProceso() {
        this.datos = new ArchivoObjeto();
    }

    
    public void insertaProcesos(Proceso p) throws IOException {
        this.datos.insertaProcesos(p);
    }

    
    public List<Proceso> leerProcesos() throws IOException {
        return this.datos.leerProcesos();
    }

    public Proceso buscarnumRadicado(Proceso po) throws IOException {
        return this.datos.buscarnumRadicado(po);
    }

    public Proceso buscarDemandado(Parte_Procesal pp) throws IOException {
        return this.datos.buscarDemandado(pp);
    }

    public Proceso buscarDemandante(Parte_Procesal pp) throws IOException {
        return this.datos.buscarDemandante(pp);
    }
    
   
    public void eliminarProceso(int numradicado) throws IOException {
        if(numradicado <=0)
            throw new NullPointerException("Se debe registrar la cedula del Jugador a eliminar");
        
        this.datos.eliminarProceso(numradicado);
    }

    public List<Proceso> filtrarRegistroProcesos(String filtro)throws IOException{
        return this.datos.consultarProcesos(filtro);
    }
    
    

}
