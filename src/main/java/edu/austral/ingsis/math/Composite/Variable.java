package edu.austral.ingsis.math.Composite;

import java.util.List;
import java.util.Map;

public class Variable implements Function{

    private final String variable;

    public Variable(String variable) {
        this.variable = variable;
    }

    @Override
    public Double calculate(Map<String, Double> variables) {
        return variables.get(variable);
    }

    @Override
    public List<String> listVariables(List<String> variables) {
        return List.of(variable);
    }

    @Override
    public String toString() {
        return variable;
    }
}
