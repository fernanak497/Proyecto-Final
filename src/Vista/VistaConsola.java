package Vista;

import Dominio.*;
import Negocio.GestionProceso;
import java.io.IOException;
import java.util.*;

public class VistaConsola {

    private int codigo;
    private String descripcion;
    Scanner op = new Scanner(System.in);
    Scanner sc = new Scanner(System.in);
    Scanner dato = new Scanner(System.in);
    Dominio.Localidad lc;
    Dominio.Despacho_Judicial dj;
    Dominio.Serie se;
    Dominio.Subserie sb;
    Dominio.Proceso p;
    Dominio.Parte_Procesal ppa;
    Dominio.Parte_Procesal ppb;
    Dominio.Cuaderno nc;
    Dominio.Datos d;
    Dominio.Fechas f;
    Dominio.FormaDoc fd;
    Dominio.Observacion o;
    

    private String titulos[] = {
        " 1.  Registro del Expediente",
        " 2.  Consultar Registro",
        " 3.  Finalizar proceso\n"
    };
    private int opcion;
    private Scanner lector;
    private GestionProceso logica;

    private String titulos1[] = {
        " 1.  Expediente",
        " 2.  Documento",
        " 3.  Mostrar registro",
        " 4.  Finalizar registro\n"
    };

    private int opcionmenu;
    
    private String titulos2[] = {
        " 1.  Numero de radicacion",
        " 2.  Demandado",
        " 3.  Demandante",
        " 4.  Finalizar consulta\n"
    };

    private int opcionmenu2;
    
    public VistaConsola() {
        this.lector = new Scanner(System.in);
        this.logica = new GestionProceso();
        p = new Dominio.Proceso();
    }

    public void ejecutarMenu() throws IOException {
        do {
            this.imprimirTitulos();
            this.leerOpcion();
            this.ejecutarOpcion();
        } while (this.opcion != 3);
    }

    public void ejecutarMenu1() throws IOException {
        do {
            this.imprimirTitulos1();
            this.leerOpcion1();
            this.ejecutarOpcion1();
        } while (this.opcionmenu != 4);
    }

    public void ejecutarMenu2() throws IOException {
        do {
            this.imprimirTitulos2();
            this.leerOpcion2();
            this.ejecutarOpcion2();
        } while (this.opcionmenu2 != 4);
    }

    public void imprimirTitulos() {
        System.out.println("\n PROCESO DE DIGITALIZACION \n");
        for (int i = 0; i < this.titulos.length; i++) {
            System.out.println(this.titulos[i]);
        }
    }

    public void imprimirTitulos1() {
        System.out.println("\n REGISTRAR PROCESO \n");
        for (int i = 0; i < this.titulos1.length; i++) {
            System.out.println(this.titulos1[i]);
        }
    }

    public void imprimirTitulos2() {
        System.out.println("\n CONSULTA DE PROCESO JUDICIAL \n");
        for (int i = 0; i < this.titulos2.length; i++) {
            System.out.println(this.titulos2[i]);
        }
    }

    public void leerOpcion() {
        boolean excepcion = true;
        do {
            try {
                System.out.print(" Seleccione una opcion: ");
                this.opcion = this.lector.nextInt();
                excepcion = false;
            } catch (java.util.InputMismatchException ime) {
                System.out.println("Se requiere valor entero, intente nuevamente");
                excepcion = true;
                this.lector.nextLine();
            }
        } while (excepcion);
    }

    public void leerOpcion1() {
        boolean excepcion1 = true;
        do {
            try {
                System.out.print(" Seleccione una opcion: ");
                this.opcionmenu = this.lector.nextInt();
                excepcion1 = false;
            } catch (java.util.InputMismatchException ime) {
                System.out.println("Se requiere valor entero, intente nuevamente");
                excepcion1 = true;
                this.lector.nextLine();
            }
        } while (excepcion1);
    }

    public void leerOpcion2() {
        boolean excepcion2 = true;
        do {
            try {
                System.out.print(" Seleccione una opcion: ");
                this.opcionmenu2 = this.lector.nextInt();
                excepcion2 = false;
            } catch (java.util.InputMismatchException ime) {
                System.out.println("Se requiere valor entero, intente nuevamente");
                excepcion2 = true;
                this.lector.nextLine();
            }
        } while (excepcion2);
    }

    public void ejecutarOpcion() throws IOException {
        switch (this.opcion) {
            case 1:
                this.registroExpediente();
                break;
            case 2:
                this.consultarRegistro();
                break;
            case 3:
                System.out.println("Ha finalizado el registro....");
                System.out.println("....................................");
                System.exit(0);
                break;
            default:
                System.out.println("Opcion no valida, intente nuevamente..");
                break;
        }
    }

    public void ejecutarOpcion1() throws IOException {
       
        switch (this.opcionmenu) {
            case 1:
                this.procesoExpediente();
                
                this.logica.insertaProcesos(p);
                break;
            case 2:
                if(p.getMetadato_Expediente()==null){
                    System.out.println("Primero debe registrar el expediente"); 
                }else{
                    this.procesoDocumento();
                }
                break;
            case 3:
                this.mostrarRegistro();
                break;
            case 4:
                System.out.println("Ha finalizado el registro....");
                System.out.println("....................................");
                ejecutarMenu();
                break;
            default:
                System.out.println("Opcion no valida, intente nuevamente..");
                break;
        }
    }

    public void ejecutarOpcion2() throws IOException {
        switch (this.opcionmenu2) {
            case 1:
                this.procesoRadicado();
                break;
            case 2:
                this.procesoDemandado();
                break;
            case 3:
                this.procesoDemandante();
                break;
            case 4:
                System.out.println("Ha finalizado la consulta....");
                System.out.println("....................................");
                ejecutarMenu1();
                break;
            default:
                System.out.println("Opcion no valida, intente nuevamente..");
                break;
        }
    }

    public void registroExpediente() throws IOException {
        ejecutarMenu1();
    }

    public void procesoExpediente() throws IOException {
        System.out.println("\n----------------------------");
        System.out.println("  REGISTRO DEL EXPEDIENTE");
        System.out.println("----------------------------");
        
        System.out.println("\n PROCESO");
        
        System.out.print("- Numero de radicacion (max 23): ");
        int numRadicacion = dato.nextInt();
        dato.nextLine();
        
        System.out.println("----------------------------");
        
        System.out.println("\nLOCALIDAD");
        lc = new Dominio.Localidad();

        System.out.print("- Departamento: ");
        String nombreDepto = dato.nextLine();
        lc.setNombreDepto(nombreDepto);

        System.out.print("- Ciudad: ");
        String nombreCiudad = dato.nextLine();
        lc.setNombreCiudad(nombreCiudad);
        System.out.println("----------------------------");

        System.out.println("\n DESPACHO JUDICIAL");
        dj = new Dominio.Despacho_Judicial();

        System.out.print("- Nombre: ");
        String nombreDespacho = dato.nextLine();
        dj.setNombreDespacho(nombreDespacho);

        System.out.print("- Codigo: ");
        codigo = dato.nextInt();
        dato.nextLine();
        dj.setCodigo(codigo);
        
        System.out.print("- Categoria(municipal o circuito): ");
        String categoria = dato.next();
        dj.setCategoria(categoria);
        System.out.println("----------------------------");

        System.out.println("\n SERIE");
        se = new Dominio.Serie();

        System.out.print("- Codigo: ");
        codigo = dato.nextInt();
        dato.nextLine();
        se.setCodigo(codigo);

        System.out.print("- Descripcion: ");
        descripcion = dato.next();
        se.setDescripcion(descripcion);
        System.out.println("----------------------------");

        System.out.println("\n SUBSERIE");
        sb = new Dominio.Subserie();

        System.out.print("- Codigo: ");
        codigo = dato.nextInt();
        dato.nextLine();
        sb.setCodigo(codigo);

        System.out.print("- Descripcion: ");
        descripcion = dato.next();
        sb.setDescripcion(descripcion);
        System.out.println("----------------------------");

        System.out.println("\n PARTES PROCESALES");
        ppa = new Dominio.Parte_Procesal();
        ppb = new Dominio.Parte_Procesal();
       
        System.out.print("- Demandado: ");
        String nombrePersona = dato.next();
        ppa.setNombrePersona(nombrePersona);
        
        System.out.print("- Identificacion: ");
        int identificacion = dato.nextInt();
        dato.nextLine();
        ppa.setIdentificacion(identificacion);
        
        System.out.print("- Tipo Identificacion: ");
        String TipoId = dato.next();
        ppa.setTipoId(TipoId);
        
        System.out.print("- Tipo de la persona(natural, jurídica, entidad del estado): ");
        String tipoPersona = dato.next();
        ppa.setTipoPersona(tipoPersona);

        System.out.print("- Demandante: ");
        nombrePersona = dato.next();
        ppb.setNombrePersona(nombrePersona);
        
        System.out.print("- Identificacion: ");
        identificacion = dato.nextInt();
        dato.nextLine();
        ppb.setIdentificacion(identificacion);
        
        System.out.print("- Tipo Identificacion: ");
        TipoId = dato.next();
        ppb.setTipoId(TipoId);
        
        System.out.print("- Tipo de la persona(natural, jurídica, entidad del estado): ");
        tipoPersona = dato.next();
        ppb.setTipoPersona(tipoPersona);
        
        System.out.println("----------------------------");

        System.out.println("\n CUADERNO");
        nc = new Dominio.Cuaderno();

        System.out.print("- Numero: ");
        int numCuaderno = dato.nextInt();
        dato.nextLine();
        nc.setNumCuaderno(numCuaderno);

        System.out.print("- Descripcion: ");
        descripcion = dato.nextLine();
        nc.setDescripcion(descripcion);
        System.out.println(" \n*REGISTRO FINALIZADO* ");
        System.out.println("----------------------------");
        Metadato_Expediente metadato_Expediente = new Metadato_Expediente(numRadicacion,lc,dj,se,nc);
        metadato_Expediente.getParteA().add(ppa);
        metadato_Expediente.getParteB().add(ppb);
        p.setMetadato_Expediente(metadato_Expediente);
    }

    public void procesoDocumento() throws IOException {
        System.out.println("\n----------------------------");
        System.out.println("    REGISTRO DEL DOCUMENTO");
        System.out.println("----------------------------");
        System.out.println(" \nDATOS");
        d = new Dominio.Datos();

        System.out.print("- Nombre: ");
        String nombreDocumento = dato.next();
        d.setNombreDocumento(nombreDocumento);

        System.out.print("- Numero de paginas: ");
        int numpaginas = dato.nextInt();
        d.setNumpaginas(numpaginas);

        System.out.print("- Pagina de Inicio: ");
        int inicio = dato.nextInt();
        d.setInicio(inicio);

        System.out.print("- Pagina final: ");
        int fin = dato.nextInt();
        d.setFin(fin);

        System.out.print("- Origen: ");
        String origenDocumento = dato.next();
        d.setOrigenDocumento(origenDocumento);
        System.out.println("----------------------------");

        System.out.println("\n FECHAS"); //(DIA-MES-AÑO)
        f = new Dominio.Fechas();

        System.out.print("- Fecha de creacion(DIA/MES/AÑO): ");
        String fCreacion = dato.next();
        f.setfCreacion(fCreacion);

        System.out.print("- Fecha de incorporacion(DIA/MES/AÑO): ");
        String fIncorporacion = dato.next();
        f.setfIncorporacion(fIncorporacion);
        System.out.println("----------------------------");

        System.out.println("\n FORMATO Y TAMAÑO");
        fd = new Dominio.FormaDoc();

        System.out.print("- Formato: ");
        String formato = dato.next();
        fd.setFormato(formato);

        System.out.print("- Tamaño: ");
        double tamaño = dato.nextDouble();
        fd.setTamaño(tamaño);
        System.out.println("----------------------------");

        System.out.println("\n OBSERVACIONES");
        o = new Dominio.Observacion();

        System.out.print("- Observacion: ");
        String observacion = dato.next();
        o.setObservacion(observacion);
        System.out.println(" \n*REGISTRO FINALIZADO* ");
        System.out.println("----------------------------");
        Metadato_Documento metadato_Documento = new Metadato_Documento(d,f,fd,o);
        p.getMetadato_Documento().add(metadato_Documento);
        
    }

    public void mostrarRegistro() throws IOException {
        try {
            System.out.println("\n----------------------------");
            System.out.println("      VISTA PROCESO");
            System.out.println("----------------------------");

            System.out.println("\nPROCESO");
            System.out.println("\nNumero Radicado: " + p.getMetadato_Expediente().getNumradicado());
            
            System.out.println("\nLOCALIDAD\n" + lc);

            System.out.println("\nDESPACHO JUDICIAL");
            System.out.println(dj);

            System.out.println("\nSERIE");
            System.out.println(se);

            System.out.println("\nSUBSERIE");
            System.out.println(sb);

            System.out.println("\nPARTES PROCESALES");
            System.out.println("\nDEMANDADO: ");
            System.out.println(ppa);
            System.out.println("\nDEMANDANTE: ");
            System.out.println(ppb);

            System.out.println("\nCUADERNO");
            System.out.println(nc);

            System.out.println("\nDATOS");
            System.out.println(d);

            System.out.println("\nFECHAS");
            System.out.println(f);

            System.out.println("\nFORMATO Y TAMAÑO");
            System.out.println(fd);

            System.out.println("\nOBSERVACIONES ");
            System.out.println(o);

        } catch (java.lang.NullPointerException exc) {
            System.out.println("El expediente no ha sido llenado");
        } finally {
            System.out.println("    \n    *VISTA FINALIZADA* ");
            System.out.println("----------------------------");
        }
    }

    public void consultarRegistro() throws IOException {
        ejecutarMenu2();
    }

    public void procesoRadicado(){
        System.out.println(" CONSULTA POR NUMERO DE RADICACION\n");
        try{
            System.out.print("- Numero de radicado a buscar: ");
            int numRadicado = lector.nextInt();
            Proceso encontrado = this.logica.buscarnumRadicado(new Proceso(numRadicado));
            if(encontrado == null){
                System.out.println("Numero de radicado no encontrado");
            }else{
                System.out.println(encontrado);
            }
        }catch(IOException ex){
            System.out.println("Valores invalidos....");
        } 
    }

    public void procesoDemandado() {
        System.out.println(" CONSULTA POR DEMANDADO\n");
        try{
            System.out.print("- Demandado a buscar: ");
            lector.nextLine();
            String  nombrePersona = lector.nextLine();
            Proceso encontrado = this.logica.buscarDemandado(new Parte_Procesal(nombrePersona));
            if(encontrado == null){
                System.out.println("Demandado no encontrado");
            }else{
                System.out.println(encontrado);
            }
        }catch(IOException ex){
            System.out.println("Demandado no encontrado..");
        } 
    }

    public void procesoDemandante() {
        System.out.println(" CONSULTA POR DEMANDANTE\n");
         try{
            System.out.print("- Demandante a buscar: ");
            lector.nextLine();
            String  nombrePersona = lector.nextLine();
            Proceso encontrado = this.logica.buscarDemandante(new Parte_Procesal(nombrePersona));
            if(encontrado == null){
                System.out.println("Demandante no encontrado");
            }else{
                System.out.println(encontrado);
            }
        }catch(IOException ex){
            System.out.println("Demandado no encontrado..");
        }
    }
}
