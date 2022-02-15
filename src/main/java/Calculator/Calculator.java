package Calculator;

import Calculator.Controller.CalculatorController;
import Calculator.Model.CalculatorModel.CalculatorModel;
import Calculator.View.CalculatorView;


public class Calculator {
    public static void main (String[] args) {
        CalculatorView view = new CalculatorView("Polynomial calculator");
        CalculatorModel model = new CalculatorModel();
        CalculatorController controller = new CalculatorController(view, model);

        view.setVisible(true);
    }
}
