package edu.austral.ingsis.math.Visitor.Utils;

import edu.austral.ingsis.math.Visitor.Operators.*;
import edu.austral.ingsis.math.Visitor.Operators.Values.Number;
import edu.austral.ingsis.math.Visitor.Operators.Values.Variable;
import edu.austral.ingsis.math.Visitor.Visitor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListVariablesVisitor implements Visitor<List<String>> {
    @Override
    public List<String> visitSubt(Subt operand) {
        return Stream.concat(operand.getF1().accept(this).stream(), operand.getF2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitSum(Sum operand) {
        return Stream.concat(operand.getF1().accept(this).stream(), operand.getF2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitDiv(Div operand) {
        return  Stream.concat(operand.getF1().accept(this).stream(), operand.getF2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitMult(Mult operand) {
        return Stream.concat(operand.getF1().accept(this).stream(), operand.getF2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitModul(Modul operand) {
        return operand.getF().accept(this);
    }

    @Override
    public List<String> visitPower(Power operand) {
        return Stream.concat(operand.getF1().accept(this).stream(), operand.getF2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitRoot(Root operand) {
        return Stream.concat(operand.getF1().accept(this).stream(), operand.getF2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitParenthesis(Parenthesis operand) {
        return operand.getF1().accept(this);
    }

    @Override
    public List<String> visitVariable(Variable operand) {
        return List.of(operand.getVariable());
    }

    @Override
    public List<String> visitNumber(Number number) {
        return List.of();
    }
}
