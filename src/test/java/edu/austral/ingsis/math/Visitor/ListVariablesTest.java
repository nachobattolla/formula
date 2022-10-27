package edu.austral.ingsis.math.Visitor;

import edu.austral.ingsis.math.Visitor.Operators.*;
import edu.austral.ingsis.math.Visitor.Operators.Values.Variable;
import edu.austral.ingsis.math.Visitor.Operators.Values.Number;
import edu.austral.ingsis.math.Visitor.Utils.ListVariablesVisitor;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;


public class ListVariablesTest {
    final private static Visitor<List<String>> visitor = new ListVariablesVisitor();
    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        final Function function = new Sum(
                new Number(1.0),
                new Number(6.0)
        );
        final List<String> result = function.accept(visitor);

        assertThat(result, empty());
    }


    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        final Function function = new Div(
                new Number(12.0),
                new Variable("div")
        );

        final List<String> result = function.accept(visitor);

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        final Function function = new Mult(
                new Div(
                        new Number(9.0),
                        new Variable("x")
                ),
                new Variable("y")
        );
        final List<String> result = function.accept(visitor);

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        final Function function = new Power(
                new Div(
                        new Number(27.0),
                        new Variable("a")
                ),
                new Variable("b")
        );
        final List<String> result = function.accept(visitor);

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        final Function function = new Power(
                new Variable("z"),
                new Number(0.5)
        );
        final List<String> result = function.accept(visitor);

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        final Function function = new Subt(
                new Modul(
                        new Variable("value")
                ),
                new Number(8.0)
        );
        final List<String> result = function.accept(visitor);

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        final Function function = new Subt(
                new Modul(
                        new Variable("value")
                ),
                new Number(8.0)
        );
        final List<String> result = function.accept(visitor);

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        final Function function = new Mult(
                new Subt(
                        new Number(5.0),
                        new Variable("i")
                ),
                new Number(8.0)
        );
        final List<String> result = function.accept(visitor);

        assertThat(result, containsInAnyOrder("i"));
    }
}