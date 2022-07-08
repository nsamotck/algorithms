import lesson_1.BasicAlgorithms;
import org.junit.Test;

public class PowerNegativeTest {

    @Test(expected = IllegalArgumentException.class)
    public void negativeOne() {
        BasicAlgorithms.power(2, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeTwo() {
        BasicAlgorithms.power(0, 0);
    }
}
