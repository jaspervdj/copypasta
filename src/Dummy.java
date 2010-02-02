/**
 * A dummy class as example.
 */
public class Dummy
{
    /**
     * Multiply two integers.
     * @param a First integer.
     * @param b Second integer.
     */
    public static int multiply(int a, int b)
    {
        return a * b;
    }

    /**
     * We always have a main method to test the workings of a class.
     */
    public static void main(String[] args)
    {
        Test.test("multiply(4, 5)", multiply(4, 5) == 20);
    }
}
