module PROYECTO {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens Proyectos to javafx.fxml;
    exports Proyectos;
}
