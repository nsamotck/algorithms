import static org.junit.Assert.*;

import lesson_1.BasicAlgorithms;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PowerPositiveTest {
    private int base;
    private int power;
    private int expectedResult;

    public PowerPositiveTest(int base, int power, int expectedResult) {
        this.base = base;
        this.power = power;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object> positiveTestParams() {
        return Arrays.asList(new Object[][]{
                {0, 1, 0},
                {1, 0, 1},
                {2, 2, 4},
                {3, 3, 27},
                {-2, 3, -8},
                {-5, 2, 25}
        });
    }

    @Test
    public void powerPositiveTest() {
        System.out.println(">> params: base=" + base + ", power=" + power);
        assertEquals(expectedResult, BasicAlgorithms.power(base, power));
    }
}
