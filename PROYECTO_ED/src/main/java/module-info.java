module PROYECTO {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens Proyectos to javafx.fxml;
    opens Bases to javafx.fxml;
    opens PROYECTO to javafx.fxml;
    exports PROYECTO;
}
