/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROYECTO;

/**
 *
 * @author Kathy
 */
public class Usuario {
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    
    public Usuario(String nombre, String apellido, String correo, String contraseña){        
        this.nombre = nombre;
        this.apellido = apellido;        
        this.correo = correo;
        this.contraseña = contraseña;
    }
    
    public boolean validarUsuario(String correo, String contraseña){
        if(correo.equals(this.correo) && contraseña.equals(this.contraseña)){
            return true;
        }else{
            return false;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
