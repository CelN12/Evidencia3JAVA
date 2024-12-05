package Metodos;
import Entidades.Doctor;

import java.io.*;
import java.util.ArrayList;

public class DoctoresCRUD {

    public void agregarDoctor(Doctor doctor){
        try{
            FileInputStream leer = new FileInputStream("C:\\Users\\user\\Desktop\\Doctores.txt");
            ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
            Object o = lectorObjetos.readObject();
            ArrayList<Doctor> lista = (ArrayList<Doctor>) o;
            lista.add(doctor);
            lectorObjetos.close();
            leer.close();
            FileOutputStream escribir = new FileOutputStream("C:\\Users\\user\\Desktop\\Doctores.txt");
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

    public Doctor getInfoDoctorporID(String id){
        FileInputStream leer;
        try{
            leer = new FileInputStream("C:\\Users\\user\\Desktop\\Doctores.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object milista = miStream2.readObject();
            ArrayList<Doctor> listaDoctores = (ArrayList<Doctor>) milista;
            Doctor doctor;
            for (int i = 0; i < listaDoctores.size(); i++){
                doctor = listaDoctores.get(i);
                if(id.equals(doctor.getIdDoctor())){
                    leer.close();
                    return doctor;
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
