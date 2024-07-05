/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;

import Bases.DoublyCircularList;
import Bases.DoublyCircularNode;
import Clases.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DERS
 */
public class VistaAutoController {

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
    private ImageView btnIzquierda;
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
    @FXML
    private ImageView imgViewCar;
    
    private DoublyCircularNode<File> Node;
    
    private DoublyCircularList<File> fotos;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        lblUsuario.setText(usuario.getNombre()+" "+usuario.getApellido()+"!");
        cargarAuto();
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
    
    public void cargarAuto(){
        lblPlaca.setText(auto.getPlaca().toUpperCase());
        lblPrecio.setText(Float.toString(auto.getPrecio()));
        lblMarca.setText(auto.getMarca().getName());
        lblModelo.setText(auto.getModelo());
        lblTipo.setText(auto.getTipo().getDisplayName());
        lblAño.setText(Integer.toString(auto.getAño()));
        lblKilom.setText(Integer.toString(auto.getKilometraje()));
        lblMotor.setText(auto.getMotor().getDisplayName());
        lblTrans.setText(auto.getTransmisión().getDisplayName());
        lblPeso.setText(Float.toString(auto.getPeso()) + " kg");
        lblUbi.setText(auto.getUbicacion().getDisplayName());
        lblEstado.setText(auto.getEstado().getDisplayName());
        lblVendedor.setText(auto.getUsuario().getNombre()+ " " + auto.getUsuario().getApellido());
        actualizarImagenes();
        adelanteImagen();
        atrasImagen();
    }
    
    public void actualizarImagenes(){
        fotos = auto.getFotos();
        if(fotos.size()>0){
            Node = fotos.getHeader();
            Image image = new Image(Node.getContent().toURI().toString());
            imgViewCar.setImage(image);
            actualizarContador();
        }else{
            String rutaRelativa = "/PROYECTO/preview.png";
            String rutaCompleta = getClass().getResource(rutaRelativa).toExternalForm();
            Image image = new Image(rutaCompleta);
            imgViewCar.setImage(image);
            actualizarContador();
            
        }
    }
    
    public void adelanteImagen(){
        Node = Node.getNext();
        Image image = new Image(Node.getContent().toURI().toString());
        imgViewCar.setImage(image);
        actualizarContador();
    }
    
    public void atrasImagen(){
        Node = Node.getPrevious();
        Image image = new Image(Node.getContent().toURI().toString());
        imgViewCar.setImage(image);
        actualizarContador();
    }
    
    public void actualizarContador(){
        if(fotos.size()>0){
            int index = fotos.getIndex(Node);
            lblContador.setText((index + 1) + "/" + fotos.size());
        }else{
            lblContador.setText("0/0");
        }
    }
    
    @FXML
    public void mostrarReportes() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Lo sentimos");
        alert.setHeaderText("Opción no disponible.");
        alert.setContentText("Esta opción aún está en desarrollo! :(");
        alert.showAndWait();
    }
    
    @FXML
    public void añadirFav() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Lo sentimos");
        alert.setHeaderText("Opción no disponible.");
        alert.setContentText("Esta opción aún está en desarrollo! :(");
        alert.showAndWait();
    }
    
    @FXML
    public void abrirReporte() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vistaReporte.fxml"));
            Parent root = loader.load();
            VistaReporteController vistareportecontroller = loader.getController();
            vistareportecontroller.setUsuario(usuario);
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.setTitle("GuayacoCar - Autos a tu Alcance");
            newStage.show();           
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
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
