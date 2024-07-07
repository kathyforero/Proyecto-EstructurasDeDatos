/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;

import Clases.Auto;
import Clases.Reporte;
import Clases.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<Reporte> tvCatDesc;
    @FXML
    private ComboBox<String> cbCategoria;
    @FXML
    private Button btnEliminar;
    
    private Usuario usuario;
    
    private Auto auto;
    @FXML
    private TableColumn<Reporte, String> tcCat;
    @FXML
    private TableColumn<Reporte, String> tcDesc;
          
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        lblUser.setText(usuario.getNombre()+" "+usuario.getApellido()+"!");      
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }    
           
    @FXML
    private void alertaInfo(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText("¿Cómo eliminar un reporte?");
        alert.setContentText("Presiona un reporte de la tabla y presiona el botón eliminar que aparecerá a continuación!");
        alert.showAndWait();    
    }
    
    public void cargarCategorias(){
        cbCategoria.getItems().addAll("Mantenimiento", "Accidente", "Reparación");
    }
    
    public void cargarTabla(){
        tcCat.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        tcDesc.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        
        if(auto!=null){
            
        }
    }

}
