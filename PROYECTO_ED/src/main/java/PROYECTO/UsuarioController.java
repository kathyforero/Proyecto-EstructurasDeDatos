package PROYECTO;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class UsuarioController{


    @FXML
    private TextField tfBusqueda;
    @FXML
    private Button btnCrearAuto;
    @FXML
    private Text txtUsuario;
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
    private void cerrarSesion(ActionEvent event) {
        
    }

}
