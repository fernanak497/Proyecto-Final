
package Datos;

import Dominio.*;
import java.io.IOException;
import java.util.List;

public interface AsociarProcesos {
    void insertaProcesos(Proceso p) throws IOException;
    List<Proceso> leerProcesos() throws IOException;
    Proceso buscarnumRadicado(Proceso po) throws IOException;
    Proceso buscarDemandado(Parte_Procesal pp) throws IOException;
    Proceso buscarDemandante(Parte_Procesal pp) throws IOException;
    void eliminarProceso(int numradicado) throws IOException;
    List<Proceso> consultarProcesos(String filtroTexto) throws IOException;
}
