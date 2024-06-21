package PROYECTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class LoginController {
    
    private DoublyCircularList<String> list=new DoublyCircularList<String>();
    private DoublyCircularNode<String> currentNode;
    private Label prueba;
    
        @FXML
    private Button BT2;

    @FXML
    private Button BT1;

    @FXML
    private Label PRUEBA;

    @FXML
    public void adelante() {
        currentNode=currentNode.getNext();
        PRUEBA.setText(currentNode.getContent());
    }

    @FXML
    public void atras() {
        currentNode=currentNode.getPrevious();
        PRUEBA.setText(currentNode.getContent());
    }
    
     @FXML
    public void initialize() {
               
        list.addLast("estan");
        list.addLast("hola");
        list.addLast("que");
        list.addLast("tal");
        list.addLast("como");
        
        
        currentNode = list.getLast().getNext();
    }
    
    @FXML
    public void handleNextNode() {
        prueba.setText(currentNode.getContent());
    }
    
    @FXML
    private void switchToPrimary() throws IOException {
        System.out.println("PRESIONASTE EL BOTON");
    }
    //Plataforma.obtenerUsuarios()
}
