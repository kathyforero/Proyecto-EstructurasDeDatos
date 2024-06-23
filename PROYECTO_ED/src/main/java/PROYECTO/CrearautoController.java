package PROYECTO;

import Proyectos.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CrearautoController {
    private Usuario usuario;
    @FXML
    private Label lblUser;
    @FXML
    private Button btnRegresar;
    
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        lblUser.setText(usuario.getNombre()+" "+usuario.getApellido()+"!");
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    @FXML
    private void regresar(ActionEvent event) {
    }
   
    
}
