
/**
 * Tools to print stuff, title says it all
 * @author pieter
 */
public class PrintTools {
    public static void dumpArray(double[][] array)
    {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.printf("[ % 5.6g ]", array[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static void dumpArray(int[][] array)
    {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.printf("[ % 5d ]", array[i][j]);
            }
            System.out.print("\n");
        }
    }
}
