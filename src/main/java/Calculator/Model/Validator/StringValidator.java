package Calculator.Model.Validator;

public class StringValidator {
    public static boolean validate (String string) {
        if (string.matches("^[*xX0-9^+-]+$")) {
            return true;
        }
        return false;
    }
}
