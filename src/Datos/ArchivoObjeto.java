
package Datos;

import Dominio.Parte_Procesal;
import Dominio.Proceso;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class ArchivoObjeto implements AsociarProcesos{

    private File archivo;
    private FileInputStream aLectura;
    private FileOutputStream aEscritura;

    public ArchivoObjeto(String name) {
        this.archivo = new File(name);
    }

    public ArchivoObjeto() {
        this("Expedientes.obj");
    }
    
    private void guardar(ListAccesoDatos lista) throws IOException {
        ObjectOutputStream oos = null;
        try {
            this.aEscritura = new FileOutputStream(this.archivo, false);
            oos = new ObjectOutputStream(this.aEscritura);
            oos.writeObject(lista);
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (oos != null) {
                oos.close();
            }

            if (this.aEscritura != null) {
                this.aEscritura.close();
            }
        }
    }
    
    private ListAccesoDatos leer() throws IOException {
        ListAccesoDatos lista = null;
        ObjectInputStream ois = null;

        if (this.archivo.exists()) {
            try {
                this.aLectura = new FileInputStream(this.archivo);
                ois = new ObjectInputStream(this.aLectura);
                lista = (ListAccesoDatos) ois.readObject();
                return lista;
            } catch (IOException ioe) {
                throw ioe;
            } catch (ClassNotFoundException ex) {
                throw new IOException("La clase ListAccesoDatos No existe");
            } finally {
                if (ois != null) {
                    ois.close();
                }
                if (this.aLectura != null) {
                    this.aLectura.close();
                }
            }
        }
        else{
            lista = new ListAccesoDatos();
            return lista;
        }

    }
    
    @Override
    public void insertaProcesos(Proceso p) throws IOException {
        ListAccesoDatos lista = this.leer();
        lista.insertaProcesos(p);
        this.guardar(lista);
    }

    @Override
    public List<Proceso> leerProcesos() throws IOException {
        ListAccesoDatos lista = this.leer();
        return lista.leerProcesos();
    }

    @Override
    public Proceso buscarnumRadicado(Proceso po) throws IOException {
        ListAccesoDatos lista = this.leer();
        return lista.buscarnumRadicado(po);
    }

    @Override
    public Proceso buscarDemandado(Parte_Procesal pp) throws IOException {
        ListAccesoDatos lista = this.leer();
        return lista.buscarDemandado(pp);
    }

    @Override
    public Proceso buscarDemandante(Parte_Procesal pp) throws IOException {
        ListAccesoDatos lista = this.leer();
        return lista.buscarDemandado(pp);
    }

    @Override
    public void eliminarProceso(int numradicado) throws IOException {
        ListAccesoDatos lista = this.leer();
        lista.eliminarProceso(numradicado);
        this.guardar(lista);
    }

    @Override
    public List<Proceso> consultarProcesos(String filtroTexto) throws IOException {
        ListAccesoDatos lista = this.leer();
        return  lista.consultarProcesos(filtroTexto);
    }
    
}
