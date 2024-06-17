module PROYECTO {
    requires javafx.controls;
    requires javafx.fxml;

    opens PROYECTO to javafx.fxml;
    exports PROYECTO;
}
