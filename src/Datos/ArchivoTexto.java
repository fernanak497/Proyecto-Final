
package Datos;

import Dominio.Parte_Procesal;
import Dominio.Proceso;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ArchivoTexto implements AsociarProcesos{
    private File archivo;
    private FileWriter modoEscritura; // abre el archivo para escritura
    private Scanner modoLectura; // abre el archivo en modo lectura

    public ArchivoTexto() {
        this.archivo = new File("Expedientes.pdf");
    }

    public ArchivoTexto(String nombreArchivo) {
        this.archivo = new File(nombreArchivo);
    }

    @Override
    public void insertaProcesos(Proceso p) throws IOException {
        PrintWriter pw = null;
        try {
            this.modoEscritura = new FileWriter(this.archivo, true); // modo edicion
            pw = new PrintWriter(this.modoEscritura);
            pw.println(p.toString());
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (pw != null) {
                pw.close();
            }
            this.modoEscritura.close();
        }

    }
    
     private Proceso crearProceso(String linea) {

        String datos[] = linea.split(";");
        Proceso p = new Proceso();
        p.getMetadato_Expediente().setNumradicado(Integer.parseInt(datos[0]));
        p.getMetadato_Expediente().getLocalidad().setNombreCiudad(datos[1]);
        p.getMetadato_Expediente().getLocalidad().setNombreDepto(datos[2]);
        p.getMetadato_Expediente().getDespacho_Judicial().setCategoria(datos[3]);
        p.getMetadato_Expediente().getDespacho_Judicial().setCodigo(Integer.parseInt(datos[4]));
        p.getMetadato_Expediente().getDespacho_Judicial().setCategoria(datos[5]);
        p.getMetadato_Expediente().getSerie().setCodigo(Integer.parseInt(datos[6]));
        p.getMetadato_Expediente().getSerie().setDescripcion(datos[7]);
        p.getMetadato_Expediente().getSerie().getSubserie().setCodigo(Integer.parseInt(datos[8]));
        p.getMetadato_Expediente().getSerie().getSubserie().setDescripcion(datos[9]);
        p.getMetadato_Expediente().getSerie().getSubserie().getTipo_Documental().setCodigo(Integer.parseInt(datos[10]));
        p.getMetadato_Expediente().getSerie().getSubserie().getTipo_Documental().setDescripcion(datos[11]);
        p.getMetadato_Expediente().getnCuaderno().setNumCuaderno(Integer.parseInt(datos[12]));
        p.getMetadato_Expediente().getnCuaderno().setDescripcion(datos[13]);
         
        
        
        return p;
    }

    @Override
    public List<Proceso> leerProcesos() throws IOException {
        List<Proceso> listado = new ArrayList();
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Proceso p = this.crearProceso(linea);
                listado.add(p);
            }
            return listado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }
    }

    @Override
    public Proceso buscarnumRadicado(Proceso po) throws IOException {
        Proceso encontrado = null;
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Proceso p = this.crearProceso(linea);
                if (p.equals(p.getMetadato_Expediente().getNumradicado())){
                    encontrado = p;
                    break;
                }  
            }
            return encontrado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }
    }

    @Override
    public Proceso buscarDemandado(Parte_Procesal pp) throws IOException {
         Proceso encontrado = null;
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Proceso p = this.crearProceso(linea);
                if (p.equals(p.getMetadato_Expediente().getParteB())){
                    encontrado = p;
                    break;
                }  
            }
            return encontrado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }
    }

    @Override
    public Proceso buscarDemandante(Parte_Procesal pp) throws IOException {
         Proceso encontrado = null;
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Proceso p = this.crearProceso(linea);
                if (p.equals(p.getMetadato_Expediente().getParteA())){
                    encontrado = p;
                    break;
                }  
            }
            return encontrado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }
    }
    
    private void renombrarArchivo(File nvoArchivo) throws IOException {
        
        if (!nvoArchivo.exists())   // se crea el archivo temporal si no existe
            nvoArchivo.createNewFile();
        
        if (!this.archivo.delete()) //se elimina el archivo original
            throw new IOException("No fue posible eliminar el archivo original");
        
        if (!nvoArchivo.renameTo(this.archivo)) //se renombra el archivo temporal
            throw new IOException("No fue posible renombrar el archivo temporal");
        
    }

    @Override
    public void eliminarProceso(int numradicado) throws IOException {
        try {
            this.modoLectura = new Scanner(this.archivo);
            ArchivoTexto archivoTemporal = new ArchivoTexto("Temporal.dat");
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Proceso p = this.crearProceso(linea);
                    if (!p.equals(p.getMetadato_Expediente().getNumradicado())) {// eliminar
                        archivoTemporal.insertaProcesos(p);
                    }
            }
            this.modoLectura.close();
            this.renombrarArchivo(archivoTemporal.archivo);
            
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            this.modoLectura.close();
        }
    }

    @Override
    public List<Proceso> consultarProcesos(String filtroTexto) throws IOException {
        List<Proceso> listado = new ArrayList();
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Proceso jp = this.crearProceso(linea);
                if (jp.getMetadato_Expediente().getParteA().contains(filtroTexto) ||
                        jp.getMetadato_Expediente().getParteB().contains(filtroTexto)) {
                    listado.add(jp);
                }
            }
            return listado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }
    }
    
    
}
