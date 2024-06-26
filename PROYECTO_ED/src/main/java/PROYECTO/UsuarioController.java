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
    private ArrayList<ImageView> imagenes=new ArrayList<>();
    private DoublyCircularList<Auto> autos = Archivos.leerAutos();
    private DoublyCircularNode<Auto> autoNodo;
    private DoublyCircularNode<File> foto;
    

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        lblUser.setText(usuario.getNombre()+" "+usuario.getApellido()+"!");
        //cargarControladores();
        if (autos.size()>0){
            autoNodo=autos.getHeader();
        }
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
        
        if (autos.size()>0){
            mostrarAutosAdelante();
        }else{
            ponerBlanco(1);
        }
    }
    
    public void mostrarAutosAdelante(){
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
                imgView.setOpacity(1);
                imgView.setOnMouseClicked(event -> mostrarAuto(auto));
                
                Field FtituloAuto = getClass().getDeclaredField("tituloAuto" + index);
                FtituloAuto.setAccessible(true);
                Label tituloAuto = (Label) FtituloAuto.get(this); 
                tituloAuto.setText(auto.getMarca().getName()+" - "+auto.getModelo());
                tituloAuto.setOpacity(1);
                
                Field FanioAuto1 = getClass().getDeclaredField("anioAuto" + index);
                FanioAuto1.setAccessible(true);
                Label anioAuto1 = (Label) FanioAuto1.get(this); 
                anioAuto1.setText(Integer.toString(auto.getAño())+" •");
                anioAuto1.setOpacity(1);
                
                Field FkmAutos = getClass().getDeclaredField("kmAutos" + index);
                FkmAutos.setAccessible(true);
                Label kmAutos = (Label) FkmAutos.get(this); 
                kmAutos.setText(Integer.toString(auto.getKilometraje())+" km");
                kmAutos.setOpacity(1);
                
                Field FprovAuto = getClass().getDeclaredField("provAuto" + index);
                FprovAuto.setAccessible(true);
                Label provAuto = (Label) FprovAuto.get(this); 
                provAuto.setText(auto.getUbicacion().getDisplayName());
                provAuto.setOpacity(1);
                
                Field FprecioAuto1 = getClass().getDeclaredField("precioAuto" + index);
                FprecioAuto1.setAccessible(true);
                Label precioAuto1 = (Label) FprecioAuto1.get(this); 
                precioAuto1.setText("$"+auto.getPrecio());
                precioAuto1.setOpacity(1);
                
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
                index++; 
                autosMostrados++; 
                autoNodo = autoNodo.getNext();
                
            } while (autoNodo != autos.getHeader() && index<=6);
            if(autoNodo.equals(autos.getHeader())){
                    ponerBlanco(index);
                   
                }
    }
    
    public void mostrarAutosAtras() {
    int autosMostrados = 0;
    int currentIndex = autos.getIndex(autoNodo);  // Obtener el índice actual del nodo

    // Retroceder la página
    currentIndex -= 6;
    if (currentIndex < 0) {
        currentIndex += autos.size();  // Asegurar que el índice sea válido en la lista circular
    }

    autoNodo = autos.getNodo(currentIndex);  // Obtener el nodo desde el nuevo índice

    // Mostrar autos retrocediendo
    do {
        Auto auto = autoNodo.getContent();
        int index = (autosMostrados % 6) + 1;  // Asegurar que el índice sea entre 1 y 6

        try {
            // Obtener y configurar ImageView
            Field imgField = getClass().getDeclaredField("imgAuto" + index);
            imgField.setAccessible(true);
            ImageView imgView = (ImageView) imgField.get(this);   
            foto = auto.getFotos().getHeader();
            Image image = new Image(foto.getContent().toURI().toString());
            imgView.setImage(image);
            imgView.setOpacity(1);
            imgView.setOnMouseClicked(event -> mostrarAuto(auto));

            Field FtituloAuto = getClass().getDeclaredField("tituloAuto" + index);
            FtituloAuto.setAccessible(true);
            Label tituloAuto = (Label) FtituloAuto.get(this); 
            tituloAuto.setText(auto.getMarca().getName() + " - " + auto.getModelo());
            tituloAuto.setOpacity(1);

            Field FanioAuto1 = getClass().getDeclaredField("anioAuto" + index);
            FanioAuto1.setAccessible(true);
            Label anioAuto1 = (Label) FanioAuto1.get(this); 
            anioAuto1.setText(Integer.toString(auto.getAño()) + " •");
            anioAuto1.setOpacity(1);

            Field FkmAutos = getClass().getDeclaredField("kmAutos" + index);
            FkmAutos.setAccessible(true);
            Label kmAutos = (Label) FkmAutos.get(this); 
            kmAutos.setText(Integer.toString(auto.getKilometraje()) + " km");
            kmAutos.setOpacity(1);

            Field FprovAuto = getClass().getDeclaredField("provAuto" + index);
            FprovAuto.setAccessible(true);
            Label provAuto = (Label) FprovAuto.get(this); 
            provAuto.setText(auto.getUbicacion().getDisplayName());
            provAuto.setOpacity(1);

            Field FprecioAuto1 = getClass().getDeclaredField("precioAuto" + index);
            FprecioAuto1.setAccessible(true);
            Label precioAuto1 = (Label) FprecioAuto1.get(this); 
            precioAuto1.setText("$" + auto.getPrecio());
            precioAuto1.setOpacity(1);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        autosMostrados++;
        autoNodo = autoNodo.getNext();

    } while (autosMostrados < 6 && autoNodo != autos.getHeader());

    if (autosMostrados < 6) {
        ponerBlanco(autosMostrados + 1);
    }
}

    
    public void ponerBlanco(int index){
        
        while(index<=6) {
            try {
                Field imgField = getClass().getDeclaredField("imgAuto" + index);
                imgField.setAccessible(true);
                ImageView imgView = (ImageView) imgField.get(this);
                imgView.setOpacity(0);
                
                Field FtituloAuto = getClass().getDeclaredField("tituloAuto" + index);
                FtituloAuto.setAccessible(true);
                Label tituloAuto = (Label) FtituloAuto.get(this); 
                tituloAuto.setOpacity(0);
                
                Field FkmAutos = getClass().getDeclaredField("kmAutos" + index);
                FkmAutos.setAccessible(true);
                Label kmAutos = (Label) FkmAutos.get(this); 
                kmAutos.setOpacity(0);
                
                Field FprovAuto = getClass().getDeclaredField("provAuto" + index);
                FprovAuto.setAccessible(true);
                Label provAuto = (Label) FprovAuto.get(this); 
                provAuto.setOpacity(0);
                
                Field FanioAuto1 = getClass().getDeclaredField("anioAuto" + index);
                FanioAuto1.setAccessible(true);
                Label anioAuto1 = (Label) FanioAuto1.get(this); 
                anioAuto1.setOpacity(0);
                
                Field FprecioAuto1 = getClass().getDeclaredField("precioAuto" + index);
                FprecioAuto1.setAccessible(true);
                Label precioAuto1 = (Label) FprecioAuto1.get(this); 
                precioAuto1.setOpacity(0);
                
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
                index++; 
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
