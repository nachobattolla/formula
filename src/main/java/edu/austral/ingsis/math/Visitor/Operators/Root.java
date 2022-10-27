package edu.austral.ingsis.math.Visitor.Operators;

import edu.austral.ingsis.math.Visitor.Function;
import edu.austral.ingsis.math.Visitor.Visitable;
import edu.austral.ingsis.math.Visitor.Visitor;

public class Root implements Function, Visitable {

    private final Function f1;
    private final Function f2;

    public Root(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return null;
    }

    public Function getF1() {
        return f1;
    }

    public Function getF2() {
        return f2;
    }
}
