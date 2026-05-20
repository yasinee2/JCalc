package com.jcalc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    protected TextField NumbField;

    protected static BasicController instance;

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
            DivideButton
        };

        for (Button btn : BtnArray) {
            btn.setOnAction(e -> {
                App.inputHandler(btn);
            });
        }
    }

}
