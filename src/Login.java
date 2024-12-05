import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JPanel miPanel;
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnLogin;
    private JButton btnCancelar;

    public Login() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = String.valueOf(txtContrasena.getPassword());
                if(txtUsuario.getText().equals("admin") && password.equals("1234")){
                    String[] arrayString = {"admin"};
                    Principal.main(arrayString);
                }else if(txtUsuario.getText().equals("usuario") && password.equals("4567")){
                    String[] arrayString = {"admin"};
                    Principal.main(arrayString);
                }else{
                    JOptionPane.showMessageDialog(miPanel, "Usuario o Contrasena incorrectos", "Login", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        Login vLogin = new Login();
        vLogin.setContentPane(vLogin.miPanel);
        vLogin.setSize(300,300);
        vLogin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        vLogin.setVisible(true);


    }
}
