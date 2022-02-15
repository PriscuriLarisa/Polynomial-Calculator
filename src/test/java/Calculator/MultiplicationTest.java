package Calculator;

import Calculator.Model.CalculatorModel.CalculatorModel;
import org.junit.Assert;
import org.junit.Test;

public class MultiplicationTest {
    @Test
    public void testMultiplication() {
        CalculatorModel calculator = new CalculatorModel();
        String multiplicationString = new String("2*X^5+11*X^4+12*X^3-1*X^2+14*X^1-18*X^0");

        Assert.assertEquals(multiplicationString, calculator.multiplicationPolynomials("2x^3+7x^2+2x+9", "x^2+2x-2").polynomialToString());
    }
}
