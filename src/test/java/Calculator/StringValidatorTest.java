package Calculator;


import Calculator.Model.Validator.StringValidator;
import org.junit.Assert;
import org.junit.Test;


public class StringValidatorTest {

    @Test
    public void testStringValidator(){

        Assert.assertEquals(true,StringValidator.validate(new String("-2x^3+2x^2-4x+1")));
        Assert.assertEquals(false,StringValidator.validate(new String("x^a&")));
    }

}
