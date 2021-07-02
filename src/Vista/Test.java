package Vista;

import Dominio.Proceso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Test {
    static JTextField userText;
    static JPasswordField passwordText;
    static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame("Panel Usuario");
        frame.setSize(330, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

   private static void placeComponents(JPanel panel) {

        panel.setLayout(null);
        
        JLabel userLabel = new JLabel("Usuario");
        userLabel.setBounds(28, 10, 250, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Contraseña");
        passwordLabel.setBounds(28, 40, 250, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 40, 160, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Ingresar");
        loginButton.setBounds(20, 80, 100, 25);
        loginButton.addActionListener(new IniciarSesion());
        panel.add(loginButton);
    }

    
    public static void imprimirListado(List<Proceso> lista){
        for(Proceso p : lista){
            System.out.println(p);
        }
        System.out.println(lista.size() + " Jugadores registrados");
    }

    public static void iniciarSesion() {
        String usuario = userText.getText();
        char[] password = passwordText.getPassword();
        String passwordS = password == null ? "" : String.valueOf(password);

        if (usuario != null && usuario.equals("admin") && passwordS.equals("1234")) {
            frame.dispose();
            VentanaPrincipal v = new VentanaPrincipal();
        } else {
            JOptionPane.showMessageDialog(frame, "Usuario inválido", "Iniciar sesion", JOptionPane.ERROR_MESSAGE);
        }
    }
    
   static class IniciarSesion implements ActionListener {

       @Override
       public void actionPerformed(ActionEvent actionEvent) {
           iniciarSesion();
       }
   }

}

