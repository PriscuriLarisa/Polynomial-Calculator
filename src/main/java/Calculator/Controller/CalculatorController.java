package Calculator.Controller;

import Calculator.Model.CalculatorModel.CalculatorModel;
import Calculator.Model.DataModels.PolynomialModel;
import Calculator.Model.Exceptions.DivideByZeroException;
import Calculator.Model.Validator.StringValidator;
import Calculator.View.CalculatorView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {

    private CalculatorView view;
    private CalculatorModel model;

    public CalculatorController(CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;

        this.view.clearFirstListener(new ClearFirstListener());
        this.view.clearSecondListener(new ClearSecondListener());
        this.view.additionListener(new AdditionListener());
        this.view.subtractionListener(new SubtractionListener());
        this.view.derivativeFirstListener(new DerivativeFirstListener());
        this.view.derivativeSecondListener(new DerivativeSecondListener());
        this.view.integrationFirstListener(new IntegrationFirstListener());
        this.view.integrationSecondListener(new IntegrationSecondListener());
        this.view.multiplicationListener(new MultiplicationListener());
        this.view.divisionListener(new DivisionListener());

    }

     class ClearFirstListener implements ActionListener{

         @Override
         public void actionPerformed(ActionEvent e) {
             view.setFirstPolynomial("");
         }
     }

     class ClearSecondListener implements  ActionListener {

         @Override
         public void actionPerformed(ActionEvent e) {
             view.setSecondPolynomial("");
         }
     }

    class AdditionListener implements ActionListener {
        String firstPolynomialString, secondPolynomialString;
        @Override
        public void actionPerformed(ActionEvent e) {

            view.setResultPolynomial("");

            firstPolynomialString = view.getFirstPolynomial();
            secondPolynomialString = view.getSecondPolynomial();
            if(StringValidator.validate(firstPolynomialString) && StringValidator.validate(secondPolynomialString)) {
                PolynomialModel resultPolynomial = model.addPolynomials(firstPolynomialString, secondPolynomialString);
                view.setResultPolynomial(resultPolynomial.polynomialToString());
            }
            else
                JOptionPane.showMessageDialog(view, "Incorrect polynomial form");
        }
    }

    class SubtractionListener implements ActionListener {
        String firstPolynomialString, secondPolynomialString;
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setResultPolynomial("");

            firstPolynomialString = view.getFirstPolynomial();
            secondPolynomialString = view.getSecondPolynomial();
            if(StringValidator.validate(firstPolynomialString) && StringValidator.validate(secondPolynomialString)) {
                PolynomialModel resultPolynomial = model.subPolynomials(firstPolynomialString, secondPolynomialString);
                view.setResultPolynomial(resultPolynomial.polynomialToString());
            }
            else
                JOptionPane.showMessageDialog(view, "Incorrect polynomial form");
        }
    }

    class DerivativeFirstListener implements ActionListener {
        String firstPolynomialString;
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setResultPolynomial("");
            firstPolynomialString = view.getFirstPolynomial();
            if (StringValidator.validate(firstPolynomialString)) {

                PolynomialModel resultPolynomial = model.derivativePolynomials(firstPolynomialString);
                view.setResultPolynomial(resultPolynomial.polynomialToString());
            }
            else
                JOptionPane.showMessageDialog(view, "Incorrect polynomial form");
        }
    }

    class DerivativeSecondListener implements ActionListener {

        String secondPolynomialString;
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setResultPolynomial("");
            secondPolynomialString = view.getSecondPolynomial();
            if (StringValidator.validate(secondPolynomialString)) {
                PolynomialModel resultPolynomial = model.derivativePolynomials(secondPolynomialString);
                view.setResultPolynomial(resultPolynomial.polynomialToString());
            }
            else
                JOptionPane.showMessageDialog(view, "Incorrect polynomial form");
        }
    }

    class IntegrationFirstListener implements ActionListener {

        String firstPolynomialString;
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setResultPolynomial("");
            firstPolynomialString = view.getFirstPolynomial();
            if (StringValidator.validate(firstPolynomialString)) {
                PolynomialModel resultPolynomial = model.integrationPolynomial(firstPolynomialString);
                view.setResultPolynomial(resultPolynomial.polynomialToString());
            }
            else
                JOptionPane.showMessageDialog(view, "Incorrect polynomial form");
        }
    }

    class IntegrationSecondListener implements ActionListener {

        String secondPolynomialString;
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setResultPolynomial("");
            secondPolynomialString = view.getSecondPolynomial();
            if (StringValidator.validate(secondPolynomialString)) {
                PolynomialModel resultPolynomial = model.integrationPolynomial(secondPolynomialString);
                view.setResultPolynomial(resultPolynomial.polynomialToString());
            }
            else
                JOptionPane.showMessageDialog(view, "Incorrect polynomial form");
        }
    }

    class MultiplicationListener implements  ActionListener {

        String firstPolynomialString, secondPolynomialString;
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setResultPolynomial("");

            firstPolynomialString = view.getFirstPolynomial();
            secondPolynomialString = view.getSecondPolynomial();
            if(StringValidator.validate(firstPolynomialString) && StringValidator.validate(secondPolynomialString)) {
                PolynomialModel resultPolynomial = new PolynomialModel();
                resultPolynomial = model.multiplicationPolynomials(firstPolynomialString, secondPolynomialString);

                view.setResultPolynomial(resultPolynomial.polynomialToString());
            }
            else
                JOptionPane.showMessageDialog(view, "Incorrect polynomial form");

        }
    }

    class DivisionListener implements  ActionListener {

        String firstPolynomialString, secondPolynomialString;
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setResultPolynomial("");

            firstPolynomialString = view.getFirstPolynomial();
            secondPolynomialString = view.getSecondPolynomial();
            if(StringValidator.validate(firstPolynomialString) && StringValidator.validate(secondPolynomialString)) {
                PolynomialModel resultPolynomial = new PolynomialModel();
                PolynomialModel remainder = new PolynomialModel();
                try {
                    resultPolynomial = model.dividePolynomials(firstPolynomialString, secondPolynomialString, remainder);
                    if (resultPolynomial != null) {
                        remainder.order();
                        view.setResultPolynomial(resultPolynomial.polynomialToString());
                        view.setRemainderPolynomial(remainder.polynomialToString());
                    } else
                        view.setResultPolynomial("0");
                }
                catch (DivideByZeroException exception) {
                    JOptionPane.showMessageDialog(view, "Division by 0 not allowed!");
                }
            }
            else
                JOptionPane.showMessageDialog(view, "Incorrect polynomial form");

        }
    }


}
