module PROYECTO {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens PROYECTO to javafx.fxml;
    exports PROYECTO;
}
