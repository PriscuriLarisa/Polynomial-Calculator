package Calculator.Model.CalculatorModel;

import Calculator.Model.DataModels.MonomialModel;
import Calculator.Model.DataModels.PolynomialModel;
import Calculator.Model.Exceptions.DivideByZeroException;

public class CalculatorModel {
    public PolynomialModel addPolynomials(String firstPolynomialString, String secondPolynomialString){

        PolynomialModel firstPolynomial = new PolynomialModel();
        PolynomialModel secondPolynomial = new PolynomialModel();
        firstPolynomial.stringToPolynomial(firstPolynomialString);
        secondPolynomial.stringToPolynomial(secondPolynomialString);
        firstPolynomial.setDegree();
        secondPolynomial.setDegree();

        return add(firstPolynomial, secondPolynomial);
    }
    public PolynomialModel add(PolynomialModel firstPolynomial, PolynomialModel secondPolynomial){
        PolynomialModel resultPolynomial = new PolynomialModel();
        for(MonomialModel monom : firstPolynomial.getPolynomial()) {
            if(monom.getCoef() instanceof Double)
                    resultPolynomial.addNewExpression(convertIntoDouble(monom.getCoef()), monom.getExp());
                else if(monom.getCoef() instanceof Integer)
                    resultPolynomial.addNewExpression((Integer)monom.getCoef(), monom.getExp());
        }
        for(MonomialModel monom : secondPolynomial.getPolynomial()) {
            MonomialModel toBeUpdated = new MonomialModel(0, 0);
            boolean exists = false;
            for(MonomialModel tmp : resultPolynomial.getPolynomial()) {
                if (tmp.getExp().equals(monom.getExp())) {
                    toBeUpdated = tmp;
                    exists = true;
                }
            }
            if(exists) {
                if (monom.getCoef() instanceof Double || toBeUpdated.getCoef() instanceof Double)
                    toBeUpdated.setCoef(convertIntoDouble(monom.getCoef()) + convertIntoDouble(toBeUpdated.getCoef()));
                else if (monom.getCoef() instanceof Integer && toBeUpdated.getCoef() instanceof Integer)
                    toBeUpdated.setCoef((Integer) monom.getCoef() + (Integer) toBeUpdated.getCoef());
            }
            else {
                if (monom.getCoef() instanceof Double)
                    resultPolynomial.addNewExpression(convertIntoDouble(monom.getCoef()), monom.getExp());
                else if (monom.getCoef() instanceof Integer)
                    resultPolynomial.addNewExpression((Integer) monom.getCoef(), monom.getExp());
            }
        }
        resultPolynomial.order();
        return resultPolynomial;
    }

    public PolynomialModel subPolynomials(String firstPolynomialString, String secondPolynomialString){

        PolynomialModel firstPolynomial = new PolynomialModel();
        PolynomialModel secondPolynomial = new PolynomialModel();
        firstPolynomial.stringToPolynomial(firstPolynomialString);
        secondPolynomial.stringToPolynomial(secondPolynomialString);
        firstPolynomial.setDegree();
        secondPolynomial.setDegree();

        return sub(firstPolynomial, secondPolynomial);
    }

    public PolynomialModel sub(PolynomialModel firstPolynomial, PolynomialModel secondPolynomial){
        PolynomialModel resultPolynomial = new PolynomialModel();
        for(MonomialModel monom : secondPolynomial.getPolynomial()) {
            if(monom.getCoef() instanceof Double)
            {
                Double coef = new Double(convertIntoDouble(monom.getCoef()));
                resultPolynomial.addNewExpression(-coef, monom.getExp());
            }
            else if(monom.getCoef() instanceof Integer)
                resultPolynomial.addNewExpression(-(Integer)monom.getCoef(), monom.getExp());
        }
        for(MonomialModel monom : firstPolynomial.getPolynomial()) {
            MonomialModel toBeUpdated = new MonomialModel(0, 0);
            boolean exists = false;
            for(MonomialModel tmp : resultPolynomial.getPolynomial()) {
                if (tmp.getExp().equals(monom.getExp())) {
                    toBeUpdated = tmp;
                    exists = true;
                }
            }
            if(exists) {
                if (monom.getCoef() instanceof Double || toBeUpdated.getCoef() instanceof Double){
                    Double coef1 = new Double(convertIntoDouble(monom.getCoef()) * 1000);
                    Double coef2 = new Double(convertIntoDouble(toBeUpdated.getCoef())*1000);
                    toBeUpdated.setCoef((coef1 + coef2)/1000);

                }
                else if (monom.getCoef() instanceof Integer && toBeUpdated.getCoef() instanceof Integer)
                    toBeUpdated.setCoef((Integer) monom.getCoef() + (Integer) toBeUpdated.getCoef());
            }
            else if (monom.getCoef() instanceof Double) {
                Double coef = new Double(convertIntoDouble(monom.getCoef()));
                resultPolynomial.addNewExpression(coef, monom.getExp());
            }
                else if (monom.getCoef() instanceof Integer)
                    resultPolynomial.addNewExpression((Integer) monom.getCoef(), monom.getExp());
        }
        resultPolynomial.order();
        return resultPolynomial;
    }

    public PolynomialModel derivativePolynomials(String firstPolynomialString){

        PolynomialModel resultPolynomial = new PolynomialModel();
        PolynomialModel polynomial = new PolynomialModel();

        polynomial.stringToPolynomial(firstPolynomialString);
        for(MonomialModel monom : polynomial.getPolynomial())
            if(!monom.getCoef().equals(0) && !monom.getCoef().equals(0.0))
                resultPolynomial.addNewExpression((Integer) monom.getCoef() * monom.getExp(), monom.getExp()-1);

        resultPolynomial.setDegree();
        return resultPolynomial;
    }

    public PolynomialModel integrationPolynomial(String firstPolynomialString){

        PolynomialModel resultPolynomial = new PolynomialModel();
        PolynomialModel polynomial = new PolynomialModel();

        polynomial.stringToPolynomial(firstPolynomialString);
        for(MonomialModel monom : polynomial.getPolynomial())
            if(!monom.getCoef().equals(0) && !monom.getCoef().equals(0.0))
                if(!((Integer)((Integer)monom.getCoef() % (monom.getExp()+1))).equals(new Integer(0)))
                    resultPolynomial.addNewExpression(round(((1.0d)*(Integer)monom.getCoef())/((1.0d)*(monom.getExp()+1)),3), monom.getExp()+1);
                else
                    resultPolynomial.addNewExpression((Integer)monom.getCoef()/(monom.getExp()+1), monom.getExp()+1);

        resultPolynomial.setDegree();
        return resultPolynomial;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public PolynomialModel multiplicationPolynomials(String firstPolynomialString, String secondPolynomialString) {
        PolynomialModel firstPolynomial = new PolynomialModel();
        PolynomialModel secondPolynomial = new PolynomialModel();

        firstPolynomial.stringToPolynomial(firstPolynomialString);
        secondPolynomial.stringToPolynomial(secondPolynomialString);

        return mul(firstPolynomial, secondPolynomial);
    }

    public PolynomialModel mul(PolynomialModel firstPolynomial, PolynomialModel secondPolynomial) {
        PolynomialModel resultedPolynomial = new PolynomialModel();
        for(MonomialModel monom1 : firstPolynomial.getPolynomial()){
            for(MonomialModel monom2 : secondPolynomial.getPolynomial()) {
                if(!monom1.getCoef().equals(0) && !monom1.getCoef().equals(0.0) && !monom2.getCoef().equals(0) && !monom2.getCoef().equals(0.0)) {
                    MonomialModel toBeUpdated = new MonomialModel(0,0);
                    boolean exists = false;
                    for(MonomialModel tmp : resultedPolynomial.getPolynomial())
                        if(((Integer)(monom1.getExp()+monom2.getExp())).equals(tmp.getExp())) {
                            toBeUpdated = tmp;
                            exists = true;
                        }
                    if(exists) {
                        if (monom1.getCoef() instanceof Double || monom2.getCoef() instanceof Double)
                            toBeUpdated.setCoef(convertIntoDouble(toBeUpdated.getCoef()) + 1.0d * convertIntoDouble(monom1.getCoef()) * convertIntoDouble(monom2.getCoef()));
                        else if (monom1.getCoef() instanceof Integer && monom2.getCoef() instanceof Integer)
                            toBeUpdated.setCoef((Integer) toBeUpdated.getCoef() + (Integer) monom1.getCoef() * (Integer) monom2.getCoef());
                    }
                    else
                        if(monom1.getCoef() instanceof Double || monom2.getCoef() instanceof Double)
                            resultedPolynomial.addNewExpression( convertIntoDouble(1.0d * convertIntoDouble(monom1.getCoef())) * convertIntoDouble(monom2.getCoef()), monom1.getExp()+monom2.getExp());
                        else if (monom1.getCoef() instanceof Integer && monom2.getCoef() instanceof Integer)
                            resultedPolynomial.addNewExpression((Integer)monom1.getCoef() * (Integer)monom2.getCoef(), monom1.getExp()+monom2.getExp());
                }
            }
        }
        resultedPolynomial.order();
        resultedPolynomial.setDegree();
        return resultedPolynomial;
    }

    public PolynomialModel dividePolynomials(String firstPolynomialString, String secondPolynomialString, PolynomialModel remainder) throws DivideByZeroException {
        PolynomialModel firstPolynomial = new PolynomialModel();
        PolynomialModel secondPolynomial = new PolynomialModel();
        firstPolynomial.stringToPolynomial(firstPolynomialString);
        secondPolynomial.stringToPolynomial(secondPolynomialString);

        if(secondPolynomial.getPolynomial().size()==1 && secondPolynomial.getPolynomial().get(0)!=null && (secondPolynomial.getPolynomial().get(0).getCoef().equals(0) || secondPolynomial.getPolynomial().get(0).getCoef().equals(0.0)))
        {
            System.out.println("Nu se poate imparti cu 0");
            throw new DivideByZeroException();
        }
        else {
            PolynomialModel returned = divide(firstPolynomial, secondPolynomial, remainder);
            returned.order();
            return returned;
        }

    }

    public PolynomialModel divide(PolynomialModel firstPolynomial, PolynomialModel secondPolynomial, PolynomialModel remainder) {
        firstPolynomial.setDegree(); firstPolynomial.order();
        secondPolynomial.setDegree(); firstPolynomial.order();
        if(firstPolynomial.getDegree() < secondPolynomial.getDegree() || (firstPolynomial.getDegree().equals(0) && secondPolynomial.getDegree().equals(0))) {
            remainder.setPolynomial(firstPolynomial.getPolynomial());
            remainder.setDegree();
            remainder.order();
            return new PolynomialModel(0);
        }
        MonomialModel monom = new MonomialModel(0,0);
        MonomialModel tmp1 = firstPolynomial.getFirstMonomial();
        MonomialModel tmp2 = secondPolynomial.getFirstMonomial();
        if(((Double)(convertIntoDouble(tmp1.getCoef()) % convertIntoDouble(tmp2.getCoef()))).equals(0.0) || ((Double)(convertIntoDouble(tmp1.getCoef()) % convertIntoDouble(tmp2.getCoef()))).equals(-0.0)){
            monom.setCoef((Integer)convertIntoInteger((convertIntoDouble(tmp1.getCoef()) / convertIntoDouble(tmp2.getCoef()))));
        }
        else
            monom.setCoef(convertIntoDouble((1.0d * convertIntoDouble(tmp1.getCoef()) / convertIntoDouble(tmp2.getCoef()))));
        monom.setExp(tmp1.getExp() - tmp2.getExp());
        PolynomialModel result = new PolynomialModel();
        if(monom.getCoef() instanceof Double)
            result.addNewExpression(convertIntoDouble(monom.getCoef()), monom.getExp());
        else
            result.addNewExpression((Integer) monom.getCoef(), monom.getExp());
        result.setDegree();;
        PolynomialModel r1 = mul(secondPolynomial, result);
        PolynomialModel r2 = sub(firstPolynomial, r1);
        r2.setDegree();
        r2.order();
        PolynomialModel r3 = divide(r2, secondPolynomial, remainder);
        result.setDegree();
        r3.setDegree();
        return add(result, r3);
    }

    public Double convertIntoDouble(Object convert) {
        if(convert instanceof Integer)
            return (((Integer)convert).doubleValue());
        if(convert instanceof Double)
            return (Double)convert;
        return null;
    }

    public Integer convertIntoInteger(Object convert) {
        if(convert instanceof Double)
            return (((Double)convert).intValue());
        if(convert instanceof Integer)
            return (Integer)convert;
        return null;
    }
}
