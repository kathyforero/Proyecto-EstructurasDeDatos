package PROYECTO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import Bases.*;
import Proyectos.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class EditarautoController {

    @FXML
    private Label lblUser;
    @FXML
    private TextField tfPlaca;
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
    private Button btonGuardar;
    @FXML
    private Button btnError;
    @FXML
    private Button btnSubirImagen;
    @FXML
    private Button btnRegresar;
    @FXML
    private ImageView ivAdelante;
    @FXML
    private ImageView ivAtras;
    @FXML
    private Label lblImagenes;
    @FXML
    private ImageView ivFotoAuto;
    @FXML
    private ImageView ivQuitarImagen;
    private Usuario usuario;
    private Auto auto;
    private DoublyCircularList<File> fotos = new DoublyCircularList<>();
    private DoublyCircularNode<File> Node;
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        lblUser.setText(usuario.getNombre()+" "+usuario.getApellido()+"!");
    }
    
    public void setAuto(Auto auto) {
        this.auto = auto;
        fotos=auto.getFotos();
        Node=fotos.getHeader();
        actualizarImagenes();
    }
    
    
    
    @FXML
    private void cargarModelo(ActionEvent event) {
    }

    @FXML
    private void verificarModelo(MouseEvent event) {
    }

    @FXML
    private void guardarAuto(MouseEvent event) {
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

    @FXML
    public void adelanteImagen(){
        Node = Node.getNext();
        Image image = new Image(Node.getContent().toURI().toString());
        ivFotoAuto.setImage(image);
        actualizarContador();
    }
    
    @FXML
    public void atrasImagen(){
        Node = Node.getPrevious();
        Image image = new Image(Node.getContent().toURI().toString());
        ivFotoAuto.setImage(image);
        actualizarContador();
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
            
                File destDir = new File("src/main/resources/imagenes");
                if (!destDir.exists()) {
                    destDir.mkdirs();
                }

                File destFile = new File(destDir, file.getName());
                try {
                    Files.copy(file.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                fotos.addLast(destFile);
                Image image = new Image(file.toURI().toString());
            }
        }
        
        if(fotos.size()>0){
            actualizarImagenes();
        }
    }
    
    @FXML
    public void eliminarFoto() {
        fotos.removeNode(Node);
        actualizarImagenes();
    }
    
    public void msgError(String msg){
        btnError.setVisible(true);
        btnError.setText(msg);
    }
    public void msgErrorOff(){
        btnError.setVisible(false);
    }
    
    public void actualizarImagenes(){
        if(fotos.size()>0){
            Node = fotos.getHeader();
            Image image = new Image(Node.getContent().toURI().toString());
            ivFotoAuto.setImage(image);
            actualizarContador();
        }else{
            String rutaRelativa = "/PROYECTO/preview.png";
            String rutaCompleta = getClass().getResource(rutaRelativa).toExternalForm();
            Image image = new Image(rutaCompleta);
            ivFotoAuto.setImage(image);
            actualizarContador();
            
        }
    }
    
    public void actualizarContador(){
        if(fotos.size()>0){
            int index = fotos.getIndex(Node);
            lblImagenes.setText((index + 1) + "/" + fotos.size());
        }else{
            lblImagenes.setText("0/0");
        }
    }
    
    
    public void cargarCampos(){
        cargarTipos();
        cargarMarca();
        cargarMotor();
        cargarTransmision();
        cargarUbicacion();
        cargarEstado();
        cargarPlaca();
        cargarPrecio();
        cargarAnio();
        cargarKilometraje();
        cargarPeso();
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
    
    public void cargarPlaca(){
        tfPlaca.setText(auto.getPlaca());
    }
    
    public void cargarPrecio(){
        tfPrecio.setText(""+auto.getPrecio());
    }
    
    public void cargarAnio(){
        tfAnio.setText(""+auto.getAño());
    }
    
    public void cargarKilometraje(){
        tfKM.setText(""+auto.getKilometraje());
    }
    
    public void cargarPeso(){
        tfPeso.setText(""+auto.getPeso());
    }
    
        
}
