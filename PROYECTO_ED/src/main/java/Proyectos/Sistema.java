package Proyectos;

import Bases.*;
import Proyectos.*;
import javafx.scene.image.Image;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Sistema implements Serializable{
    public static Usuario crearUsuario(String nombre, String apellido, String correo, String contraseña){
        Usuario u = new Usuario(nombre, apellido, correo, contraseña);
        return u;
    }

    public static Auto crearAuto(float precio, MarcaDeAuto marca, String modelo, Tipo tipo, int año, String placa,
                                 int kilometraje, Motor motor, Transmision transmisión, float peso,
                                 Ubicacion ubicacion, Usuario usuario, Estado estado, DoublyCircularList<Image> fotos){
        Auto auto = new Auto( precio,  marca,  modelo,  tipo,  año,  placa,  kilometraje,  motor,  transmisión, 
                              peso,  ubicacion,  usuario,  estado,  fotos);
        return auto;
    }
    
    public static boolean guardarUsuario(Usuario u){
        try{
            Map<String, Usuario> usuarios = Archivos.leerUsuarios();
            usuarios.put(u.getCorreo(),u);
            Archivos.guardarUsuarios(usuarios);
            return true;
        }catch(Exception e) {
            System.err.println("ERROR AL GUARDAR USUARIO!!! " + e.getMessage());
            return false;
        }
    }
    
    public static boolean existeUser(String correo){
        Map<String, Usuario> Usuarios = Archivos.leerUsuarios();
        return Usuarios.containsKey(correo);
    }
    
    public static boolean logearUser(String correo,String contraseña){
        Map<String, Usuario> Usuarios = Archivos.leerUsuarios();
        Usuario u = Usuarios.get(correo);
        return u.getContraseña().equals(contraseña);
    }
    
    public static Usuario getUsuario(String correo){
        Map<String, Usuario> Usuarios = Archivos.leerUsuarios();
        Usuario u = Usuarios.get(correo);
        return u;
    }

    public static boolean guardarAuto(Auto auto){
        try{
            Map<String, Auto> autos = Archivos.leerAutos();
            autos.put(auto.getPlaca(),auto);
            System.out.println("antes de ir a Archivos.guardarAutos");
            Archivos.guardarAutos(autos);
            System.out.println("despues de ir a Archivos.guardarAutos");
            return true;
        }catch(Exception e) {
            System.err.println("ERROR AL GUARDAR AUTO!!! " + e.getMessage());
            return false;
        }
    }
}
