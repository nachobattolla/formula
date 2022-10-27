package edu.austral.ingsis.math.Composite.Operators;

import edu.austral.ingsis.math.Composite.Function;

import java.util.List;
import java.util.Map;

public class Modul implements Function {
    private Function f;

    public Modul(Function f) {
        this.f = f;
    }

    @Override
    public Double calculate(Map<String, Double> variables) {
        return Math.abs(f.calculate(variables));
    }

    @Override
    public List<String> listVariables(List<String> variables) {
        return f.listVariables(variables);
    }

    @Override
    public String toString(){
        return "|" + f.toString() + "|";
    }
}
