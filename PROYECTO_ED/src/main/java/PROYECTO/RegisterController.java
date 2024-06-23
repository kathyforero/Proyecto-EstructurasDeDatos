package PROYECTO;

import Proyectos.Archivos;
import Proyectos.Sistema;
import Proyectos.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {


    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfApellido;
    @FXML
    private TextField tfCorreo;
    @FXML
    private Button logeo;
    @FXML
    private PasswordField pfContraseña;
    @FXML
    private PasswordField pfConfirmarcontraseña;
    @FXML
    private Button btIniciarSesion;
    /**
     * Initializes the controller class.
     */
  
    public void crearUsuario() {
    String correo = tfCorreo.getText();
    String contraseña = pfContraseña.getText();
    String nombre = tfNombre.getText();
    String apellido = tfApellido.getText();
    Usuario u = Sistema.crearUsuario(nombre, apellido, correo, contraseña);
    if (Sistema.guardarUsuario(u)){
        
    }
    
    
    }

    @FXML
    public void mostrarLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("GuayacoCar - Iniciar Sesión");
            stage.show();
            Stage miStage = (Stage) btIniciarSesion.getScene().getWindow(); 
            miStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void alertaLogin(){
        
    }

}
