module PROYECTO {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens Clases to javafx.fxml;
    opens Bases to javafx.fxml;
    opens Controladores to javafx.fxml;
    exports Controladores;
}
