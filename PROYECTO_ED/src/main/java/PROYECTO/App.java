package PROYECTO;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import Bases.*;
import Proyectos.*;


public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"), 1000, 870);
        scene.getStylesheets().add(getClass().getResource("estilos.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("GuayacoCar - Iniciar Sesión");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        /*Imprimir usuarios */
        Map<String, Usuario> users = Archivos.leerUsuarios();

        for (Map.Entry<String, Usuario> entry : users.entrySet()) {
            String correo = entry.getKey();        // Obtener el correo (clave)
            Usuario usuario = entry.getValue();    // Obtener el usuario (valor)
        
            String nombre = usuario.getNombre();   // Obtener el nombre del usuario
        
            // Imprimir el correo y el nombre
            System.out.println("Correo: " + correo + ", Nombre: " + nombre);
        }
        

        /*
        
        
        System.out.println("Mis autos:");
        DoublyCircularList<Auto> autos = Archivos.leerAutos();
        System.out.println("¿Cuántos autos hay en la lista? " + autos.size() );
        Iterator<Auto> it = autos.iterator();

        while(it.hasNext()) {
            Auto auto = it.next();
            String propietario = auto.getUsuario().getNombre();
            System.out.println("El propietario del auto con placa "+auto.getPlaca()+ "  es : "+propietario);
            System.out.println("Informacion del auto: "+auto);

        }
        */
        
        launch();       

        
    }
    
    


}