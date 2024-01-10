
package calculator;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

    
public class FXMLDocumentController implements Initializable {

    ArrayList<Double> doubleArray = new ArrayList<>();
    @FXML
    private TextField textField;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button exponential;
    @FXML
    private Button clear;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button buttonlog;
    @FXML
    private Button buttonxpowerx;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button buttonsinx;
    @FXML
    private Button buttontanx;
    @FXML
    private Button buttondot;
    @FXML
    private Button button0;
    @FXML
    private Button buttondelete;
    @FXML
    private Button buttoncosx;
    @FXML
    private Button buttoncotx;
    @FXML
    private Button buttonplus;
    @FXML
    private Button buttonequals;
    @FXML
    private Button buttondivision;
    @FXML
    private Button buttonmultiplication;
    @FXML
    private Button buttonminus;
    
    Calculate calculator = new Calculate();
// @AUTHOR "SİN" "COS" "TAN" "COT" "LOG"  "X^X" "E^X" KAYRA CANSIN GÖKMEN
// @AUTHOR "DELETE" "C" "+" "/" "*" "=" "-" NUMBERS AHMET EMRE ÇAKMAK
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void button7click(ActionEvent event) {
        
        textField.appendText("7");
    }

    @FXML
    private void button8click(ActionEvent event) {
        textField.appendText("8");
    }

    @FXML
    private void button9click(ActionEvent event) {
        textField.appendText("9");
    }

    @FXML
    private void exponentialclick(ActionEvent event) {
        addTrigonometricOperands("e^x");
        textField.setText("e^x");
        String result = calculator.calculateTrigonometric();
        textField.setText(result);
    }

    @FXML
    private void clearclick(ActionEvent event) {
        calculator.clear();
        textField.clear();
        doubleArray.clear();
        textField.setPromptText("");
    }

    @FXML
    private void button4click(ActionEvent event) {
        textField.appendText("4");
    }

    @FXML
    private void button5click(ActionEvent event) {
        textField.appendText("5");
    }

    @FXML
    private void button6click(ActionEvent event) {
        textField.appendText("6");
    }
    
    @FXML
    private void buttonlogclick(ActionEvent event) {
        addTrigonometricOperands("log");
        textField.setText("log");
        String result = calculator.calculateTrigonometric();
        textField.setText(result);
    }

    @FXML
    private void buttonxpowerxclick(ActionEvent event) {
        addOperands("x^x");
        textField.clear();
        textField.setPromptText("^");
    }

    @FXML
    private void button1click(ActionEvent event) {
        textField.appendText("1");
    }

    @FXML
    private void button2click(ActionEvent event) {
        textField.appendText("2");
    }

    @FXML
    private void button3click(ActionEvent event) {
        textField.appendText("3");
    }

    @FXML
    private void buttonsinxclick(ActionEvent event) {
        addTrigonometricOperands("sin");
        textField.setText("sin");
        String result = calculator.calculateTrigonometric();
        textField.setText(result);
    }

    @FXML
    private void buttontanxclick(ActionEvent event) {
        addTrigonometricOperands("tan");
        textField.setText("tan");
        String result = calculator.calculateTrigonometric();
        textField.setText(result);
    }

    @FXML
    private void buttondotclick(ActionEvent event) {
        textField.appendText(".");
    }

    @FXML
    private void button0click(ActionEvent event) {
        textField.appendText("0");
    }

    @FXML
    private void buttondeleteclick(ActionEvent event) {
        textField.deleteText(textField.getLength()-1,textField.getLength());
    }

    @FXML
    private void buttoncosxclick(ActionEvent event) {
        addTrigonometricOperands("cos");
        textField.setText("cos");
        String result = calculator.calculateTrigonometric();
        textField.setText(result);
    }

    @FXML
    private void buttoncotxclick(ActionEvent event) {
        addTrigonometricOperands("cot");
        textField.setText("cot");
        String result = calculator.calculateTrigonometric();
        textField.setText(result);

    }

    @FXML
    private void buttonplusclick(ActionEvent event) {
        addOperands("+");
        textField.clear();
        textField.setPromptText("+");
        
    }

    @FXML
    private void buttonequalsclick(ActionEvent event) {
        String s = textField.getText();
        double number = Double.parseDouble(s);
        calculator.addSimpleNumber(number);
        textField.setText(String.valueOf(calculator.calculateSimpleOperations()));
        calculator.clear();
    }

    @FXML
    private void buttondivisionclick(ActionEvent event) {
        addOperands("/");
        textField.clear();
        textField.setPromptText("/");
    }

    @FXML
    private void buttonmultiplicationclick(ActionEvent event) {
        addOperands("*");
        textField.clear();
        textField.setPromptText("*");
    }

    @FXML
    private void buttonminusclick(ActionEvent event) {
        addOperands("-");
        textField.clear();
        textField.setPromptText("-");
    }

    //@AUTHOR AHMET EMRE ÇAKMAK
    protected void addOperands(String s) {
        double number =Double.parseDouble(textField.getText());
        calculator.addSimpleNumber(number);
        doubleArray.clear();
        calculator.addBasicOperand(s);
    }
    //@AUTHOR KAYRA CANSIN GÖKMEN
    protected void addTrigonometricOperands(String operation) {
        double number = Double.parseDouble(textField.getText());
        calculator.addTrigonometricNumber(number);
        doubleArray.clear();
        calculator.addTrigonometricOperand(operation);
    }

}
