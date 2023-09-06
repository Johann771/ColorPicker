package com.johann.colorfx.controller;

import com.johann.colorfx.model.Color;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class ColorController implements Initializable {
    @FXML
    private Slider sliderRed;
    @FXML
    private Slider sliderGreen;
    @FXML
    private Slider sliderBlue;
    @FXML
    private Pane paneColor;
    @FXML
    private TextField textFieldHexa;
    @FXML
    private Text textErrorHexa;
    @FXML
    private TextField textFieldRed;
    @FXML
    private TextField textFieldGreen;
    @FXML
    private TextField textFieldBlue;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {
        Color uneCouleur = new Color(0,0,0);
        paneColor.setStyle("-fx-background-color:"+"#FFFFFF");
        textFieldHexa.setText(uneCouleur.getHexValue());
        textFieldRed.setTextFormatter(getTextFormatter());
        textFieldGreen.setTextFormatter(getTextFormatter());
        textFieldBlue.setTextFormatter(getTextFormatter());
//        submitHexValue.setOnMouseClicked(mouseEvent -> {
//            try {
//                uneCouleur.setHexValue(textFieldHexa.getText());
//                paneColor.setStyle("-fx-background-color:"+uneCouleur.getHexValue());
//                textErrorHexa.setVisible(false);
//                sliderRed.setValue(uneCouleur.getRed());
//                sliderGreen.setValue(uneCouleur.getGreen());
//                sliderBlue.setValue(uneCouleur.getBlue());
//            } catch (Exception e){
//                System.out.println(e);
//                textErrorHexa.setVisible(true);
//            }
//        });

        sliderRed.valueProperty().addListener((observable, oldValue, newValue) -> {
            uneCouleur.setRed(newValue.intValue());
            setColor(uneCouleur);
            textFieldRed.setText(Integer.toString(uneCouleur.getRed()));
        });


        sliderGreen.valueProperty().addListener((observable, oldValue, newValue) -> {
            uneCouleur.setGreen(newValue.intValue());
            setColor(uneCouleur);
            textFieldGreen.setText(Integer.toString(uneCouleur.getGreen()));
        });
        sliderBlue.valueProperty().addListener((observable, oldValue, newValue) -> {
            uneCouleur.setBlue(newValue.intValue());
            setColor(uneCouleur);
            textFieldBlue.setText(Integer.toString(uneCouleur.getBlue()));
        });

        textFieldRed.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()){
                uneCouleur.setRed(Integer.parseInt(newValue));
                setColor(uneCouleur);
                sliderRed.setValue(Integer.parseInt(newValue));
            }
        });
        textFieldGreen.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()){
                uneCouleur.setGreen(Integer.parseInt(newValue));
                setColor(uneCouleur);
                sliderGreen.setValue(Integer.parseInt(newValue));
            };
        });
        textFieldBlue.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()){
                uneCouleur.setBlue(Integer.parseInt(newValue));
                setColor(uneCouleur);
                sliderBlue.setValue(Integer.parseInt(newValue));
            }
        });
    }
    private void setColor(Color uneCouleur){
        paneColor.setStyle("-fx-background-color:"+uneCouleur.getHexValue());
        textFieldHexa.setText(uneCouleur.getHexValue());
    }
    private TextFormatter<Integer> getTextFormatter() {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.isEmpty()) { // Permet la suppression du texte
                return change;
            }
            if (newText.matches("\\d*")) {
                try {
                    int value = Integer.parseInt(newText);
                    if (value >= 0 && value <= 255) {
                        return change;
                    }
                } catch (NumberFormatException ignored) {
                }
            }
            return null;
        };

        return new TextFormatter<>(new IntegerStringConverter(), 0, filter);
    }
}