import java.util.*;

public class ShuffleArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            System.out.print("Enter the range of numbers for test case " + (t + 1) + ": ");
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int[] shuffledNumbers = shuffleArray(start, end);
            System.out.print("Shuffled numbers for test case " + (t + 1) + ": ");
            for (int num : shuffledNumbers) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        scanner.close();
    }

    public static int[] shuffleArray(int start, int end) {
        int size = end - start + 1;
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = start + i;
        }
        Random rand = new Random();
        for (int i = size - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        return numbers;
    }
}
