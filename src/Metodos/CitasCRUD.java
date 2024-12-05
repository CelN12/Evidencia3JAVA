package Metodos;

import Entidades.Cita;
import Entidades.Paciente;

import java.io.*;
import java.util.ArrayList;

public class CitasCRUD {
    public void agregarCita(Cita cita){
        try{
            FileInputStream leer = new FileInputStream("C:\\Users\\user\\Desktop\\Citas.txt");
            ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
            Object o = lectorObjetos.readObject();
            ArrayList<Cita> lista = (ArrayList<Cita>) o;
            lista.add(cita);
            lectorObjetos.close();
            leer.close();
            FileOutputStream escribir = new FileOutputStream("C:\\Users\\user\\Desktop\\Citas.txt");
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
}
