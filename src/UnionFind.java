import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Class for the union find algorithm. This classes uses union-by-depth and
 * path compression.
 */
public class UnionFind
{
    private static final Random RANDOM = new Random();

    /**
     * Create a new union find data structure.
     * @param size Size of the universe.
     * @return An new union find data structure.
     */
    public static int[] initialize(int size)
    {
        int[] array = new int[size];
        for(int i = 0; i < size; i++) array[i] = i;
        return array;
    }

    /**
     * Find the parent of a certain element.
     * @param array Union find data structure.
     * @param element Element to get the parent for.
     * @return {parent, depth}
     */
    public static int[] find(int[] array, int element)
    {
        return find(array, element, 0);
    }

    /**
     * Find the parent of a certain element.
     */
    public static int[] find(int[] array, int element, int depth)
    {
        /* Own parent - root found. */
        if(array[element] == element) {
            return new int[]{element, depth};
        }

        /* Continue searching recursively, one level deeper. */
        int[] result = find(array, array[element], depth + 1);

        /* Perform path compression. */
        array[element] = result[0];

        return result;
    }

    /**
     * Union operation. Unify two elements. When the two elements are already in
     * the same set, nothing will happen (except perhaps some path compression).
     * @param array Union find data structure.
     * @param element1 Element from one set.
     * @param element2 Element from another set.
     */
    public static void union(int[] array, int element1, int element2)
    {
        int[] result1 = find(array, element1);
        int[] result2 = find(array, element2);

        /* Already in the same set. */
        if(result1[0] == result2[0]) return;

        if(result1[1] < result2[1]) {
            array[result1[0]] = array[result2[0]];
        } else {
            array[result2[0]] = array[result1[0]];
        }
    }

    /**
     * Check if two elements are equivalent.
     * @param array Union find data structure.
     * @param element1 First element.
     * @param element2 Second element.
     * @return If the two elements are in the same set.
     */
    public static boolean isEquivalent(int[] array, int element1, int element2)
    {
        int[] result1 = find(array, element1);
        int[] result2 = find(array, element2);

        return result1[0] == result2[0];
    }

    public static void main(String[] args)
    {
        int size = 100000;

        /* Create a random universe. */
        List<Integer> universe = new ArrayList<Integer>();
        for(int i = 0; i < size; i++) universe.add(i);
        Collections.shuffle(universe);

        /* Split the universe. Both sets should be non-empty. */
        int split = 1 + RANDOM.nextInt(size - 2); 
        List<Integer> firstSet = new ArrayList<Integer>();
        for(int i = 0; i < split; i++) firstSet.add(universe.get(i));
        List<Integer> secondSet = new ArrayList<Integer>();
        for(int i = split; i < size; i++) secondSet.add(universe.get(i));

        /* Create a union find structure. */
        int[] array = initialize(universe.size());

        /* Perform union operations on the two sets. */
        randomUnion(array, firstSet);
        randomUnion(array, secondSet);

        /* Test that all elements are in the same set. */
        int maximumDepth = -1;
        int element = firstSet.get(0);
        for(int i = 1; i < firstSet.size(); i++) {
            Test.test("firstSet equivalence",
                    isEquivalent(array, element, firstSet.get(i)));
            int[] result = find(array, firstSet.get(i));
            if(result[1] > maximumDepth) maximumDepth = result[1];
        }
        element = secondSet.get(0);
        for(int i = 1; i < secondSet.size(); i++) {
            Test.test("firstSet equivalence",
                    isEquivalent(array, element, secondSet.get(i)));
            int[] result = find(array, secondSet.get(i));
            if(result[1] > maximumDepth) maximumDepth = result[1];
        }

        System.out.println("Maximum depth: " + maximumDepth);
    }

    public static void randomUnion(int[] array, List<Integer> original)
    {
        List<Integer> list = new ArrayList<Integer>(original);

        while(list.size() > 1) {
            int index1 = RANDOM.nextInt(list.size());
            int index2 = RANDOM.nextInt(list.size());
            union(array, list.get(index1), list.get(index2));
            if(index1 != index2) list.remove(index2);
        }
    }
}
