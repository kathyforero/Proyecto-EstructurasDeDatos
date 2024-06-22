package Proyectos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;


public class Archivos {
   
    public static void guardarUsuarios(Map<String, Usuario> usuarios) {
        File archivo = new File("Usuarios.dat");

        try {
            // Crear el archivo si no existe
            if (!archivo.exists()) {
                archivo.createNewFile();
                System.out.println("ARCHIVO DE USUARIOS CREADO CON EXITO");
            }

            // Escribir el mapa de usuarios en el archivo
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
                out.writeObject(usuarios);
                System.out.println("USUARIOS GUARDADOS CON EXITO!");
            } catch (IOException e) {
                System.err.println("ERROR AL GUARDAR!!!: "+ e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("NO SE CREO EL ARCHIVO " + e.getMessage());
        }
    }    
    
    
    public static Map<String, Usuario> leerUsuarios() {
        Map<String, Usuario> usuarios = null;
        File archivo = new File("Usuarios.dat");

        try {
            // Leer el mapa de usuarios del archivo
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
                usuarios = (Map<String, Usuario>) in.readObject();
                System.out.println("USUARIOS LEIDOS CON EXITO!");
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("ERROR AL LEER!!! " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("ERROR AL PROCESAR" + e.getMessage());
        }

        if (usuarios == null) {
            usuarios = new HashMap<>(); // Si no se pudo leer, retornar mapa vacío
        }
        return usuarios;
    }
}
