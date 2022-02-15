package Calculator.Model.DataModels;

public class MonomialModel<T> {
    private Integer exp;
    private T coef;

    public MonomialModel(T coef, Integer exp) {
        this.coef = coef;
        this.exp = exp;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public T getCoef() {
        return coef;
    }

    public void setCoef(T coef) {
        this.coef = coef;
    }

    @Override
    public String toString() {
        return "MonomialModel{" +
                "exp=" + exp +
                ", coef=" + coef +
                '}';
    }

    public int compareTo(MonomialModel conversation) {
        return conversation.getExp().compareTo(this.getExp());
    }
}
