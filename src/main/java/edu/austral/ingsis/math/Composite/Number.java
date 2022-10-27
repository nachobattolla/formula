package edu.austral.ingsis.math.Composite;

import edu.austral.ingsis.math.Composite.Function;

import java.util.List;
import java.util.Map;

public class Number implements Function {

    private final Double number;

    public Number(Double number) {
        this.number = number;
    }

    @Override
    public Double calculate(Map<String, Double> variables) {
        return number;
    }

    @Override
    public List<String> listVariables(List<String> variables) {
        return List.of();
    }

    @Override
    public String toString() {
        if(number % 1 == 0) {
            return ((Integer)this.number.intValue()).toString();
        }
        return this.number.toString();
    }

}
