package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Recursion15 {

    public static String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        String ans = "";
        k = k - 1;

        while (true) {
            ans = ans + numbers.get(k / fact);
            numbers.remove(k / fact);

            if (numbers.isEmpty())
                break;
            
            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans;
    }

    public static void main(String[] args) {
        // Test with n = 4 and k = 9\
        int n = 4;
        int k = 9;
        String result = getPermutation(n, k);
        System.out.println("The " + k + "th permutation of the sequence [1, 2, 3, 4] is: " + result);
    }
}
