/**
 * A class to do base conversions. All values in certain bases are kept in
 * arrays, where array[0] is the least significant digit and
 * array[array.length - 1] the most significant digit.
 *
 * @author jaspervdj
 */
public class BaseConversion
{
    /**
     * Convert a given value to a certain base.
     * @param value Value to convert.
     * @param base Base to convert the value to.
     * @return The given value in the requested base.
     */
    public static int[] fromValue(int value, int base)
    {
        int power = base;
        int i = 0;

        /* Find upper limit. */
        while(power < value) {
            power = power * base;
            i++;
        }

        int[] array = new int[i + 1];

        /* Find all factors. */
        power /= base;
        while(i >= 0) {
            array[i] = value / power;
            value -= array[i] * power;
            power /= base;
            i--;
        }

        return array;
    }

    /**
     * Get the value of a certain base notation.
     * @param array Array containing the base notation.
     * @param base Base to convert from.
     * @return The value of array in the given base.
     */
    public static int toValue(int[] array, int base)
    {
        int power = 1;
        int value = 0;
        for(int i = 0; i < array.length; i++) {
            value += array[i] * power;
            power *= base;
        }

        return value;
    }

    /**
     * Convert bases.
     * @param array Array containint the base notation.
     * @param originalBase Original base for the array.
     * @param newBase Base to convert the array to.
     * @return The new base array.
     */
    public static int[] covertBase(int[] array, int originalBase, int newBase)
    {
        int value = toValue(array, originalBase);
        return fromValue(value, newBase);
    }

    public static void main(String[] args)
    {
        /* fromValue(13, 2) should be 1101. */
        int[] a13base2 = fromValue(13, 2);
        Test.test("fromValue(13, 2)", a13base2.length == 4 &&
                                      a13base2[3] == 1 &&
                                      a13base2[2] == 1 &&
                                      a13base2[1] == 0 &&
                                      a13base2[0] == 1);

        /* 1101 should be 13. */
        a13base2 = new int[4];
        a13base2[3] = 1;
        a13base2[2] = 1;
        a13base2[1] = 0;
        a13base2[0] = 1;
        Test.test("toValue({1,1,0,1}, 2)", toValue(a13base2, 2) == 13);
    }
}
