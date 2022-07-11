import lesson_1.BasicAlgorithms;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PowerEvenPropTest {
    private int base;
    private int power;
    private int expectedResult;

    public PowerEvenPropTest(int base, int power, int expectedResult) {
        this.base = base;
        this.power = power;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object> testParams() {
        return Arrays.asList(new Object[][]{
                {2, 2, 4},
                {2, 4, 16},
                {2, 6, 64},
                {3, 2, 9},
                {3, 4, 81},
                {-5, 2, 25}
        });
    }

    @Test
    public void powerEvenPropTest() {
        System.out.println(">>> In powerEvenPropTest, checking env var 'LOGIN'="
                + System.getProperty("LOGIN"));
        System.out.println(">> params: base=" + base + ", power=" + power);
        assertEquals(expectedResult, BasicAlgorithms.powerWithEvenPowerProperty(base, power));
    }
}