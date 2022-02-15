package Calculator;

import Calculator.Model.CalculatorModel.CalculatorModel;
import org.junit.Assert;
import org.junit.Test;

public class AdditionTest {
    @Test
    public void testAddition(){
        CalculatorModel calculator = new CalculatorModel();
        String additionString = new String("2*X^3+8*X^2+4*X^1+7*X^0");

        Assert.assertEquals(additionString, calculator.addPolynomials("2x^3+7x^2+2x+9", "x^2+2x-2").polynomialToString());
    }

}
