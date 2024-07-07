/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;

import Bases.ArrayList;
import Clases.Auto;
import Clases.Reporte;
import Clases.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
    
    private ObservableList<Reporte> reportes = FXCollections.observableArrayList();
    @FXML
    private Button btnError;
    
    private ArrayList<Reporte> reportesArr = new ArrayList<>();
    
    private String procedencia;
    
    private CrearAutoController crearAutoController;
    
    private EditarAutoController editarAutoController;
    
    public void setCrearAutoController(CrearAutoController controller) {
        this.crearAutoController = controller;
    }    
    
    public void setEditarAutoController(EditarAutoController controller) {
        this.editarAutoController = controller;
    }     
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        lblUser.setText(usuario.getNombre()+" "+usuario.getApellido()+"!");      
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public void setReportesArr(ArrayList<Reporte> reportesArr) {
        this.reportesArr = reportesArr;
    }   
    
    public void setProcedencia(String p) {
        this.procedencia = p;
    }    
           
    @FXML
    private void alertaInfo(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText("¿Cómo eliminar un reporte?");
        alert.setContentText("Presiona un reporte de la tabla y presiona el botón eliminar que aparecerá a continuación!");
        alert.showAndWait();    
    }
    
    public void cargarTodo(){
        cargarCategorias();
        cargarTabla();
    }
    
    public void cargarCategorias(){
        cbCategoria.getItems().addAll("Mantenimiento", "Accidente", "Reparación");
    }
    
    public void cargarTabla(){
        tcCat.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        tcDesc.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        if(auto!=null){
            if(auto.getReportes()!=null){            
                Iterator<Reporte> it = auto.getReportes().iterator();
                while(it.hasNext()){
                    reportes.add(it.next());
                }            
            }
        }
        if(reportesArr!=null){
            Iterator<Reporte> it = reportesArr.iterator();
            while(it.hasNext()){
                reportes.add(it.next());
            }
        }
        if(tvCatDesc!=null){
            tvCatDesc.setItems(reportes);
        }
    }
    
    public void msgError(String msg){
        btnError.setVisible(true);
        btnError.setText(msg);
    }
    public void msgErrorOff(){
        btnError.setVisible(false);
    }
    
    public boolean verificarCampos(){
        if(cbCategoria.getValue()==null){
            msgError("Seleccione una categoria!");
            return false;
        } else if(txtDesc.getText()==null || txtDesc.getText().trim().isEmpty()){
            msgError("Escriba una descripción!");
            return false;
        }
        msgErrorOff();
        return true;        
    }    
    
    
    public void agregarReporte() throws IOException{
        if(verificarCampos()==true){
            Reporte r = new Reporte(cbCategoria.getValue(), txtDesc.getText());
            reportesArr.addLast(r);
            reportes.add(r);
            tvCatDesc.setItems(reportes);
            if(procedencia.equals("c")){
                /*FXMLLoader loader = new FXMLLoader(getClass().getResource("crearauto.fxml"));
                Parent root = loader.load();
                CrearAutoController crearautocontroller = loader.getController();*/
                crearAutoController.setReportes(reportesArr);
                System.out.println(reportesArr.toString());
            } else if(procedencia.equals("e")){
                /*FXMLLoader loader = new FXMLLoader(getClass().getResource("editarauto.fxml"));
                Parent root = loader.load();
                EditarAutoController editarautocontroller = loader.getController();*/
                editarAutoController.setReportes(reportesArr);
                System.out.println(reportesArr.toString());
            }
        }
    }   
    

}
