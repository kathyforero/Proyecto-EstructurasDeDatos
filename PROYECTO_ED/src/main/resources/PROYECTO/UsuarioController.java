/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package PROYECTO;

import java.net.URL;
import java.util.ResourceBundle;
iimport javafx.event.ActionEvent;
import javafx.fxml.FXML;
mport javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
/**
 * FXML Controller class
 *
 * @author DERS
 */
public class UsuarioController implements Initializable {


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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void cerrarSesion(ActionEvent event) {
    }

}
