package Proyectos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;


public class Archivos {
    
    public static void guardarUsuarios(Map<String, Usuario> usuarios) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Usuarios.dat"))) {
            out.writeObject(usuarios);
            System.out.println("USUARIOS GUARDADOS CON EXITO!");
        } catch (IOException e) {
            System.err.println("ERROR AL GUARDAR!!!: " + e.getMessage());
        }
    }
    
    public static Map<String, Usuario> leerUsuarios() {
        Map<String, Usuario> usuarios = new HashMap<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Usuarios.dat"))) {
            usuarios = (Map<String, Usuario>) in.readObject();
            System.out.println("USUARIOS LEIDOS CON EXITO!");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("ERROR AL LEER!!! " + e.getMessage());
        }
        return usuarios;
    } 
    
    
}
