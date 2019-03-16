package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Controller implements Display {
    @FXML
    TextField display;



    private Calculator calc;

    public Controller() {
        calc = new Calculator(this);
    }

    @Override
    public String getDisplayNumber() {
        return display.getText();
    }

    @Override
    public void setDisplayNumber(String displayNumber) {
        display.setText(displayNumber);
    }


    public void buttonClick(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String digit = button.getText();

        calc.digit(digit);
    }



    public void Clear(ActionEvent actionEvent) {
        calc.clear();
    }



    public void actionComma(ActionEvent actionEvent) {
        calc.comma();
    }



    public void buttonSqrt(ActionEvent actionEvent) {
        calc.sqrt();
    }


    public void percentButton(ActionEvent actionEvent) {
        calc.percent();
    }


    public void buttonOperator(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String operator = button.getText();
        calc.operator(operator);
            }

    public void buttonEnter(ActionEvent actionEvent) {
        calc.enter();

    }

    public void delete(ActionEvent actionEvent) {
        calc.delete();
    }
}
