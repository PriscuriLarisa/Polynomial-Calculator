package Calculator.Model.DataModels;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolynomialModel{
    private List<MonomialModel> polynomial;
    private Integer degree;

    public PolynomialModel() {
        polynomial = new ArrayList<>();
        degree = Integer.MIN_VALUE;
    }

    public PolynomialModel(int nul) {
        polynomial = new ArrayList<>();
        addNewExpression(0,0);
        degree = 0;
    }

    public void addNewExpression(Integer coef, Integer exp){
        MonomialModel monomial = new MonomialModel(coef, exp);
        polynomial.add(monomial);

        order();
        setDegree();
    }

    public void addNewExpression(Double coef, Integer exp){
        MonomialModel monomial = new MonomialModel(coef, exp);

        polynomial.add(monomial);

        order();
        setDegree();
    }

    public List<MonomialModel> getPolynomial() {
        return polynomial;
    }

    public void setPolynomial(List<MonomialModel> polynomial) {
        for(MonomialModel tmp : polynomial)
        {
            MonomialModel newMon = new MonomialModel(tmp.getCoef(), tmp.getExp());
            this.polynomial.add(newMon);
        }
        order();
        setDegree();
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree() {
        this.degree = 0;
        for(MonomialModel tmp : polynomial)
            if(this.degree < tmp.getExp() && !(tmp.getCoef().equals(0) || tmp.getCoef().equals(0.0)))
                this.degree = tmp.getExp();
    }

    public MonomialModel getFirstMonomial() {
        for(MonomialModel tmp : polynomial)
            if(tmp.getExp().equals(this.degree))
                return tmp;

        return null;
    }

    public void order() {
        Collections.sort(polynomial, (a, b) -> ( b.compareTo(a)));
    }

    @Override
    public String toString() {
        return "PolynomialModel{" +
                "polynomial=" + polynomial +
                ", degree=" + degree +
                '}';
    }

    public void stringToPolynomial(String polynomialString){
        Pattern p = Pattern.compile( "(-|\\+)?(\\d+)?(\\*?(x|X)?(\\^(-|\\+)?(\\d+))?)?" );
        Matcher m = p.matcher( polynomialString );
        Integer coef, degree;
        while (m.find()) {
            coef =Integer.MIN_VALUE; degree =Integer.MIN_VALUE;
            if (m.group(4) != null) {
                if (m.group(2) == null)
                    if(m.group(1)!=null)
                        coef=Integer.parseInt(m.group(1) + "1");
                    else
                        coef = 1;
                else
                if(m.group(1) != null)
                    coef = Integer.parseInt(m.group(1) + m.group(2));
                else
                    coef = Integer.parseInt(m.group(2));

                if (m.group(5) == null)
                    degree = 1;
                else if(m.group(5) != null) {
                    degree = Integer.parseInt(m.group(7));
                }
                addNewExpression(coef, degree);
            }
            else {
                if ((m.group(2) != null && m.group(5) == null && m.group(4) == null) || m.group(3)==null) {
                    if(m.group(1) != null)
                        coef = Integer.parseInt(m.group(1) + m.group(2));
                    else
                        coef = Integer.parseInt(m.group(2));
                    degree = 0;
                    addNewExpression(coef, degree);
                }
            }
        }
        order();
        setDegree();
    }

    public String polynomialToString() {
        String polynomialString = new String();
        for(MonomialModel monom : polynomial) {
            if(!monom.getCoef().equals(0) && !monom.getCoef().equals(0.0)) {
                if(!polynomialString.isEmpty() && polynomialString.charAt(0) == '-' )
                    polynomialString =  monom.getCoef() + "*X^" + monom.getExp()  + polynomialString;
                else
                    polynomialString =  monom.getCoef() + "*X^" + monom.getExp() + "+" + polynomialString;
            }
        }
        if(!polynomialString.isEmpty())
            polynomialString = removeLastChar(polynomialString);
        else
        {
            polynomialString = "0";
            return polynomialString;
        }
        if(!polynomialString.isEmpty())
        if(polynomialString.charAt(polynomialString.length()-1) == '^' || polynomialString.charAt(polynomialString.length()-1) == '*')
            polynomialString = removeLastChar(polynomialString);
        return polynomialString;
    }

    public static String removeLastChar(String str) {

        return removeLastChars(str, 1);
    }

    public static String removeLastChars(String str, int chars) {
        return str.substring(0, str.length() - chars);
    }

}
