package Calculator;

import Calculator.Model.DataModels.MonomialModel;
import Calculator.Model.DataModels.PolynomialModel;
import org.junit.Assert;
import org.junit.Test;

public class PolynomialTest {
    @Test
    public void testPolynomial() {
        PolynomialModel expectedPolynomial = new PolynomialModel();
        expectedPolynomial.addNewExpression(new Integer(3), 2);
        expectedPolynomial.addNewExpression(new Integer(2), 3);
        expectedPolynomial.addNewExpression(new Integer(-2), 0);

        String polynomialString = new String("2*X^3+3*X^2-2*X^0");
        String unorderedPolynomialString = new String("3*X^2+2*X^3-2*X^0");
        PolynomialModel actualPolynomial = new PolynomialModel();
        actualPolynomial.stringToPolynomial(unorderedPolynomialString);

        actualPolynomial.order();
        expectedPolynomial.order();


        boolean identical = false;
        for(MonomialModel monom1 : actualPolynomial.getPolynomial()) {
            identical = false;
            for(MonomialModel monom2 : expectedPolynomial.getPolynomial()) {
                if(monom1.getExp().equals(monom2.getExp())) {
                    if (monom1.getCoef() instanceof Double && monom2.getCoef() instanceof Double) {
                        if (((Double) monom1.getCoef()).equals((Double) monom2.getCoef())) {
                            identical = true;
                        }
                    }
                    if(monom1.getCoef() instanceof Integer && monom2.getCoef() instanceof Integer) {
                        if(((Integer)monom1.getCoef()).equals((Integer)monom2.getCoef())) {
                            identical = true;
                        }
                    }
                }
            }
            if(!identical)
                break;
        }

        // test for polynomialToString() and order()
        Assert.assertEquals(polynomialString, actualPolynomial.polynomialToString());
        // test for stringToPolynomial()
        Assert.assertEquals(true, identical);
    }
}
