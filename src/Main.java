import Entidades.Cita;
import Entidades.Doctor;
import Entidades.Paciente;

import javax.print.Doc;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        try {
            ArrayList<Cita> citas = new ArrayList<>();
            Cita cita = new Cita();
            cita.setObservaciones("SDASADADS");
            cita.setNombrePaciente("Cesar");
            cita.setNombreDoctor("NOSE");
            cita.setFecha("SADASDDSA");
            citas.add(cita);
            FileOutputStream file = new FileOutputStream("C:\\Users\\user\\Desktop\\Citas.txt");
            ObjectOutputStream mistream = new ObjectOutputStream(file);
            mistream.writeObject(citas);
            mistream.flush();
            mistream.close();
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }catch(IOException e){
            throw new RuntimeException(e);
        }

    }
}