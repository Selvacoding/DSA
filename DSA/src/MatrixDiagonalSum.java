import java.util.Scanner;

public class MatrixDiagonalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();
        
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        int result = largestDiagonalSum(matrix);
        System.out.println("Largest sum of two triangles: " + result);
        
        scanner.close();
    }

    public static int largestDiagonalSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Calculate the sum of the upper triangle
        int upperSum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - i; j++) {
                upperSum += matrix[i][j];
            }
        }

        // Calculate the sum of the lower triangle
        int lowerSum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = cols - i - 1; j < cols; j++) {
                lowerSum += matrix[i][j];
            }
        }

        // Return the maximum sum of the two triangles
        return Math.max(upperSum, lowerSum);
    }
}
