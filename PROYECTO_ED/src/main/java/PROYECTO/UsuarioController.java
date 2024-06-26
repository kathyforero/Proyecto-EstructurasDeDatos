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
import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    @FXML
    private MenuItem menuMisAutos;
    @FXML
    private MenuBar menuBar;
    @FXML        
    private ImageView imgAuto1;
    @FXML
    private Label tituloAuto1;
    @FXML
    private Label anioAuto1;
    @FXML
    private Label anioAuto11;
    @FXML
    private Label kmAutos1;
    @FXML
    private Label precioAuto1;
    @FXML
    private ImageView imgAuto2;
    @FXML
    private Label tituloAuto2;
    @FXML
    private Label precioAuto2;
    @FXML
    private Label precioAuto3;
    @FXML
    private ImageView imgAuto3;
    @FXML
    private Label provAuto1;
    @FXML
    private Label tituloAuto3;
    @FXML
    private Label anioAuto2;
    @FXML
    private Label anioAuto111;
    @FXML
    private Label kmAutos2;
    @FXML
    private Label anioAuto3;
    @FXML
    private Label anioAuto112;
    @FXML
    private Label kmAutos3;
    @FXML
    private Label provAuto2;
    @FXML
    private Label provAuto3;
    private ArrayList<ImageView> imagenes=new ArrayList<>();
    private DoublyCircularNode<File> Node;
    @FXML
    private ImageView imgAuto4;
    @FXML
    private Label tituloAuto4;
    @FXML
    private Label anioAuto4;
    @FXML
    private Label kmAutos4;
    @FXML
    private Label precioAuto4;
    @FXML
    private ImageView imgAuto5;
    @FXML
    private Label tituloAuto5;
    @FXML
    private Label precioAuto5;
    @FXML
    private Label precioAuto6;
    @FXML
    private ImageView imgAuto6;
    @FXML
    private Label provAuto4;
    @FXML
    private Label tituloAuto6;
    @FXML
    private Label anioAuto5;
    @FXML
    private Label anioAuto1111;
    @FXML
    private Label kmAutos5;
    @FXML
    private Label anioAuto6;
    @FXML
    private Label anioAuto1121;
    @FXML
    private Label kmAutos6;
    @FXML
    private Label provAuto5;
    @FXML
    private Label provAuto6;
    @FXML
    private ImageView buscar;
    @FXML
    private MenuItem menuFav;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        lblUser.setText(usuario.getNombre()+" "+usuario.getApellido()+"!");
        //cargarControladores();
        cargarAutos();
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
    public void mostrarMisAutos() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("misautos.fxml"));
            Parent root = loader.load();
            MisautosController MisautosController = loader.getController();
            MisautosController.setUsuario(usuario);            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("GuayacoCar - Autos a tu Alcance");
            stage.show();
            
            Stage miStage = (Stage) menuBar.getScene().getWindow();
            miStage.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    public void cargarControladores(){
        imagenes.addLast(imgAuto1);
        imagenes.addLast(imgAuto2);
        imagenes.addLast(imgAuto3);
    }
    
    
<<<<<<< Updated upstream
    
=======
    public void controladoresAnios(){
        anios.addLast(anioAuto1);
        anios.addLast(anioAuto2);
        anios.addLast(anioAuto3);
        anios.addLast(anioAuto4);
        anios.addLast(anioAuto5);
        anios.addLast(anioAuto6);
    }
    
    public void controladoresKM(){
        KMS.addLast(kmAutos1);
        KMS.addLast(kmAutos2);
        KMS.addLast(kmAutos3);
        KMS.addLast(kmAutos4);
        KMS.addLast(kmAutos5);
        KMS.addLast(kmAutos6);
    }
    
    public void controladoresProvincia(){
        KMS.addLast(provAuto1);
        KMS.addLast(provAuto1);
        KMS.addLast(provAuto1);
        KMS.addLast(provAuto1);
        KMS.addLast(provAuto1);
        KMS.addLast(provAuto1);
    }
    */
    public void cargarAutos(){
        DoublyCircularList<Auto> autos = Archivos.leerAutos();
        if (!(autos.size()==0)){
            DoublyCircularNode<Auto> autoNodo=autos.getHeader();
            DoublyCircularNode<File> foto;
            int index = 1;
            int autosMostrados=0;
            do {
                Auto auto = autoNodo.getContent();
                 try {
                // Obtener y configurar ImageView
                Field imgField = getClass().getDeclaredField("imgAuto" + index);
                imgField.setAccessible(true);
                ImageView imgView = (ImageView) imgField.get(this);
                
                foto = auto.getFotos().getHeader();
                Image image = new Image(foto.getContent().toURI().toString());
                imgView.setImage(image);

                // Añadir evento de clic
                imgView.setOnMouseClicked(event -> mostrarAuto(auto));

                

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }

                index++; 
                autosMostrados++; 
                autoNodo = autoNodo.getNext();
            } while (autoNodo != autos.getHeader());
        }
    }
    
    public void mostrarAuto(Auto auto){
        try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("vistaauto.fxml"));
                Parent root = loader.load();
                VistaautoController VistaautoController = loader.getController();
                VistaautoController.setAuto(auto);
                VistaautoController.setUsuario(usuario);                
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("GuayacoCar - Autos a tu Alcance");
                stage.show();

                Stage miStage = (Stage) menuBar.getScene().getWindow();
                miStage.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    
    @FXML
    public void mostrarMisFavoritos() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Lo sentimos");
        alert.setHeaderText("Opción no disponible.");
        alert.setContentText("Esta opción aún está en desarrollo! :(");
        alert.showAndWait();
    }
    
    @FXML
    public void buscar() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Lo sentimos");
        alert.setHeaderText("Opción no disponible.");
        alert.setContentText("Esta opción aún está en desarrollo! :(");
        alert.showAndWait();
    }
}
