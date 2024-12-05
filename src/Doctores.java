import Entidades.Doctor;
import Metodos.DoctoresCRUD;

import javax.print.Doc;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Doctores extends JFrame{
    private JTextField txtNombre;
    private JTextField txtApellidoP;
    private JTextField txtApellidoM;
    private JTextField textCorreo;
    private JTextField txtTurno;
    private JTextField txtID;
    private JTextField txtDepartamento;
    private JTextField txtEspecialidad;
    private JTextField txtEdad;
    private JButton btnBuscar;
    private JButton btnAgregar;
    private JButton btnLimpiar;
    private JPanel miPanel;

    public Doctores() {
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoctoresCRUD doccrud = new DoctoresCRUD();
                String id = txtID.getText();
                Doctor doctor = doccrud.getInfoDoctorporID(id);
                if(doctor == null){
                    JOptionPane.showMessageDialog(miPanel, "No se ha encontrado al Doctor","" , JOptionPane.ERROR_MESSAGE);
                }else{
                    txtNombre.setText(doctor.getNombre());
                    txtApellidoM.setText(doctor.getApellidoM());
                    txtApellidoP.setText(doctor.getApellidoP());
                    textCorreo.setText(doctor.getCorreo());
                    txtTurno.setText(doctor.getTurno());
                    txtID.setText(doctor.getIdDoctor());
                    txtDepartamento.setText(doctor.getDepartamento());
                    txtEspecialidad.setText(doctor.getEspecialidad());
                    txtEdad.setText(String.valueOf(doctor.getEdad()));
                }
            }
        });
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(verificarCampos()) {
                    Doctor doctor = new Doctor();
                    doctor.setIdDoctor(txtID.getText());
                    doctor.setNombre(txtNombre.getText());
                    doctor.setApellidoP(txtApellidoP.getText());
                    doctor.setApellidoM(txtApellidoM.getText());
                    doctor.setEdad(Integer.parseInt(txtEdad.getText()));
                    doctor.setCorreo(textCorreo.getText());
                    doctor.setTurno(txtTurno.getText());
                    doctor.setDepartamento(txtDepartamento.getText());
                    doctor.setEspecialidad(txtEspecialidad.getText());
                    DoctoresCRUD doccrud = new DoctoresCRUD();
                    doccrud.agregarDoctor(doctor);
                    JOptionPane.showMessageDialog(miPanel, "Doctor agregado correctamente");
                }else{
                    JOptionPane.showMessageDialog(miPanel, "Campos vacios", "Campos vacios", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtID.setText("");
                txtNombre.setText("");
                txtApellidoM.setText("");
                txtApellidoP.setText("");
                txtTurno.setText("");
                txtEdad.setText("");
                txtDepartamento.setText("");
                txtEspecialidad.setText("");
                textCorreo.setText("");
            }
        });
    }

    public boolean verificarCampos(){
        if(txtNombre.getText().equals("") || txtApellidoP.getText().equals("") || txtApellidoM.getText().equals("") || txtEdad.getText().equals("") || txtID.getText().equals("") ||
        txtDepartamento.getText().equals("") || txtEspecialidad.getText().equals("") || textCorreo.getText().equals("") || txtTurno.getText().equals("")){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        Doctores doctores = new Doctores();
        doctores.setContentPane(doctores.miPanel);
        doctores.setSize(600,600);
        doctores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        doctores.setVisible(true);
    }
}
