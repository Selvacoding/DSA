
import java.util.Scanner;

public class RotateArray {
    public static int[] rotateArray(int arr[], int n) {
        helper(arr, 0, arr.length - 1);
        helper(arr, 0, n-1 );
        helper(arr, n, arr.length-1);
        return arr;
    }
    
    public static void helper(int arr[], int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public static void main(String[] args) {
        int rotate = 4;
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = scan.nextInt();
            }
            int ans[] = rotateArray(arr, rotate);
            for (int num : ans) {
                System.out.print(num + " ");
            }
        }
    }
}
