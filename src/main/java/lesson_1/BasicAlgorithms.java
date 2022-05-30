package lesson_1;

public class BasicAlgorithms {

    /***
     * A method to calculate a power of int value.
     * @param base - a range of positive or negative int vals, including 0.
     * @param power - a range of positive int vals, including 0.
     * @return - a power of a base.
     */
    public static int power(int base, int power) {
        if (power < 0) {
            throw new IllegalArgumentException("Only positive power is allowed");
        }
        if (base == 0 && power == 0) {
            throw new IllegalArgumentException("Base and power are equal to 0");
        }
        if (base == 0) {
            return 0;
        }
        if (power == 0) {
            return 1;
        }
        int result = base;
        while (power != 1) {
            result *= base;
            power--;
        }
        return result;
    }

    /***
     * A method that calculates a power of int value depending on whether the power val given in params is even number.
     * If not even -  method power() is used.
     * @param base - a range of positive or negative int vals, including 0.
     * @param power - a range of positive int vals, including 0.
     * @return - a power of a base.
     */
    public static int powerWithEvenPowerProperty(int base, int power) {
        if (isPositiveAndEven(power)) {
            int result = base;
            while (power != 1) {
                result *= result;
                power /= 2;
                if (!isPositiveAndEven(power)) {
                    return power(result, power);
                }
            }
            return result;
        }
        return power(base, power);
    }

    /***
     * A method that calculates sum of consecutive natural numbers from 0 inclusive to <limit> inclusive.
     * @param limit - the last number in sequence.
     * @return - the sum.
     */
    public static int getSum(int limit) {
        int result = 0;
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        return result;
    }

    public static boolean isPositiveAndEven(int num) {
        return (num > 0) && ((num % 2) == 0);
    }

    public static void main(String[] args) {

        System.out.println("Third power of two: " + power(2, 3));

        System.out.println("Sixth power of two: " + powerWithEvenPowerProperty(2, 6));

        System.out.println("Sum of numbers from 0 to 100: " + getSum(100));

    }
}
