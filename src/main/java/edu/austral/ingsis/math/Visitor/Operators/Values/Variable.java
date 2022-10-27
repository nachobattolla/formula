package edu.austral.ingsis.math.Visitor.Operators.Values;

import edu.austral.ingsis.math.Visitor.Function;
import edu.austral.ingsis.math.Visitor.Visitable;
import edu.austral.ingsis.math.Visitor.Visitor;

public class Variable implements Function, Visitable {
    private final String variable;

    public Variable(String variable) {
        this.variable = variable;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitVariable(this);
    }

    public String getVariable() {
        return this.variable;
    }
}
