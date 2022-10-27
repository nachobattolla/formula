package edu.austral.ingsis.math.Visitor;

public interface Visitable {
    <T> T accept(Visitor<T> visitor);
}
