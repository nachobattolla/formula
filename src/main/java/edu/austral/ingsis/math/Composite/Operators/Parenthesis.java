package edu.austral.ingsis.math.Composite.Operators;

import edu.austral.ingsis.math.Composite.Function;

import java.util.List;
import java.util.Map;

public class Parenthesis implements Function {

    private Function f;

    public Parenthesis(Function f){
        this.f = f;
    }
    @Override
    public Double calculate(Map<String, Double> variables) {
        return f.calculate(variables);
    }

    @Override
    public List<String> listVariables(List<String> variables) {
        return List.of();
    }

    @Override
    public String toString() {
        return "(" + f.toString() + ")";
    }
}
