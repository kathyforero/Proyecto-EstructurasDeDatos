/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
/**
 * FXML Controller class
 *
 * @author Kathy
 */
public class AnadirReporteController{


    @FXML
    private TextField txtDesc;
    @FXML
    private Label lblUser;
    @FXML
    private Button btnAgregar;
    @FXML
    private TableView<?> tvCatDesc;
    @FXML
    private ComboBox<?> cbCategoria;
    @FXML
    private Button btnEliminar;

    @FXML
    private void subirImagen(ActionEvent event) {
    }
    
    

}
