package PROYECTO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import Bases.*;
import Proyectos.*;
import java.io.IOException;
import java.util.Map;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {
    
    @FXML
    private Button btnIniciarSesion;

    @FXML
   private PasswordField pfContraseña;

    @FXML
    private TextField tfCorreo;

    @FXML
    private Button btCrearCuenta;
    
    @FXML
    public void iniciarSesion() {
        String correo = tfCorreo.getText();
        String contraseña = pfContraseña.getText();
        Map<String, Usuario> Usuarios = Archivos.leerUsuarios();
        
        if (!Usuarios.containsKey(correo)) {
            System.out.println("Correo no encontrado");
        } else {
            Usuario u = Usuarios.get(correo);
            if (!u.getContraseña().equals(contraseña)) {
                System.out.println("Contraseña incorrecta");
            } else {
                System.out.println("Inicio de sesión exitoso para " + correo);
                // Aquí puedes continuar con la lógica después de iniciar sesión correctamente
            }
        }
    }
    
    @FXML
    public void mostrarRegister() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            Stage miStage = (Stage) btCrearCuenta.getScene().getWindow();
            miStage.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
        
}
