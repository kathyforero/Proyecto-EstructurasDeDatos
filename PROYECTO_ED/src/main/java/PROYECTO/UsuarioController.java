package PROYECTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Bases.*;
import Proyectos.*;
import java.util.Map;

public class UsuarioController{


    @FXML
    private TextField tfBusqueda;
    @FXML
    private Button btnCrearAuto;
    @FXML
    private ComboBox<?> cmMarca;
    @FXML
    private ComboBox<?> cmModelo;
    @FXML
    private TextField tfPrecioDesde;
    @FXML
    private TextField tfPrecioHasta;
    @FXML
    private TextField tfKMDesde;
    @FXML
    private TextField tfKMHasta;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnCerrarSesion;
    @FXML
    private ComboBox<?> cbOrdenar;
    @FXML
    private Button btnAplicar;
    @FXML
    private Label lblUser;
    private Usuario usuario;
    private DoublyCircularList<Auto> autos = new DoublyCircularList<>();

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        lblUser.setText(usuario.getNombre()+" "+usuario.getApellido()+"!");
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setAutos(DoublyCircularList<Auto> autos) {
        this.autos = autos;
        
    }

    public DoublyCircularList<Auto> getAutos() {
        return autos;
    }
    
    @FXML
    private void cerrarSesion() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("GuayacoCar - Iniciar Sesión");
            stage.show();

            Stage miStage = (Stage) btnCerrarSesion.getScene().getWindow();
            miStage.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void mostrarCrearAuto() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("crearauto.fxml"));
            Parent root = loader.load();
            CrearautoController CrearAutoController = loader.getController();
            CrearAutoController.setUsuario(usuario);
            CrearAutoController.cargarCampos();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("GuayacoCar - Autos a tu Alcance");
            stage.show();
            
            Stage miStage = (Stage) btnCrearAuto.getScene().getWindow();
            miStage.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void cargarAutos(){
        Map<String, Auto> autos = Archivos.leerAutos();
        
    }
}
