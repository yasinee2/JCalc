package com.jcalc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
    private Button[] BtnArray;

    private int btnIndex = 0;

    @FXML
    public void initialize() {
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
            CommaButton
        };

        int index = 0;
        for (Button btn : BtnArray) {
            int i = index;
            btn.setOnAction(e -> {
                App.inputHandler(i);
                System.out.println("Controller " + i);
            });
            index++;
        }
    }

}
