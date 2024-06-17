package PROYECTO;

public class Usuario {
    private String correo;
    private String contraseña;
    
    public Usuario(String correo, String contraseña){
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
}
