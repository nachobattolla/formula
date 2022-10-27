package edu.austral.ingsis.math.Visitor;

import edu.austral.ingsis.math.Visitor.Operators.*;
import edu.austral.ingsis.math.Visitor.Operators.Values.Number;
import edu.austral.ingsis.math.Visitor.Operators.Values.Variable;

public interface Visitor<T> {
    T visitSubt(Subt operand);
    T visitSum(Sum operand);
    T visitDiv(Div operand);
    T visitMult(Mult operand);
    T visitModul(Modul operand);
    T visitPower(Power operand);
    T visitRoot(Root operand);
    T visitParenthesis(Parenthesis operand);
    T visitVariable(Variable operand);
    T visitNumber(Number number);
}
