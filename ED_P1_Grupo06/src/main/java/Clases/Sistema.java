package Clases;

import Bases.*;
import java.io.File;
import javafx.scene.image.Image;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Sistema implements Serializable{
    private static final long serialVersionUID = 2004140222041502L;
    public static Usuario crearUsuario(String nombre, String apellido, String correo, String contraseña){
        Usuario u = new Usuario(nombre, apellido, correo, contraseña);
        return u;
    }

    public static Auto crearAuto(float precio, MarcaDeAuto marca, String modelo, Tipo tipo, int año, String placa,
                                 int kilometraje, Motor motor, Transmision transmisión, float peso,
                                 Ubicacion ubicacion, Usuario usuario, Estado estado, DoublyCircularList<File> fotos){
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
            DoublyCircularList<Auto> autos = Archivos.leerAutos();
            autos.addLast(auto);
            System.out.println("antes de ir a Archivos.guardarAutos");
            Archivos.guardarAutos(autos);
            System.out.println("despues de ir a Archivos.guardarAutos");
            return true;
        }catch(Exception e) {
            System.err.println("ERROR AL GUARDAR AUTO!!! " + e.getMessage());
            return false;
        }
    }
    
    public static boolean eliminarAuto(Auto auto){
        try{
            DoublyCircularList<Auto> autos = Archivos.leerAutos();            
            for(DoublyCircularNode<Auto> n = autos.getLast().getNext(); n != autos.getLast(); n = n.getNext()){
                if(n.getContent().getPlaca().equals(auto.getPlaca())){
                    autos.removeNode(n);                
            }
            }
            if(autos.getLast().getContent().getPlaca().equals(auto.getPlaca())){
                autos.removeNode(autos.getLast());
            }            
            // autos.addLast(auto);
            System.out.println("antes de ir a Archivos.guardarAutos en Eliminar");
            Archivos.guardarAutos(autos);
            System.out.println("despues de ir a Archivos.guardarAutos en Eliminar");
            return true;
        }catch(Exception e) {
            System.err.println("ERROR AL ELIMINAR AUTO!!! " + e.getMessage());
            return false;
        }
    }
    
    public static boolean eliminarAutoFavorito(Auto auto, Usuario u){
        try{
            DoublyCircularList<Auto> autos = Archivos.leerAutos();
            DoublyCircularList<Auto> fav = u.getFavoritos();            
            
            for(DoublyCircularNode<Auto> m = fav.getLast().getNext(); ; m = m.getNext()){
                if(m.getContent().getPlaca().equals(auto.getPlaca())){
                    fav.removeNode(m);                
                }
                if(m==fav.getLast()){
                    break;
                }
            }
                                 
            // autos.addLast(auto);
            System.out.println("antes de ir a Archivos.guardarAutos en Eliminar");
            u.setFavorito(fav);
            System.out.println("despues de ir a Archivos.guardarAutos en Eliminar");
            return true;
        }catch(Exception e) {
            System.err.println("ERROR AL ELIMINAR AUTO!!! " + e.getMessage());
            return false;
        }
    }
    
    public static boolean actualizarUsuario(Usuario user){
        try{
            Map<String, Usuario> Usuarios = Archivos.leerUsuarios();           
            Usuarios.remove(user.getCorreo());
            Usuarios.put(user.getCorreo(), user);
            Archivos.guardarUsuarios(Usuarios);
            return true;
        }catch(Exception e) {
            System.err.println("ERROR AL ELIMINAR Usuario!!! " + e.getMessage());
            return false;
        }
    }
}
