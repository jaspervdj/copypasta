/**
 * A class for testing.
 *
 * @author jaspervdj
 */
public class Test
{
    /**
     * Run a simple test.
     * @param description Short description of the test.
     * @param result Outcome of the test.
     */
    public static void test(String description, boolean result)
    {
        if(!result) {
            System.err.println("Test failed: " + description);
        }
    }
}
