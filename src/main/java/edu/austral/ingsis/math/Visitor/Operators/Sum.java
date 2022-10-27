package edu.austral.ingsis.math.Visitor.Operators;

import edu.austral.ingsis.math.Visitor.Function;
import edu.austral.ingsis.math.Visitor.Visitable;
import edu.austral.ingsis.math.Visitor.Visitor;

public class Sum implements Function, Visitable {
    private Function f1;
    private Function f2;

    public Sum(Function f1, Function f2){
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitSum(this);
    }

    public Function getF2() {
        return f2;
    }

    public Function getF1() {
        return f1;
    }
}
