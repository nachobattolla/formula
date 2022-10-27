package edu.austral.ingsis.math.Composite.Operators;

import edu.austral.ingsis.math.Composite.Function;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sum implements Function {

    private Function f1;
    private Function f2;

    public Sum(Function f1, Function f2){
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public Double calculate(Map<String, Double> variables) {
        return f1.calculate(variables) + f2.calculate(variables);
    }

    @Override
    public List<String> listVariables(List<String> variables) {
       return List.of();
    }

    @Override
    public String toString() {
        return f1.toString() + " + " + f2.toString();
    }

}
