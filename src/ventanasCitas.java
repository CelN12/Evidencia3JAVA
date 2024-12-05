import Entidades.Cita;
import Metodos.CitasCRUD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanasCitas extends JFrame{
    private JTextField txtNombrePaciente;
    private JTextField txtNombreDoctor;
    private JTextField txtFecha;
    private JTextArea txtArea;
    private JButton btnAgregar;
    private JButton btnLimpiar;
    private JPanel miPanel;

    public ventanasCitas() {
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(verificarCampos()){
                    Cita cita = new Cita();
                    cita.setFecha(txtFecha.getText());
                    cita.setNombreDoctor(txtNombreDoctor.getText());
                    cita.setNombrePaciente(txtNombrePaciente.getText());
                    cita.setObservaciones(txtArea.getText());
                    CitasCRUD citasCRUD = new CitasCRUD();
                    citasCRUD.agregarCita(cita);
                    JOptionPane.showMessageDialog(miPanel, "Cita agregada correctamente");
                }else{
                    JOptionPane.showMessageDialog(miPanel, "Campos vacios", "Campos vacios", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNombreDoctor.setText("");
                txtNombrePaciente.setText("");
                txtFecha.setText("");
                txtArea.setText("");
            }
        });
    }

    public boolean verificarCampos(){
        if(txtNombrePaciente.getText().equals("") || txtNombreDoctor.getText().equals("") || txtFecha.getText().equals("") || txtArea.getText().equals("")){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        ventanasCitas ventanasCitas = new ventanasCitas();
        ventanasCitas.setContentPane(ventanasCitas.miPanel);
        ventanasCitas.setSize(600,600);
        ventanasCitas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanasCitas.setVisible(true);
    }
}
