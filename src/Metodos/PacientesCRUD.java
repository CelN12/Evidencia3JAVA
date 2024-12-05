package Metodos;

import Entidades.Doctor;
import Entidades.Paciente;

import java.io.*;
import java.util.ArrayList;

public class PacientesCRUD {
    public void agregarPaciente(Paciente paciente){
        try{
            FileInputStream leer = new FileInputStream("C:\\Users\\user\\Desktop\\Pacientes.txt");
            ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
            Object o = lectorObjetos.readObject();
            ArrayList<Paciente> lista = (ArrayList<Paciente>) o;
            lista.add(paciente);
            lectorObjetos.close();
            leer.close();
            FileOutputStream escribir = new FileOutputStream("C:\\Users\\user\\Desktop\\Pacientes.txt");
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(escribir);
            escritorObjetos.writeObject(lista);
            escritorObjetos.flush();
            escritorObjetos.close();
            escribir.close();
        }catch (FileNotFoundException e){
            System.out.println("Error al leer el archivo");
        }catch (IOException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Paciente getInfoPacienteID(String id){
        FileInputStream leer;
        try{
            leer = new FileInputStream("C:\\Users\\user\\Desktop\\Pacientes.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object milista = miStream2.readObject();
            ArrayList<Paciente> listaPacientes = (ArrayList<Paciente>) milista;
            Paciente paciente;
            for (int i = 0; i < listaPacientes.size(); i++){
                paciente = listaPacientes.get(i);
                if(id.equals(paciente.getId())){
                    leer.close();
                    return paciente;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            leer.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        return null;
    }
}
