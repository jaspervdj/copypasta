
/**
 * Given a number of points, and a list of connections, calculates all distances
 *
 * @author javache
 */
public class DistanceGraph {

    public static double[][] calculateDistances(int[][] positions, int[][] relations)
    {
        int size = relations.length;
        double[][] distances = new double[size][size];

        for (int i = 0; i < relations.length; i++) {
            for (int j = 0; j < relations[i].length; j++) {
                int connection = relations[i][j];
                if(connection == 0 || distances[i][j] > 0) continue;

                // calculate distance
                double distance = distance( positions[i][0], positions[i][1],
                                            positions[j][0], positions[j][1]);
                distances[i][j] = distance;
                if(relations[j][i] == 1) distances[j][i] = distance;
            }
        }
        return distances;
    }

    private static double distance(int x0, int y0, int x1, int y1)
    {
        int couple1 = (x1 - x0)*(x1 - x0);
        int couple2 = (y1 - y0)*(y1 - y0);
        return Math.sqrt(couple1 + couple2);
    }

    public static void main(String[] args)
    {
        int[][] positions = {
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}, {0,0}
        };
        int[][] relations = {
            {0, 1, 0, 0, 0},
            {1, 0, 1, 0, 0},
            {1, 0, 0, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 1, 0}
        };
        double[][] distances = calculateDistances(positions, relations);

        PrintTools.dumpArray(distances);
    }
}
