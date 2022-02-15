package Calculator;

import Calculator.Model.CalculatorModel.CalculatorModel;
import org.junit.Assert;
import org.junit.Test;

public class SubtractionTest {
    @Test
    public void testSubtraction() {
        CalculatorModel calculator = new CalculatorModel();
        String subtractString = new String("2*X^3+6*X^2+11*X^0");

        Assert.assertEquals(subtractString, calculator.subPolynomials("2x^3+7x^2+2x+9", "x^2+2x-2").polynomialToString());
    }
}
