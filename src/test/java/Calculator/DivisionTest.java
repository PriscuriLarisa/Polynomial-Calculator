package Calculator;

import Calculator.Model.CalculatorModel.CalculatorModel;
import Calculator.Model.DataModels.PolynomialModel;
import Calculator.Model.Exceptions.DivideByZeroException;
import org.junit.Assert;
import org.junit.Test;

public class DivisionTest {
    @Test
    public void testDivision() {
        CalculatorModel calculator = new CalculatorModel();
        String resultDivisionString = new String("2*X^1+3*X^0");
        String remainderDivisionString = new String("15*X^0");

        PolynomialModel resultPolynomial = new PolynomialModel();
        PolynomialModel remainderPolynomial = new PolynomialModel();

        try {
            resultPolynomial = calculator.dividePolynomials("2x^3+7x^2+2x+9", "x^2+2x-2", remainderPolynomial);
        } catch (DivideByZeroException e) {
            Assert.assertTrue(true);
        }
        Assert.assertEquals(resultDivisionString, resultPolynomial.polynomialToString());
        Assert.assertEquals(remainderDivisionString, remainderPolynomial.polynomialToString());
    }
}
