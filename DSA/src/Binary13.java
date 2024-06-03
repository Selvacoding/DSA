public class Binary13 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; i++){
            if(matrix[i][0] <= target && matrix[i][n-1] >= target){
                int low = 0, high = n - 1;
                while(low <= high){
                    int mid = low + (high - low) / 2;
                    if(matrix[i][mid] == target)
                        return true;
                    else if(matrix[i][mid] < target)
                        low = mid + 1;
                    else
                        high = mid - 1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] arr ={
                        {1,3,5,7},{10,11,16,20},{23,30,34,60}
                    };
        int target = 3;
        System.out.println(searchMatrix(arr, target));
    }
}
