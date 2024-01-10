/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.ArrayList;

/**
 *
 * @author emre
 */
public class Calculate {

    ArrayList<Double> numbersArray;
    ArrayList<String> operandsArray;
    ArrayList<Double> trigonometricNumberArray;
    ArrayList<String> trigonometricOperandArray;
    
    double result;

    Calculate() {
        numbersArray = new ArrayList<Double>();
        operandsArray = new ArrayList<String>();
        trigonometricNumberArray = new ArrayList<Double>();
        trigonometricOperandArray = new ArrayList<String>();
        
    }
// @AUTHOR AHMET EMRE ÇAKMAK 
    protected void addBasicOperand(String s) {
        switch (s) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "x^x":
                operandsArray.add(s);
                break;
            default:
                System.out.println("you entered invalid input");
                break;
        }
    }
// @AUTHOR KAYRA CANSIN GÖKMEN
    protected void addTrigonometricOperand(String s) {
        switch (s) {
            case "sin":
            case "cos":
            case "tan":
            case "cot":
            case "e^x":
            case "log":
                trigonometricOperandArray.add(s);
                break;
            default:
                System.out.println("you entered invalid value");
        }
    }
//  ARA YÜZÜ , RESPONSİVE @AUTHOR KAYRA CANSIN GÖKMEN BUTTONLARI @AUTHOR AHMET EMRE ÇAKMAK
    protected void addSimpleNumber(Double i) {
        numbersArray.add(i);
    }

    protected void addTrigonometricNumber(Double i) {
        trigonometricNumberArray.add(i);
    }

    
// @AUTHOR AHMET EMRE ÇAKMAK
    protected String calculateSimpleOperations() {
        if (numbersArray.isEmpty() || operandsArray.isEmpty()) {
            return String.valueOf((int) result);
        }
        for (int i = 0; i < operandsArray.size(); i++) {
        if(operandsArray.get(i).equals("x^x")){
                    numbersArray.set(i + 1, Math.pow(numbersArray.get(i), numbersArray.get(i + 1)));
                            numbersArray.remove(i);
                            operandsArray.remove(i);
        }
                }
        for (int i = 0; i < operandsArray.size(); i++) {
            if (i < numbersArray.size() - 1) {
                
                if (operandsArray.get(i).equals("*") || operandsArray.get(i).equals("/")) {
                    switch (operandsArray.get(i)) {
                        case "*":
                            numbersArray.set(i + 1, numbersArray.get(i) * numbersArray.get(i + 1));
                            numbersArray.remove(i);
                            operandsArray.remove(i);
                            i--; 
                            break;
                        case "/":
                            if (numbersArray.get(i + 1) != 0) {
                                numbersArray.set(i + 1, numbersArray.get(i) / numbersArray.get(i + 1));
                                numbersArray.remove(i);
                                operandsArray.remove(i);
                                i--;
                            } else {

                                return "Division by zero error";
                            }
                            break;
                    }
                }
            }
        }

        for (int i = 0; i < operandsArray.size(); i++) {
            if (i < numbersArray.size() - 1) {
                switch (operandsArray.get(i)) {
                    case "+":
                        numbersArray.set(i + 1, numbersArray.get(i) + numbersArray.get(i + 1));
                        break;
                    case "-":
                        numbersArray.set(i + 1, numbersArray.get(i) - numbersArray.get(i + 1));
                        break;
                    case "x^x": 
                       
                        if (i < numbersArray.size() - 1) {
                            double base = numbersArray.get(i);
                            double exponent = numbersArray.get(i + 1); 
                            if (exponent < 0 && base == 0) {
                                return "asdasdasds input for ^";
                            }
                            double result = Math.pow(base, exponent);

                            numbersArray.set(i + 1, result); 
                            numbersArray.remove(i); 
                            operandsArray.remove(i); 
                            i--; 
                        } else {
                            return "Invalid input for ^";
                        }
                        break;
                }
            }
        }

        result = numbersArray.get(numbersArray.size() - 1);
        if (result % 1 == 0) {
            return String.valueOf((int) result);

        } else {
            return String.valueOf(result);
        }

    }
//@AUTHOR KAYRA CANSIN GÖKMEN
    protected String calculateTrigonometric() {
        if (trigonometricNumberArray.isEmpty() || trigonometricOperandArray.isEmpty()) {
            return String.valueOf((int) result);
        }

        for (int i = 0; i < trigonometricOperandArray.size(); i++) {
            double number = trigonometricNumberArray.get(i);
            String operation = trigonometricOperandArray.get(i);
            switch (operation) {
                case "sin":
                    result = Math.sin(Math.toRadians(number));
                    break;
                case "cos":
                    result = Math.cos(Math.toRadians(number));
                    break;
                case "tan":
                    result = Math.tan(Math.toRadians(number));
                    break;
                case "cot":
                    result = 1.0 / Math.tan(Math.toRadians(number));
                    break;
                case "e^x":
                    result = Math.exp(number);
                    break;
                case "log":
                    if (number > 0) {
                        double nmb = number;
                        double base = 10.0;
                        result = Math.log(nmb) / Math.log(base);
                    } else {
                        return "Invalid input for log";
                    }
                    break;

            }
        }

        if (result % 1 == 0) {
            return String.valueOf((int) result);
        } else {
            return String.valueOf(result);
        }
    }

    protected void clear() {
        result = 0.0;
        operandsArray.clear();
        numbersArray.clear();
        trigonometricNumberArray.clear();
        trigonometricOperandArray.clear();
        
    }

}
