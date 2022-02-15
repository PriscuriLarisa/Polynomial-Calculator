package Calculator;

import Calculator.Model.CalculatorModel.CalculatorModel;
import org.junit.Assert;
import org.junit.Test;

public class IntegrationTest {
    @Test
    public void testIntegration() {
        CalculatorModel calculator = new CalculatorModel();
        String integrationString = new String("0.5*X^4+2.333*X^3+1*X^2+9*X^1");

        Assert.assertEquals(integrationString, calculator.integrationPolynomial("2x^3+7x^2+2x+9").polynomialToString());
    }


}
