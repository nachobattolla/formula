package edu.austral.ingsis.math.Visitor;

import edu.austral.ingsis.math.Visitor.Operators.Values.Number;
import edu.austral.ingsis.math.Visitor.Operators.*;
import edu.austral.ingsis.math.Visitor.Utils.CalculateVisitor;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {
    private final static Visitor<Double> visitor = new CalculateVisitor(Map.of());

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        final Function function = new Sum(
                new Number(1.0),
                new Number(6.0)
        );
        final Double result = function.accept(visitor);

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        final Function function = new Div(
                new Number(12.0),
                new Number(2.0)
        );
        final Double result = function.accept(visitor);

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        final Function function = new Mult(
                new Div(
                        new Number(9.0),
                        new Number(2.0)
                ),
                new Number(3.0)
        );
        final Double result = function.accept(visitor);

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        final Function function = new Power(
                new Div(
                        new Number(27.0),
                        new Number(6.0)
                ),
                new Number(2.0)
        );
        final Double result = function.accept(visitor);

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        final Function function = new Power(
                new Number(36.0),
                new Number(0.5)
        );
        final Double result = function.accept(visitor);

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        final Function function = new Modul(
                new Number(136.0)
        );
        final Double result = function.accept(visitor);

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        final Function function = new Modul(
                new Number(-136.0)
        );
        final Double result = function.accept(visitor);

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        final Function function = new Mult(
                new Subt(
                        new Number(5.0),
                        new Number(5.0)
                ),
                new Number(8.0)
        );
        final Double result = function.accept(visitor);

        assertThat(result, equalTo(0d));
    }
}
