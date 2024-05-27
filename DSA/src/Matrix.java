// spriral matrix
import java.util.ArrayList;
import java.util.List;

public class Matrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int rowStart = 0, colStart = 0;
        int rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1;
        List<Integer> result = new ArrayList<>();

        while (rowStart <= rowEnd && colStart <= colEnd) {

            for (int i = colStart; i <= colEnd; i++)
                result.add(matrix[rowStart][i]);
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++)
                result.add(matrix[i][colEnd]);
            colEnd--;

            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--)
                    result.add(matrix[rowEnd][i]);
                rowEnd--;
            }

            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--)
                    result.add(matrix[i][colStart]);
                colStart++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(spiralOrder(matrix)); // output = [1,2,3,6,9,8,7,4,5] 
        int[][] matrix2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        System.out.println(spiralOrder(matrix2)); // output = [1,2,3,4,8,12,11,10,9,5,6,7]
    }
}
