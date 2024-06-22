package PROYECTO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import Bases.*;
import Proyectos.*;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController {
    
    @FXML
    private Button btnIniciarSesion;

    @FXML
    private TextField tfContraseña;

    @FXML
    private TextField tfCorreo;

    @FXML
    private Text txtCrearCuenta;
    
    @FXML
    public void crearUsuario() {
        String correo = tfCorreo.getText();
        String contraseña = tfContraseña.getStyle();
        Usuario u = Sistema.crearUsuario("David", "Ramirez", correo, contraseña);
        System.out.println(Sistema.guardarUsuario(u));
        Archivos.leerUsuarios();
    }
}
