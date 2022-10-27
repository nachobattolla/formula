package edu.austral.ingsis.math.Composite.Operators;

import edu.austral.ingsis.math.Composite.Function;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sqrt implements Function {

    private Function f1;
    private Function f2;

    public Sqrt(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }
    @Override
    public Double calculate(Map<String, Double> variables) {
        return Math.pow(f1.calculate(variables), 1/f2.calculate(variables));
    }

    @Override
    public List<String> listVariables(List<String> variables) {
        return Stream.concat(f1.listVariables(variables).stream(), f2.listVariables(variables).stream()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return f1.toString() + "^ 1/" + f2.toString() ;
    }
}
