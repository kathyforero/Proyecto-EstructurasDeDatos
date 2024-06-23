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
    private Button btnError;
    
    @FXML
    public void iniciarSesion() {
        String correo = tfCorreo.getText();
        String contraseña = pfContraseña.getText();
        if(correo!="" && correo.contains("@")){
            if(!(contraseña.isEmpty())){
                if (!(Sistema.existeUser(correo))) {
                    msgError("Correo no encontrado");
                    tfCorreo.requestFocus();
                } else {
                    if (!Sistema.logearUser(correo, contraseña)) {
                        msgError("Contraseña incorrecta");
                        pfContraseña.requestFocus();
                    } else {
                        System.out.println("Inicio de sesión exitoso para " + correo);
                        mostrarGUI();
                    }
                }
            }else{
                msgError("Ingrese una contraseña :/");
                pfContraseña.requestFocus();
            }    
        }else{
            msgError("Ingrese un correo valido");
            tfCorreo.requestFocus();
        }
    }
    
    public void msgError(String msg){
        btnError.setVisible(true);
        btnError.setText(msg);
    }
    
    @FXML
    public void mostrarRegister() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("GuayacoCar - Crear Usuario");
            stage.show();

            Stage miStage = (Stage) btCrearCuenta.getScene().getWindow();
            miStage.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void mostrarGUI() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("usuario.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("GuayacoCar - Autos a tu Alcance");
            stage.show();

            Stage miStage = (Stage) btCrearCuenta.getScene().getWindow();
            miStage.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
}
