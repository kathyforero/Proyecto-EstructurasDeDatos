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
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
    private TableView<String> tvCatDesc;
    @FXML
    private ComboBox<String> cbCategoria;
    @FXML
    private Button btnEliminar;   
    
    @FXML
    private void alertaInfo(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText("¿Cómo eliminar un reporte?");
        alert.setContentText("Presiona un reporte de la tabla y presiona el botón eliminar que aparecerá a continuación!");
        alert.showAndWait();    
    }
    
    
    

}
