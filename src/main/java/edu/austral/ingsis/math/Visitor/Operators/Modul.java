package edu.austral.ingsis.math.Visitor.Operators;

import edu.austral.ingsis.math.Visitor.Function;
import edu.austral.ingsis.math.Visitor.Visitable;
import edu.austral.ingsis.math.Visitor.Visitor;

public class Modul implements Function, Visitable {

    final private Function f;

    public Modul(Function f) {
        this.f = f;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitModul(this);
    }

    public Function getF() {
        return f;
    }
}
