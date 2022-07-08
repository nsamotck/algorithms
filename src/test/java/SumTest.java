import lesson_1.BasicAlgorithms;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SumTest {
    private int limit;
    private int expectedResult;

    public SumTest(int limit, int expectedResult) {
        this.limit = limit;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object> testParams() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {2, 3},
                {3, 6},
                {4, 10},
                {5, 15},
                {6, 21}
        });
    }

    @Test
    public void sumTest() {
        System.out.println(">> params: limit=" + limit + ", expected result=" + expectedResult);
        assertEquals(expectedResult, BasicAlgorithms.getSum(limit));
    }
}
