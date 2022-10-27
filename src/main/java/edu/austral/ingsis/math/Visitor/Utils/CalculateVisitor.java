package edu.austral.ingsis.math.Visitor.Utils;

import edu.austral.ingsis.math.Visitor.Operators.*;
import edu.austral.ingsis.math.Visitor.Operators.Values.Number;
import edu.austral.ingsis.math.Visitor.Operators.Values.Variable;
import edu.austral.ingsis.math.Visitor.Visitor;

import java.util.Map;

public class CalculateVisitor implements Visitor<Double>{

    private final Map<String, Double> variableValues;
    private Double result;

    public CalculateVisitor(Map<String, Double> variableValues) {
        this.variableValues = variableValues;
    }

    @Override
    public Double visitSubt(Subt operand) {
        return operand.getF1().accept(this) - operand.getF2().accept(this);
    }

    @Override
    public Double visitSum(Sum operand) {
        return operand.getF1().accept(this) + operand.getF2().accept(this);
    }

    @Override
    public Double visitDiv(Div operand) {
        return operand.getF1().accept(this) / operand.getF2().accept(this);
    }

    @Override
    public Double visitMult(Mult operand) {
        return operand.getF1().accept(this) * operand.getF2().accept(this);
    }

    @Override
    public Double visitModul(Modul operand) {
        return Math.abs(operand.getF().accept(this));
    }

    @Override
    public Double visitPower(Power operand) {
        return Math.pow(operand.getF1().accept(this), operand.getF2().accept(this));
    }

    @Override
    public Double visitRoot(Root operand) {
        return Math.pow(operand.getF1().accept(this), 1/operand.getF2().accept(this));
    }

    @Override
    public Double visitParenthesis(Parenthesis operand) {
        return operand.getF1().accept(this);
    }

    @Override
    public Double visitNumber(Number operand) {
        return operand.getNumber();
    }

    @Override
    public Double visitVariable(Variable operand) {
        return this.variableValues.get(operand.getVariable());
    }
}
