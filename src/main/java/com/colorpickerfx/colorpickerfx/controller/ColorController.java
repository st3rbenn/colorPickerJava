package com.colorpickerfx.colorpickerfx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import com.gluonhq.charm.glisten.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ColorController implements Initializable {
    @FXML
    private Slider redColorSlider;
    @FXML
    private Slider greenColorSlider;
    @FXML
    private Slider blueColorSlider;

    @FXML
    private TextField redColorInput;
    @FXML
    private TextField greenColorInput;
    @FXML
    private TextField blueColorInput;

    @FXML
    private TextField hexaInput;
    @FXML
    private Pane colorRender;

    private int[] colorPalette = new int[7];
    @FXML
    private Pane colorRenderVariant1;
    @FXML
    private Pane colorRenderVariant2;
    @FXML
    private Pane colorRenderVariant3;
    @FXML
    private Pane colorRenderVariant4;
    @FXML
    private Pane colorRenderVariant5;
    @FXML
    private Pane colorRenderVariant6;

    private int r;
    private int g;
    private int b;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addListenerToSlider(redColorSlider, redColorInput, "red");
        addListenerToSlider(greenColorSlider, greenColorInput, "green");
        addListenerToSlider(blueColorSlider, blueColorInput, "blue");
    }

    private void RGBToHexa(int r, int g, int b) {
        String hexa = String.format("#%02x%02x%02x", r, g, b);
        hexaInput.setText(hexa);
        colorRender.setStyle("-fx-background-color: " + hexa);

        //iterate to all fx:id colorRenderVariant and set the color
        generateVarianteColor(r, g, b);
    }

    private void addListenerToSlider(Slider slider, TextField field, String color) {
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            field.setText(String.valueOf(newValue.intValue()));
            switch (color) {
                case "red" -> r = newValue.intValue();
                case "green" -> g = newValue.intValue();
                case "blue" -> b = newValue.intValue();
            }
            RGBToHexa(r, g, b);
        });
    }

    private void generateVarianteColor(int r, int g, int b) {
        colorPalette[0] = r;
        colorPalette[1] = g;
        colorPalette[2] = b;

        colorPalette[3] = (int) (r * 0.5);
        colorPalette[4] = (int) (g * 0.5);
        colorPalette[5] = (int) (b * 0.5);

        colorPalette[6] = (int) (r * 0.25);

        List<Pane> colorRenderVariantList = List.of(colorRenderVariant1, colorRenderVariant2, colorRenderVariant3, colorRenderVariant4, colorRenderVariant5, colorRenderVariant6);

        for (int i = 0; i < colorPalette.length; i++) {
            colorRenderVariantList.get(i).setStyle("-fx-background-color: " + String.format("#%02x%02x%02x", colorPalette[i], colorPalette[i + 1], colorPalette[i + 2]));
        }
    }

}
