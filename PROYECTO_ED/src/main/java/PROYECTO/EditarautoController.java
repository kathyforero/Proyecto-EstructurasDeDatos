package PROYECTO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import Bases.*;
import Proyectos.*;
import java.io.IOException;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EditarautoController {

    @FXML
    private Label lblUser;
    @FXML
    private TextField tfPlaca;
    @FXML
    private TextField tfPrecio;
    @FXML
    private ComboBox<?> cbMarca;
    @FXML
    private ComboBox<?> cbModelo;
    @FXML
    private ComboBox<?> cbTipo;
    @FXML
    private TextField tfAnio;
    @FXML
    private TextField tfKM;
    @FXML
    private ComboBox<?> cbMotor;
    @FXML
    private ComboBox<?> cbTransmision;
    @FXML
    private TextField tfPeso;
    @FXML
    private ComboBox<?> cbUbicacion;
    @FXML
    private ComboBox<?> cbEstado;
    @FXML
    private Button btonGuardar;
    @FXML
    private Button btnError;
    @FXML
    private Button btnSubirImagen;
    @FXML
    private Button btnRegresar;
    @FXML
    private ImageView ivAdelante;
    @FXML
    private ImageView ivAtras;
    @FXML
    private Label lblImagenes;
    @FXML
    private ImageView ivFotoAuto;
    @FXML
    private ImageView ivQuitarImagen;

    @FXML
    private void cargarModelo(ActionEvent event) {
    }

    @FXML
    private void verificarModelo(MouseEvent event) {
    }

    @FXML
    private void guardarAuto(MouseEvent event) {
    }

    @FXML
    private void subirImagen(ActionEvent event) {
    }

    @FXML
    private void regresar(ActionEvent event) {
    }

    @FXML
    private void adelanteImagen(MouseEvent event) {
    }

    @FXML
    private void atrasImagen(MouseEvent event) {
    }

    @FXML
    private void eliminarFoto(MouseEvent event) {
    }
    
    
        
}
