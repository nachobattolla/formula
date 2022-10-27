package edu.austral.ingsis.math.Visitor;

import edu.austral.ingsis.math.Visitor.Operators.*;
import edu.austral.ingsis.math.Visitor.Operators.Values.Number;
import edu.austral.ingsis.math.Visitor.Operators.Values.Variable;
import edu.austral.ingsis.math.Visitor.Utils.PrintVisitor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {
    final private static Visitor<String> visitor = new PrintVisitor();
    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final Function function = new Sum(
                new Number(1.0),
                new Number(6.0)
        );
        final String expected = "1 + 6";
        final String result = function.accept(visitor);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final Function function = new Div(
                new Number(12.0),
                new Number(2.0)
        );
        final String expected = "12 / 2";
        final String result = function.accept(visitor);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final Function function = new Mult(
                new Parenthesis(
                        new Div(
                                new Number(9.0),
                                new Number(2.0)
                        )
                ),
                new Number(3.0)
        );
        final String expected = "(9 / 2) * 3";
        final String result = function.accept(visitor);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final Function function = new Power(
                new Parenthesis(
                        new Div(
                                new Number(27.0),
                                new Number(6.0)
                        )
                ),
                new Number(2.0)
        );
        final String expected = "(27 / 6) ^ 2";
        final String result = function.accept(visitor);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final Function function = new Subt(
                new Modul(
                        new Variable("value")
                ),
                new Number(8.0)
        );
        final String expected = "|value| - 8";
        final String result = function.accept(visitor);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        final Function function = new Subt(
                new Modul(
                        new Variable("value")
                ),
                new Number(8.0)
        );
        final String expected = "|value| - 8";
        final String result = function.accept(visitor);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final Function function = new Mult(
                new Parenthesis(
                        new Subt(
                                new Number(5.0),
                                new Variable("i")
                        )
                ),
                new Number(8.0)
        );
        final String expected = "(5 - i) * 8";
        final String result = function.accept(visitor);

        assertThat(result, equalTo(expected));
    }
}
