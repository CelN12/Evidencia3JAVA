import Entidades.Paciente;
import Metodos.PacientesCRUD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaPacientes extends JFrame{
    private JTextField txtNombre;
    private JTextField txtApellidoP;
    private JTextField txtApellidoM;
    private JTextField txtEdad;
    private JTextField txtEstatura;
    private JTextField txtPeso;
    private JTextField txttipoSangre;
    private JTextField txtID;
    private JPanel miPanel;
    private JButton btnBuscar;
    private JButton btnAgregar;
    private JButton btnLimpiar;

    public boolean verificarCampos(){
        if(txtNombre.getText().equals("")||txtApellidoP.getText().equals("")||txtApellidoM.getText().equals("")||txtEdad.getText().equals("")||txtEstatura.getText().equals("")||
        txtPeso.getText().equals("")||txttipoSangre.getText().equals("")|| txtID.getText().equals("")){
            return false;
        }else{
            return true;
        }
    }

    public ventanaPacientes() {
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PacientesCRUD pacientescrud = new PacientesCRUD();
                String id = txtID.getText();
                Paciente paciente = pacientescrud.getInfoPacienteID(id);
                if(paciente == null){
                    JOptionPane.showMessageDialog(miPanel, "No se ha encontrado al Paciente","" , JOptionPane.ERROR_MESSAGE);
                }else{
                    txtNombre.setText(paciente.getNombre());
                    txtApellidoP.setText(paciente.getApellidoP());
                    txtApellidoM.setText(paciente.getApellidoM());
                    txtEdad.setText(paciente.getEdad());
                    txtEstatura.setText(paciente.getEstatura());
                    txtPeso.setText(paciente.getPeso());
                    txttipoSangre.setText(paciente.getTipoSangre());
                }
            }
        });
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(verificarCampos()) {
                    Paciente paciente = new Paciente();
                    paciente.setNombre(txtNombre.getText());
                    paciente.setApellidoP(txtApellidoP.getText());
                    paciente.setApellidoM(txtApellidoM.getText());
                    paciente.setEdad(txtEdad.getText());
                    paciente.setId(txtID.getText());
                    paciente.setEstatura(txtEstatura.getText());
                    paciente.setPeso(txtPeso.getText());
                    paciente.setTipoSangre(txttipoSangre.getText());
                    PacientesCRUD pacientescrud = new PacientesCRUD();
                    pacientescrud.agregarPaciente(paciente);
                    JOptionPane.showMessageDialog(miPanel, "Paciente agregado correctamente");
                }else{
                    JOptionPane.showMessageDialog(miPanel, "Campos vacios", "Campos vacios", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNombre.setText("");
                txtApellidoP.setText("");
                txtApellidoM.setText("");
                txtEdad.setText("");
                txtPeso.setText("");
                txtID.setText("");
                txtEstatura.setText("");
                txttipoSangre.setText("");
            }
        });
    }

    public static void main(String[] args) {
        ventanaPacientes ventanaPacientes = new ventanaPacientes();
        ventanaPacientes.setContentPane(ventanaPacientes.miPanel);
        ventanaPacientes.setSize(600,600);
        ventanaPacientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPacientes.setVisible(true);
    }
}
