package com.jcalc;

import java.io.IOException;

import com.complexcalc.evaluator.ComplexEvaluator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
                if (BasicController.instance.NumbField.getText().matches("Error")) {
                    BasicController.instance.NumbField.setText("");
                }
                BasicController.instance.NumbField.appendText(button.getText());
            }
            // 67 67 67
        }
    }

    protected static void ComplexinputHandler(Button button) {
        ComplexController.instance.NumbField.requestFocus();
        switch (button.getText()) {
            case "=" ->
                ComplexController.instance.NumbField.setText(Complexcalculate());

            case "AC" ->
                ComplexController.instance.NumbField.setText("");
            case "C" -> {
                Delete(ComplexController.instance.NumbField);
            }
            case "sin" -> {
                ComplexController.instance.NumbField.appendText(button.getText() + "(");
            }
            case "cos" -> {
                ComplexController.instance.NumbField.appendText(button.getText() + "(");
            }
            case "tan" -> {
                ComplexController.instance.NumbField.appendText(button.getText() + "(");
            }
            case "sinh" -> {
                ComplexController.instance.NumbField.appendText(button.getText() + "(");
            }
            case "cosh" -> {
                ComplexController.instance.NumbField.appendText(button.getText() + "(");
            }
            case "tanh" -> {
                ComplexController.instance.NumbField.appendText(button.getText() + "(");
            }
            case "arcsin" -> {
                ComplexController.instance.NumbField.appendText(button.getText() + "(");
            }
            case "arccos" -> {
                ComplexController.instance.NumbField.appendText(button.getText() + "(");
            }
            case "arctan" -> {
                ComplexController.instance.NumbField.appendText(button.getText() + "(");
            }
            case "arcsinh" -> {
                ComplexController.instance.NumbField.appendText(button.getText() + "(");
            }
            case "arccosh" -> {
                ComplexController.instance.NumbField.appendText(button.getText() + "(");
            }
            case "arctanh" -> {
                ComplexController.instance.NumbField.appendText(button.getText() + "(");
            }
            case "sqrt" -> {
                ComplexController.instance.NumbField.appendText(button.getText() + "(");
            }
            case "log" -> {
                ComplexController.instance.NumbField.appendText(button.getText() + "(");
            }

            case "Basic" -> {
                try {
                    setRoot("BasicCalcUI");
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
            default -> {
                if (ComplexController.instance.NumbField.getText().matches("Error")) {
                    ComplexController.instance.NumbField.setText("");
                }
                ComplexController.instance.NumbField.appendText(button.getText());
            }
        }
    }

    protected static String calculate() {
        System.out.println("Calculating...");
        String expression = BasicController.instance.NumbField.getText();
        try {
            return String.valueOf(new ComplexEvaluator(expression).eval());
        } catch (Exception e) {
            System.err.println(e);
            return "Error";
        }
    }

    protected static String Complexcalculate() {
        System.out.println("ComplexCalculating...");
        String expression = ComplexController.instance.NumbField.getText();
        System.out.println(expression);
        try {
            return String.valueOf(new ComplexEvaluator(expression).eval());
        } catch (Exception e) {
            System.err.println(e);
            return "Error";
        }
    }

    protected static void Delete(TextField numbField) {
        String text = numbField.getText();
        if (text.isEmpty()) {
            return;
        }

        String[] functions = {
            "arcsinh(", "arccosh(", "arctanh(",
            "arcsin(", "arccos(", "arctan(",
            "sinh(", "cosh(", "tanh(",
            "sqrt(", "log(",
            "sin(", "cos(", "tan("
        };

        for (String func : functions) {
            if (text.endsWith(func + "(") || text.endsWith(func)) {
                numbField.setText(text.substring(0, text.length() - func.length()));
                numbField.positionCaret(numbField.getLength());
                return;
            }
        }
        numbField.setText(text.substring(0, text.length() - 1));
        numbField.positionCaret(numbField.getLength());
    }
}
