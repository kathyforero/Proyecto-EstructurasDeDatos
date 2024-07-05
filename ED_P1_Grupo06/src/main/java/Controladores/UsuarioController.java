package Controladores;

import Clases.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.Collation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Bases.*;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class UsuarioController implements Initializable{


    @FXML
    private TextField tfBusqueda;
    @FXML
    private Button btnCrearAuto;
    @FXML
    private ComboBox<String> cmMarca;
    @FXML
    private ComboBox<String> cmModelo;
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
    private ComboBox<String> cbOrdenar;
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
    private Label kmAutos2;
    @FXML
    private Label anioAuto3;
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
    private Label kmAutos5;
    @FXML
    private Label anioAuto6;
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
    private int autosMostrados;
    @FXML
    private Button btnError;
    @FXML
    private ImageView mostrarAutosAdelante;
    @FXML
    private ImageView borrarFiltro;
    @FXML
    private ImageView filtroAvanzado;
    @FXML
    private ComboBox<String> cbTipo;

    

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
            CrearAutoController CrearAutoController = loader.getController();
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
            MisAutosController MisautosController = loader.getController();
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
    
    @FXML
    public void mostrarFavoritos() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("favoritos.fxml"));
            Parent root = loader.load();
            FavoritosController favoritosController = loader.getController();
            favoritosController.setUsuario(usuario);            
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
            msgErrorOff();
        }else{
            ponerBlanco(1);
            msgError("No hay autos que mostrar");
        }
    }
    
    @FXML
    public void mostrarAutosAdelante(){
        
            int index = 1;
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
                if(autoNodo.equals(autos.getHeader())){
                    autosMostrados=1;
                    }
                
            } while (autoNodo != autos.getHeader() && index<=6);
            if(autoNodo.equals(autos.getHeader())){
                    ponerBlanco(index);
                   
                }
            
    }
    
    @FXML
    public void mostrarAutosAtras() {
        
            int indicePRB=0;
            if (autos.getIndex(autoNodo)==6 && (autos.size()%6)!=0) {
                int indice=autos.size()-(autos.size()%6);
                autoNodo=autos.getNodo(indice);  // Asegurar que el índice sea válido en la lista circular
            } else if(autoNodo.equals(autos.getHeader())){
                if(autos.size()%6==0){
                    indicePRB=6+6;
                }else{
                    indicePRB=6+(autos.size()%6);
                    }
                } else{
                    indicePRB=12;
                    System.out.println(autos.getIndex(autoNodo));
                }
                    for(int i =1;i<=indicePRB;i++){
                       autoNodo=autoNodo.getPrevious();
                }
            mostrarAutosAdelante();
        
}
    
    
    
    public void msgError(String msg){
        btnError.setVisible(true);
        btnError.setText(msg);
    }
    public void msgErrorOff(){
        btnError.setVisible(false);
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
                VistaAutoController VistaautoController = loader.getController();
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
    public void buscar() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Lo sentimos");
        alert.setHeaderText("Opción no disponible.");
        alert.setContentText("Esta opción aún está en desarrollo! :(");
        alert.showAndWait();
    }


    @FXML
    public void VerificarModelo(){
        if(cmMarca.getValue()==null){
            msgError("Primero tienes que escoger una marca.");
        }
    }

    @FXML
    public void cargarModelo(){
            msgErrorOff();
            cmModelo.getSelectionModel().clearSelection();
            cmModelo.getItems().clear();
            cmModelo.setValue(null);
            String txtMarca = cmMarca.getValue();
            for(MarcaDeAuto marca:MarcaDeAuto.values()){
                if(marca.getName().equals(txtMarca)){
                    ArrayList<String> modelos = marca.getModels();
                    for (int i=1; i<=modelos.size(); i++){
                        cmModelo.getItems().add(modelos.get(i));
                    }
                }
            
        }
    }
    public void cargarMarca(){
        for (MarcaDeAuto marca : MarcaDeAuto.values()) {
            cmMarca.getItems().add(marca.getName());
        }
    }
    
    public void cargarTipo(){
        for (Tipo tipo : Tipo.values()) {
            cbTipo.getItems().add(tipo.getDisplayName());
        }
    }

    public void ordenarAutoPorMarca() {
        Comparator<Auto> marcaComparator = new Comparator<Auto>() {
            @Override
            public int compare(Auto auto1, Auto auto2) {
                String marca1 = auto1.getMarca().getName();
                String marca2 = auto2.getMarca().getName();
                if(marca1.compareTo(marca2)!=0 ){
                return marca1.compareTo(marca2);
                }else{
                    String modelo1 = auto1.getModelo();
                    String modelo2 = auto2.getModelo();
                    System.out.println(modelo1+"    "+modelo2);
                    return  modelo1.compareTo(modelo2);
                }
            }
        };

        Platform.runLater(() -> {

            ordenar(autos, marcaComparator);

            Iterator<Auto> it = autos.iterator();
            while (it.hasNext()) {
                Auto auto = it.next();
                System.out.println("Marca: " + auto.getMarca().getName());
                System.out.println("Modelo: " + auto.getModelo());
                System.out.println("Año: " + auto.getAño());
                System.out.println("Kilometraje: " + auto.getKilometraje() + " km");
                System.out.println("Precio: $" + auto.getPrecio());
                System.out.println("Ubicación: " + auto.getUbicacion().getDisplayName());
                System.out.println("-----------------------");
            }

            
        });

    }
    public Comparator<Auto> ordenarPorComp() {
        String criterio = cbOrdenar.getValue();
        if (criterio.equals("Marca y Modelo")) {
            return new Comparator<Auto>() {
                @Override
                public int compare(Auto auto1, Auto auto2) {
                    String marca1 = auto1.getMarca().getName();
                    String marca2 = auto2.getMarca().getName();
                    if (!marca1.equals(marca2)) {
                        return marca1.compareTo(marca2);
                    } else {
                        return auto1.getModelo().compareTo(auto2.getModelo());
                    }
                }
            };
        } else if (criterio.equals("Precio")) {
            return Comparator.comparingDouble(Auto::getPrecio);
        } else if (criterio.equals("Año del Auto")) {
            return Comparator.comparingInt(Auto::getAño).reversed(); // Ordenar por año en orden descendente
        } else if (criterio.equals("Kilometraje")) {
            return new Comparator<Auto>() {
                @Override
                public int compare(Auto auto1, Auto auto2) {
                    int km1 = auto1.getKilometraje();
                    int km2 = auto2.getKilometraje();
                    if (km1==km2) {
                        double p1=auto1.getPrecio();
                        double p2=auto2.getPrecio();
                        return Double.compare(p1, p2);
                    } else {
                        return Integer.compare(km1,km2);
                    }
                }
            };
        }
        return null;
    }
    

    @FXML
public void ordenarAutoPorXCriterio() {
    Platform.runLater(()->{
        Comparator<Auto> comp = ordenarPorComp();
        if (comp != null) {
            ordenar(autos, comp);
            
            Iterator<Auto> it = autos.iterator();
            while (it.hasNext()) {
                Auto auto = it.next();
                System.out.println("Marca: " + auto.getMarca().getName());
                System.out.println("Modelo: " + auto.getModelo());
                System.out.println("Año: " + auto.getAño());
                System.out.println("Kilometraje: " + auto.getKilometraje() + " km");
                System.out.println("Precio: $" + auto.getPrecio());
                System.out.println("Ubicación: " + auto.getUbicacion().getDisplayName());
                System.out.println("-----------------------");
            }
            autoNodo=autos.getHeader();
            cargarAutos(); 
        } else {
            System.out.println("No se seleccionó un criterio de ordenación válido.");
        }
    });

}


    private void ordenar(DoublyCircularList<Auto> lista, Comparator<Auto> comp) {
        if (lista.getLast() == null || lista.getLast().getNext() == lista.getLast()) {
            // Si la lista está vacía o tiene un solo elemento, no se hace nada
            return;
        }
    
        boolean swapped;
        do {
            swapped = false;
            DoublyCircularNode<Auto> current = lista.getLast().getNext();
            do {
                DoublyCircularNode<Auto> nextNode = current.getNext();
                if (comp.compare(current.getContent(), nextNode.getContent()) > 0) {
                    // Intercambiar contenidos de los nodos en lugar de los nodos mismos
                    Auto tempContent = current.getContent();
                    current.setContent(nextNode.getContent());
                    nextNode.setContent(tempContent);
                    swapped = true;
                }
                current = nextNode;
            } while (current != lista.getLast());
        } while (swapped);
    }
    


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbOrdenar.setValue("Precio");
        ordenarAutoPorXCriterio();
        cargarMarca(); // Llama a cargarCampos al inicializar el 
        cargarTipo();
        cbOrdenar.getItems().addAll("Marca y Modelo", "Año del Auto", "Precio", "Kilometraje");
    }

    @FXML
    private void filtroAvanzado() {
        DoublyCircularList<Auto> filtrados=new DoublyCircularList<>();
        Iterator<Auto> it = Archivos.leerAutos().iterator();
            while (it.hasNext()) {
                Auto auto = it.next();
                if(filtrado(auto)){
                    filtrados.addLast(auto);
                }
            }
        setAutos(filtrados);
        if(autos.size()!=0){
            autoNodo=autos.getHeader();
        }else{
            System.out.println("No hay resultados para el filtro avanzado");
        }
        String filtro=cbOrdenar.getValue();
        ordenarAutoPorXCriterio();
        cargarAutos(); 
    }
    
    public boolean filtrado(Auto auto){
        boolean bandera = true;
        bandera = bandera&&marcaFiltro(auto);
        System.out.println("Bandera marca: "+bandera);
        bandera = bandera&&modeloFiltro(auto);
        System.out.println("Bandera modelo: "+bandera);
        bandera = bandera&&precioDesdeFiltro(auto);
        System.out.println("Bandera precio Desde: "+bandera);
        bandera = bandera&&precioHastaFiltro(auto);
        System.out.println("Bandera precio Hasta: "+bandera);
        bandera = bandera&&KMDesdeFiltro(auto);
        System.out.println("Bandera KM DESDE: "+bandera);
        bandera = bandera&&KMHastaFiltro(auto);
        System.out.println("Bandera KM Hasta: "+bandera);
        return bandera;
    }
    
    
         
    public boolean marcaFiltro(Auto auto){
        boolean bandera=true;
        if(cmMarca.getValue()!=null){
            bandera=cmMarca.getValue().equals(auto.getMarca().getName());
            cbOrdenar.setValue("Marca y Modelo");
        }
        
        return bandera;
        
    }
    
    public boolean modeloFiltro(Auto auto){
        boolean bandera=true;
        if(cmModelo.getValue()!=null){
            bandera=cmModelo.getValue().equals(auto.getModelo());
            cbOrdenar.setValue("Marca y Modelo");
        }
        
        return bandera;
    }
    
    public boolean precioDesdeFiltro(Auto auto){
        boolean bandera=true;
        String precioDesde = tfPrecioDesde.getText();
        if(!precioDesde.isEmpty()){
            System.out.println("PRECIO DESDE");
            System.out.println(Float.parseFloat(precioDesde)<auto.getPrecio());
            bandera = Float.parseFloat(precioDesde)<auto.getPrecio();
            cbOrdenar.setValue("Precio");
        }
        
        return bandera;
    }
    
    public boolean precioHastaFiltro(Auto auto){
        boolean bandera=true;
        String precioHasta = tfPrecioHasta.getText();
        if(!precioHasta.isEmpty()){
            bandera=Float.parseFloat(precioHasta)>auto.getPrecio();
            cbOrdenar.setValue("Precio");
        }
        
        return bandera;
    }
    
    public boolean KMDesdeFiltro(Auto auto){
        boolean bandera=true;
        String KMDesde = tfKMDesde.getText();
        if(!KMDesde.isEmpty()){
            bandera=Integer.parseInt(KMDesde)<auto.getKilometraje();
            cbOrdenar.setValue("Kilometraje");
        }
        
        return bandera;
    }
    
    public boolean KMHastaFiltro(Auto auto){
        boolean bandera=true;
        String KMHasta = tfKMHasta.getText();
        if(!KMHasta.isEmpty()){
            bandera=Integer.parseInt(KMHasta)>auto.getKilometraje();
            cbOrdenar.setValue("Kilometraje");
        }
        
        return bandera;
    }
    
    public void limpiarCampos(){
        
        cmMarca.setValue(null);
        
        
        cmModelo.setValue(null);
        
        
        cbTipo.setValue(null);
        
        tfPrecioDesde.setText("");
        tfPrecioHasta.setText("");
        tfKMDesde.setText("");
        tfKMHasta.setText("");
        cbOrdenar.setValue("Precio");
        setAutos(Archivos.leerAutos());
        ordenarAutoPorXCriterio();
        


    }
}
