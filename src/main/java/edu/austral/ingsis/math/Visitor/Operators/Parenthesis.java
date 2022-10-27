package edu.austral.ingsis.math.Visitor.Operators;

import edu.austral.ingsis.math.Visitor.Function;
import edu.austral.ingsis.math.Visitor.Visitable;
import edu.austral.ingsis.math.Visitor.Visitor;

public class Parenthesis implements Function, Visitable {
    private final Function f;

    public Parenthesis(Function f) {
        this.f = f;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitParenthesis(this);
    }

    public Function getF1() {
        return f;
    }

}
