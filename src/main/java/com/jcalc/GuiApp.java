package com.jcalc;

import java.io.IOException;

import com.complexcalc.evaluator.ComplexEvaluator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class GuiApp extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("BasicCalcUI"), 700, 800);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GuiApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    protected static void inputHandler(Button button) {
        BasicController.instance.NumbField.requestFocus();
        switch (button.getText()) {
            case "=" ->
                BasicController.instance.NumbField.setText(calculate());
            case "AC" ->
                BasicController.instance.NumbField.setText("");
            case "C" -> {
                if (BasicController.instance.NumbField.getText().length() > 0) {
                    BasicController.instance.NumbField.setText(BasicController.instance.NumbField.getText().substring(0, BasicController.instance.NumbField.getText().length() - 1));
                }
            }
            case "Complex" -> {
                try {
                    setRoot("ComplexCalcUI");
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
            default -> {
                System.out.println("lol");
                BasicController.instance.NumbField.appendText(button.getText());
            }
        }
    }

    protected static void ComplexinputHandler(Button button) {
        ComplexController.instance.NumbField.requestFocus();
        switch (button.getText()) {
            case "=" ->
                ComplexController.instance.NumbField.setText(calculate());

            case "AC" ->
                ComplexController.instance.NumbField.setText("");
            case "C" -> {
                if (ComplexController.instance.NumbField.getText().length() > 0) {
                    ComplexController.instance.NumbField.setText(ComplexController.instance.NumbField.getText().substring(0, ComplexController.instance.NumbField.getText().length() - 1));
                }
            }
            case "Basic" -> {
                try {
                    setRoot("BasicCalcUI");
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
            default -> {
                System.out.println("lol");
                ComplexController.instance.NumbField.appendText(button.getText());
            }
        }
    }

    protected static String calculate() {
        System.out.println("Calculating...");
        String expression = BasicController.instance.NumbField.getText();
        try {
            return String.valueOf(new ComplexEvaluator(expression).eval());
        } catch (Error e) {
            System.err.println(String.valueOf(e));
            return "Error";
        }
    }

    protected static String Complexcalculate() {
        System.out.println("Calculating...");
        String expression = ComplexController.instance.NumbField.getText();
        System.out.println(expression);
        try {
            return String.valueOf(new ComplexEvaluator(expression).eval());
        } catch (Error e) {
            System.err.println(String.valueOf(e));
            return "Error";
        }
    }
}
