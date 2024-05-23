
import java.util.Scanner;

public class OddEven {
    public static int[] oddEven(int arr[]) {
        int l = 0;
        int r = arr.length - 1;
        while (l<r){
            while ((arr[l] & 1) == 1 && l < r) {
                l++;
            }
            while ((arr[r] & 1) != 1 && l < r) {
                r--;
            }
            if (l < r) {
                int temp = arr[l];
                arr[l++] = arr[r];
                arr[r--] = temp;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }
            int sortedArr[] = oddEven(arr);
            for (int num : sortedArr) {
                System.out.print(num+" ");
            }
        }
    }
}
