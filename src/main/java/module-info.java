module com.colorpickerfx.colorpickerfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires charm.glisten;

    opens com.colorpickerfx.colorpickerfx.controller to javafx.fxml;
    exports com.colorpickerfx.colorpickerfx.controller;
    exports com.colorpickerfx.colorpickerfx;
}