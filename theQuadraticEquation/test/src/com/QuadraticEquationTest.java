package src.com;

import com.QuadraticEquation;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class QuadraticEquationTest {

    @Test
    public void returnNull() {
        Assert.assertNull(QuadraticEquation.calc(-9, -5, -2));
    }

    @Test
    public void randomNumbers() {
        for (int i = 0; i < 100; i++) {
            float a = QuadraticEquation.random();
            float b = QuadraticEquation.random();
            float c = QuadraticEquation.random();
            System.out.println("a=" + a + " b=" + b + " c=" + c + " " + Arrays.toString(QuadraticEquation.calc(a, b, c)));
        }
    }
}