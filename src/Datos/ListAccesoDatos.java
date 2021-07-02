package Datos;

import Dominio.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListAccesoDatos implements AsociarProcesos, Serializable {

    private List<Proceso> lista;

    public ListAccesoDatos() {
        this.lista = new ArrayList<>();
    }

    public List<Proceso> getProcesos() {
        return lista;
    }

    
    @Override
    public void insertaProcesos(Proceso p) throws IOException {
        this.lista.add(p);
    }

    @Override
    public List<Proceso> leerProcesos() throws IOException {
        return this.lista;
    }

    @Override
    public Proceso buscarnumRadicado(Proceso po) throws IOException {
        for (Proceso buscar : this.lista) {
            if (buscar.getMetadato_Expediente().getNumradicado() == po.getMetadato_Expediente().getNumradicado()) {
                return buscar;
            }
        }
        return null;
    }

    @Override
    public Proceso buscarDemandado(Parte_Procesal pp) throws IOException {
        for (Proceso buscar : lista) {
            for (Parte_Procesal partebuscar : buscar.getMetadato_Expediente().getParteA()) {
                if (partebuscar.getNombrePersona().equals(pp.getNombrePersona())) {
                    return buscar;
                }
            }
        }
        return null;
    }

    @Override
    public Proceso buscarDemandante(Parte_Procesal pp) throws IOException {
        for (Proceso buscar : lista) {
            for (Parte_Procesal partebuscar : buscar.getMetadato_Expediente().getParteB()) {
                if (partebuscar.getNombrePersona().equals(pp.getNombrePersona())) {
                    return buscar;
                }
            }
        }
        return null;
    }

    @Override
    public void eliminarProceso(int numradicado) throws IOException {
        int contador = 0;
        Iterator<Proceso> i = this.lista.iterator();
        while (i.hasNext()) {
            Proceso jp = i.next();
            if (jp.getMetadato_Expediente().getNumradicado() == (numradicado)) {
                i.remove();
            }
        }
    }

    @Override
    public List<Proceso> consultarProcesos(String filtroTexto) throws IOException {
        List<Proceso> encontrados = new ArrayList();
        for (Proceso jp : this.lista) {
            if (        jp.getMetadato_Expediente().getParteA().contains(filtroTexto) ||
                        jp.getMetadato_Expediente().getParteB().contains(filtroTexto)) {
                encontrados.add(jp);
            }
        }
        return encontrados;
    }

}
