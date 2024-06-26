/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package PROYECTO;

import Proyectos.Auto;
import Proyectos.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DERS
 */
public class VistaautoController {

    @FXML
    private Button btnRegresar;
    @FXML
    private Button btnReporte;
    @FXML
    private Label lblPlaca;
    @FXML
    private Label lblPrecio;
    @FXML
    private Label lblMarca;
    @FXML
    private Label lblModelo;
    @FXML
    private Label lblTipo;
    @FXML
    private Label lblKilom;
    @FXML
    private Label lblMotor;
    @FXML
    private Label lblTrans;
    @FXML
    private Label lblPeso;
    @FXML
    private Label lblUbi;
    @FXML
    private Label lblEstado;
    @FXML
    private Label lblAño;
    @FXML
    private ImageView btnDerecha;
    @FXML
    private ImageView lblIzquierda;
    @FXML
    private ImageView btnFav;
    @FXML
    private Label lblContador;
    @FXML
    private Label lblUsuario;
    @FXML
    private Label lblVendedor;
    
    private Usuario usuario;
    
    private Auto auto;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        lblUsuario.setText(usuario.getNombre()+" "+usuario.getApellido()+"!");
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setAuto(Auto auto) {
        this.auto = auto;       
    }
    
    public Auto getAuto() {
        return auto;
    }
    
    public void regresar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("usuario.fxml"));
            Parent root = loader.load();
            UsuarioController usuarioController = loader.getController();
            usuarioController.setUsuario(usuario);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("GuayacoCar - Autos a tu Alcance");
            stage.show();

            Stage miStage = (Stage) btnRegresar.getScene().getWindow();
            miStage.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
