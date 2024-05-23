// Count possible paths in a matrix
public class CountPossiblePaths {
    
    public static int countPaths(int[][] matrix, int[] start, int[] destination) {
        return dfs(matrix, start[0], start[1], destination);
    }

    private static int dfs(int[][] matrix, int i, int j, int[] destination) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 0)
            return 0;
        if (i == destination[0] && j == destination[1])
            return 1;
        matrix[i][j] = 0; // mark as visited
        int paths = dfs(matrix, i + 1, j, destination) +
                    dfs(matrix, i - 1, j, destination) +
                    dfs(matrix, i, j + 1, destination) +
                    dfs(matrix, i, j - 1, destination);
        matrix[i][j] = 1; // backtrack
        return paths;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 0, 0, 1},
            {1, 0, 1, 0},
            {1, 1, 1, 0},
            {0, 1, 1, 1}
        };
        int[] start = {1, 2};
        int[] destination = {0, 0};
        System.out.println(" output = "+countPaths(matrix, start, destination)); // Output: 2
    }
}
