package edu.austral.ingsis.math.Visitor.Operators.Values;

import edu.austral.ingsis.math.Visitor.Function;
import edu.austral.ingsis.math.Visitor.Visitable;
import edu.austral.ingsis.math.Visitor.Visitor;

public class Number implements Function, Visitable {

    private final Double number;

    public Number(Double number) {
        this.number = number;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitNumber(this);
    }

    public Double getNumber() {
        return this.number;
    }
}
