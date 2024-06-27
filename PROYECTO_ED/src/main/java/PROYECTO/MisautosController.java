/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package PROYECTO;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import Bases.DoublyCircularList;
import Proyectos.*;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DERS
 */
public class MisautosController {
    
    @FXML
    private Button btnRegresar;
    
    @FXML
    private Label lblUser;
    
    private Usuario usuario;        
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        lblUser.setText(usuario.getNombre()+" "+usuario.getApellido()+"!");
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    
    @FXML
    private void alertaInfo(){
        misAutos(usuario);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText("¿Como editar o remover un vehículo?");
        alert.setContentText("Presiona un auto para poder editar sus características o eliminarlo!");
        alert.showAndWait();    

    }


    public void misAutos(Usuario usuario){
        System.out.println("Mis autos:");
        DoublyCircularList<Auto> autos = Archivos.leerAutos();
        System.out.println("¿Cuántos autos hay en la lista? " + autos.size());
        Iterator<Auto> it = autos.iterator();

        int iterationCount = 0;
        while(it.hasNext()) {
            Auto auto = it.next();
            String propietario = auto.getUsuario().getNombre();
            System.out.println("Iteración " + iterationCount + ":");
            System.out.println("Propietario del auto: " + propietario);
            System.out.println("Nombre del usuario actual: " + usuario.getNombre());
            if(propietario.equals(usuario.getNombre())){
                System.out.println("El auto de " + propietario + " es " + auto.toString());
            } else {
                System.out.println("El auto no pertenece a " + usuario.getNombre());
            }
            iterationCount++;
        }
    }
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
