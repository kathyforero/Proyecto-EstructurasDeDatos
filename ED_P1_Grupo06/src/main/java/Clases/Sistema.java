package Clases;

import Bases.*;
import java.io.File;
import javafx.scene.image.Image;

import java.io.IOException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Sistema implements Serializable{
    private static final long serialVersionUID = 2004140222041502L;
    //Aqui se cambio todos los equals por comparadores naturales.
    
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
        return u.getContraseña().compareTo(contraseña)==0;
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
                if(n.getContent().getPlaca().compareTo(auto.getPlaca())==0){
                    autos.removeNode(n);                
            }
            }
            if(autos.getLast().getContent().getPlaca().compareTo(auto.getPlaca())==0){
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
    
    public static void eliminarAutoFavoritoGlobal(Auto auto){
        try{
            Map<String, Usuario> usuarios = Archivos.leerUsuarios();           
            Set correos = usuarios.keySet();
            Iterator<String> it = correos.iterator();
            while(it.hasNext()){
                Usuario u=usuarios.get(it.next());
                eliminarAutoFavorito(auto,u);
                actualizarUsuario(u);
            }
            
        }catch(Exception e) {
            System.err.println("ERROR AL ELIMINAR FAVORITOS GLOBAL!!! " + e.getMessage());
        }
        
    }
    
    private static void eliminarAutoFavorito(Auto auto, Usuario usuario){
        try{
            DoublyCircularList<Auto> fav = usuario.getFavoritos();            
            if(fav.size()>0){
                DoublyCircularNode<Auto> a=fav.getHeader();
                boolean bandera=true;
                do{
                    Auto au=a.getContent();
                    if(au.getPlaca().compareTo(auto.getPlaca())==0){
                        fav.removeNode(a);
                        bandera=false;
                    }else{
                        a=a.getNext();
                    }
                }while(a!=fav.getHeader() && bandera);
            }
            usuario.setFavorito(fav);
        }catch(Exception e) {
            System.err.println("ERROR AL ELIMINAR AUTO DE FAVORITO!!! " + e.getMessage());
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
    
    public static Comparator<String> comparadorString(){
        Comparator<String> comp = new Comparator<>(){
            @Override
            public int compare(String s1, String s2){
                return s1.compareTo(s2);
            }
        };        
        
        return comp;
    }
}
