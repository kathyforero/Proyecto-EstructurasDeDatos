package PROYECTO;

import Proyectos.*;
import Bases.*;
import java.io.File;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CrearautoController {
    private Usuario usuario;
    private DoublyCircularList<Image> fotos = new DoublyCircularList<>();
    
    @FXML
    private Label lblUser;
    @FXML
    private Button btnRegresar;
    @FXML
    private TextField tfPrecio;
    @FXML
    private ComboBox<String> cbMarca;
    @FXML
    private ComboBox<String> cbModelo;
    @FXML
    private ComboBox<String> cbTipo;
    @FXML
    private TextField tfAnio;
    @FXML
    private TextField tfKM;
    @FXML
    private ComboBox<String> cbMotor;
    @FXML
    private ComboBox<String> cbTransmision;
    @FXML
    private TextField tfPeso;
    @FXML
    private ComboBox<String> cbUbicacion;
    @FXML
    private ComboBox<String> cbEstado;
    @FXML
    private Button btnError;
    @FXML
    private TextField tfPlaca;
    @FXML
    private Button btnSubirImagen;
    @FXML
    private ImageView ivFotoAuto;
    private DoublyCircularNode<Image> Node;
    @FXML
    private ImageView ivAdelante;
    @FXML
    private ImageView ivAtras;
    @FXML
    private Label lblImagenes;
    
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        lblUser.setText(usuario.getNombre()+" "+usuario.getApellido()+"!");
    }
    
    public Usuario getUsuario() {
        return usuario;
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
   
    public void cargarCampos(){
        cargarTipos();
        cargarMarca();
        cargarMotor();
        cargarTransmision();
        cargarUbicacion();
        cargarEstado();
    }
    
    public void cargarTipos(){
        for (Tipo tipo : Tipo.values()) {
            cbTipo.getItems().add(tipo.getDisplayName());
        }
    }
    
    public void cargarMarca(){
        for (MarcaDeAuto marca : MarcaDeAuto.values()) {
            cbMarca.getItems().add(marca.getName());
        }
    }
    
    @FXML
    public void cargarModelo(){
            msgErrorOff();
            cbModelo.getSelectionModel().clearSelection();
            cbModelo.getItems().clear();
            cbModelo.setValue(null);
            String txtMarca = cbMarca.getValue();
            for(MarcaDeAuto marca:MarcaDeAuto.values()){
                if(marca.getName().equals(txtMarca)){
                    ArrayList<String> modelos = marca.getModels();
                    for (int i=1; i<=modelos.size(); i++){
                        cbModelo.getItems().add(modelos.get(i));
                    }
                }
            
        }
    }
    
    @FXML
    public void verificarModelo(){
        if(cbMarca.getValue()==null){
            msgError("Primero tienes que escoger una marca");
        }
    }
    
    public void cargarMotor(){
        for (Motor motor : Motor.values()) {
            cbMotor.getItems().add(motor.getDisplayName());
        }
    }
    
    public void cargarTransmision(){
        for (Transmision transmision : Transmision.values()) {
            cbTransmision.getItems().add(transmision.getDisplayName());
        }
    }
    
    public void cargarUbicacion(){
        for (Ubicacion ubicacion : Ubicacion.values()) {
            cbUbicacion.getItems().add(ubicacion.getDisplayName());
        }
    }
    
    public void cargarEstado(){
        for (Estado estado : Estado.values()) {
            cbEstado.getItems().add(estado.getDisplayName());
        }
    }
    
    public void msgError(String msg){
        btnError.setVisible(true);
        btnError.setText(msg);
    }
    public void msgErrorOff(){
        btnError.setVisible(false);
    }

    @FXML
    private void subirImagen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar fotos");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.gif","*.jpeg")
        );
        java.util.List<File> selectedFiles = fileChooser.showOpenMultipleDialog(btnSubirImagen.getScene().getWindow());

        if (selectedFiles != null) {
            for (File file : selectedFiles) {
                System.out.println("Archivo seleccionado: " + file.getAbsolutePath());
                Image image = new Image(file.toURI().toString());
                fotos.addLast(image);
            }
        }
        
        if(fotos.size()>0){
            actualizarImagenes();
        }
    }
    
    public void actualizarImagenes(){
        Node = fotos.getHeader();
        ivFotoAuto.setImage(Node.getContent());
    }
    
    @FXML
    public void adelanteImagen(){
        Node = Node.getNext();
        ivFotoAuto.setImage(Node.getContent());
    }
    
    @FXML
    public void atrasImagen(){
        Node = Node.getPrevious();
        ivFotoAuto.setImage(Node.getContent());
    }
    
    public void actualizarContador(int i){
        if(i==0){
            lblImagenes.setText(1+"/"+fotos.size());
        }else if(i==1){}
        
    }
}
