package com.jcalc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ComplexController {

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
    private Button iButton = new Button();
    @FXML
    private Button PowButton = new Button();
    @FXML
    private Button sinButton = new Button();
    @FXML
    private Button cosButton = new Button();
    @FXML
    private Button tanButton = new Button();
    @FXML
    private Button sinhButton = new Button();
    @FXML
    private Button coshButton = new Button();
    @FXML
    private Button tanhButton = new Button();
    @FXML
    private Button sqrtButton = new Button();
    @FXML
    private Button arctanhButton = new Button();
    @FXML
    private Button arccoshButton = new Button();
    @FXML
    private Button arccosButton = new Button();
    @FXML
    private Button arcsinhButton = new Button();
    @FXML
    private Button arcsinButton = new Button();
    @FXML
    private Button arctanButton = new Button();
    @FXML
    private Button logButton = new Button();

    @FXML
    protected TextField NumbField;

    protected static ComplexController instance;

    @FXML
    private Button[] BtnArray;

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
            ModeButton,
            sinButton,
            cosButton,
            tanButton,
            sinhButton,
            coshButton,
            tanhButton,
            arcsinButton,
            arccosButton,
            arctanButton,
            arcsinhButton,
            arccoshButton,
            arctanhButton,
            sqrtButton,
            iButton,
            PowButton,
            logButton
        };

        for (Button btn : BtnArray) {
            btn.setOnAction(e -> {
                GuiApp.ComplexinputHandler(btn);
            });
        }
        NumbField.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
            String character = key.getCharacter();
            if (!character.matches("[0-9+\\-*/.()]") && key.getCode() != KeyCode.ENTER) {
                //[0-9+\\-*/.^()iA-Za-z]
                key.consume();
            }
            if (key.getCode() == KeyCode.ENTER || character.matches("=")) {
                if (NumbField.getText().length() > 0) {
                    GuiApp.ComplexinputHandler(EqualsButton);
                }
            }
        });
    }
}
