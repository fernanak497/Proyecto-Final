
package Vista;

import Negocio.GestionProceso;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class VentanaRegistro extends JDialog {
   
    private Container contenedor;
    private JPanel panelDatos, panelBotones;
    private GestionProceso gestor;
    
    public VentanaRegistro(JFrame frame, boolean bln) {
        super(frame, bln);
        this.gestor = new GestionProceso();
        this.setTitle("Procesos");
        this.setSize(400, 500);
        this.iniciarComponentes();
        //this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void iniciarComponentes() {
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.iniciarPanelDatos();
        this.iniciarPanelBotones();
    }
    
    public void iniciarPanelDatos() {
        this.panelDatos = new JPanel();
        this.panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.panelDatos.setLayout(new GridLayout(9, 2, 5, 5));
    
    }
    
    public void iniciarPanelBotones() {

        this.panelBotones = new JPanel();
        this.panelBotones.setLayout(new GridLayout(3, 1, 5, 5));
    }
}
