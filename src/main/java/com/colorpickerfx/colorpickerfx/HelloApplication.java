package com.colorpickerfx.colorpickerfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        try {
            // Read file fxml and draw interface.
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/com/colorpickerfx/colorpickerfx/ColorPicker.fxml")));
            Scene scene = new Scene(root, 600, 235);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}