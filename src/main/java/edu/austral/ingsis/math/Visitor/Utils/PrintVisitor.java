package edu.austral.ingsis.math.Visitor.Utils;

import edu.austral.ingsis.math.Visitor.Operators.*;
import edu.austral.ingsis.math.Visitor.Operators.Values.Number;
import edu.austral.ingsis.math.Visitor.Operators.Values.Variable;
import edu.austral.ingsis.math.Visitor.Visitor;

public class PrintVisitor implements Visitor<String> {
    @Override
    public String visitSubt(Subt operand) {
        return operand.getF1().accept(this) + " - " + operand.getF2().accept(this);
    }

    @Override
    public String visitSum(Sum operand) {
        return operand.getF1().accept(this) + " + " + operand.getF2().accept(this);
    }

    @Override
    public String visitDiv(Div operand) {
        return operand.getF1().accept(this) + " / " + operand.getF2().accept(this);
    }

    @Override
    public String visitMult(Mult operand) {
        return operand.getF1().accept(this) + " * " + operand.getF2().accept(this);
    }

    @Override
    public String visitModul(Modul operand) {
        return "|" + operand.getF().accept(this) + "|";
    }

    @Override
    public String visitPower(Power operand) {
        return operand.getF1().accept(this) + " ^ " + operand.getF2().accept(this);
    }

    @Override
    public String visitRoot(Root operand) {
        return "(" + operand.getF1().accept(this) + ")√" + operand.getF1().accept(this);
    }

    @Override
    public String visitParenthesis(Parenthesis operand) {
        return "(" + operand.getF1().accept(this) + ")";
    }

    @Override
    public String visitVariable(Variable operand) {
        return operand.getVariable();
    }

    @Override
    public String visitNumber(Number number) {
        final Double n = number.getNumber();
        if(n % 1 == 0) {
            return ((Integer) n.intValue()).toString();
        }else{
            return number.toString();
        }
    }
}
