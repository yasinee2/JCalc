package com.jcalc;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class BasicController {

    @FXML
    private Button NumbButton1 = new Button();
    @FXML
    private Button NumbButton2 = new Button();
    @FXML
    private Button NumbButton3 = new Button();
    @FXML
    private Button NumbButton4 = new Button();
    @FXML
    private Button NumbButton5 = new Button();
    @FXML
    private Button NumbButton6 = new Button();
    @FXML
    private Button NumbButton7 = new Button();
    @FXML
    private Button NumbButton8 = new Button();
    @FXML
    private Button NumbButton9 = new Button();
    @FXML
    private Button NumbButton0 = new Button();

    @FXML
    private Button EqualsButton = new Button();

    @FXML
    private Button CommaButton = new Button();
    @FXML
    private Button AddButton = new Button();
    @FXML
    private Button SubtractButton = new Button();
    @FXML
    private Button MultiplyButton = new Button();
    @FXML
    private Button DivideButton = new Button();

    @FXML
    private Button ModeButton = new Button();

    @FXML
    private Button DelButton = new Button();
    @FXML
    private Button ClearButton = new Button();

    @FXML
    private Button RParenButton = new Button();

    @FXML
    private Button LParenButton = new Button();

    @FXML
    protected TextField NumbField;

    protected static BasicController instance;

    @FXML
    private Button[] BtnArray;
    private String LastText = "";
    private String CurrentText = "";

    @FXML
    public void initialize() {
        instance = this;
        BtnArray = new Button[]{
            NumbButton0,
            NumbButton1,
            NumbButton2,
            NumbButton3,
            NumbButton4,
            NumbButton5,
            NumbButton6,
            NumbButton7,
            NumbButton8,
            NumbButton9,
            EqualsButton,
            CommaButton,
            AddButton,
            SubtractButton,
            MultiplyButton,
            DivideButton,
            LParenButton,
            RParenButton,
            DelButton,
            ClearButton,
            ModeButton
        };

        for (Button btn : BtnArray) {
            btn.setOnAction(e -> {
                GuiApp.inputHandler(btn);
            });
        }
        NumbField.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
            if (key.getCode() == KeyCode.ENTER) {
                if (NumbField.getText().length() > 0) {
                    GuiApp.inputHandler(EqualsButton);
                }
            }
        });
        NumbField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.contains(String.valueOf("="))) {
                String TextWithoutEquals = NumbField.getText().replace("=", "");
                NumbField.setText(TextWithoutEquals);
                Platform.runLater(() -> {
                    GuiApp.inputHandler(EqualsButton);
                    NumbField.positionCaret(NumbField.getLength());
                });
            }
        });
    }

}
