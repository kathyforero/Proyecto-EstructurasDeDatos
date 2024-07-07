/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;

import Clases.Auto;
import Clases.Reporte;
import Clases.Usuario;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
/**
 * FXML Controller class
 *
 * @author Kathy
 */
public class VistaReporteController{


    @FXML
    private Label lblUser;
    @FXML
    private TableView<Reporte> tvCatDesc;
    
    private Usuario usuario;
    
    private Auto auto;    
    @FXML
    private TableColumn<Reporte, String> tcCat;
    @FXML
    private TableColumn<Reporte, String> tcDesc;
          
    private ObservableList<Reporte> reportes = FXCollections.observableArrayList();
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        lblUser.setText(usuario.getNombre()+" "+usuario.getApellido()+"!");      
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }
    
    public void cargarTabla(){
        tcCat.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        tcDesc.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        
        if(auto.getReportes()!=null){            
            Iterator<Reporte> it = auto.getReportes().iterator();
            while(it.hasNext()){
                reportes.add(it.next());
            }            
        } else {
            tvCatDesc.getItems().add(new Reporte("No hay datos para mostrar.", "No hay datos para mostrar."));
        }
                
        if(tvCatDesc!=null){
            tvCatDesc.setItems(reportes);
        }
    }    
}
