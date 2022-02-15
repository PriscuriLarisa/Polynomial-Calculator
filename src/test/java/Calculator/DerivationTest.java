package Calculator;

import Calculator.Model.CalculatorModel.CalculatorModel;
import org.junit.Assert;
import org.junit.Test;

public class DerivationTest {
    @Test
    public void testDerivation() {
        CalculatorModel calculator = new CalculatorModel();
        String derivationString = new String("6*X^2+14*X^1+2*X^0");

        Assert.assertEquals(derivationString, calculator.derivativePolynomials("2x^3+7x^2+2x+9").polynomialToString());
    }
}
