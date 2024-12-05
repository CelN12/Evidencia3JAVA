import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame{
    private JPanel miPanel;
    private JButton btnDoctores;
    private JButton btnCitas;
    private JButton btnPacientes;

    public Principal() {
        btnDoctores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String array[] = {"admin"};
                Doctores.main(array);
            }
        });
        btnPacientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String array[] = {"admin"};
                ventanaPacientes.main(array);
            }
        });
        btnCitas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String array[] = {"admin"};
                ventanasCitas.main(array);
            }
        });
    }

    public static void main(String[] args) {
        Principal vPrincipal = new Principal();
        vPrincipal.setContentPane(vPrincipal.miPanel);
        vPrincipal.setSize(500,500);
        vPrincipal.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        vPrincipal.setVisible(true);
    }
}
