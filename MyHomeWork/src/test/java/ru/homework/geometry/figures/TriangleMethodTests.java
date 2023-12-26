package ru.homework.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleMethodTests {
    @Test
    void canCalculatePerimetr() {
        var t = new Triangle(3.4, 8.1, 10.9);
        double result = t.perimeter();
    //    Assertions.assertEquals(22.4, result);
        if (!(result == 22.4)) {
            throw new AssertionError(String.format("Expected %f, actual %f", 22.4, result));
        }
    }

    @Test
    void canCalculateArea() {
        var t = new Triangle(3.4, 8.1, 10.9);
        double result = t.area();
        Assertions.assertEquals(9.013589739942665, result);
    }

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(3.4, -8.1, 10.9);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            // OK
        }
    }

    @Test
    void cannotCreateTriangleWithIllegalSides() {
        try {
            new Triangle(3.4, 8.1, 1.9);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            // OK
        }
    }
}
