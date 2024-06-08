import java.util.Arrays;

public class Binary15 {
    private static int findMaxIndex(int[][] a, int col){
        int maxValue = -1;
        int index = -1;
        for(int i=0; i<a.length; i++){
            if(a[i][col] > maxValue){
                maxValue = a[i][col];
                index =i;
            }
        }
        return index;
    }
    public static int[] findPeakGrid(int[][] mat) {
        int low =0, high = mat[0].length;

        while(low <= high){
            int mid = low + (high-low)/2;

            int maxRow = findMaxIndex(mat,mid);
            int left = mid - 1 >= 0 ? mat[maxRow][mid-1] : -1;
            int right = mid + 1 < mat[0].length ? mat[maxRow][mid+1] : -1;

            if(mat[maxRow][mid] > right && mat[maxRow][mid] > left)
                return new int [] {maxRow,mid};
            else if(mat[maxRow][mid] < left)
                high = mid-1;
            else
                low = mid+1; 
        }
        return new int [] {-1,-1};
    }
    public static void main(String[] args) {
        int[][] mat = { { 10, 20, 15 }, { 21, 30, 14 }, { 7, 16, 32 } };
        System.out.println(Arrays.toString(findPeakGrid(mat)));
    }
}
