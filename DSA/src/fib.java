public class fib {
    static int[] F; // Array to store computed Fibonacci numbers
    static boolean[] is_computed; // Array to store whether Fibonacci numbers are computed

    public static int fibbo(int i) {
        if (i < 2)
            return i;

        // Initialize the computed array if it's null
        if (F == null) {
            F = new int[i + 1];
            is_computed = new boolean[i + 1];
        }

        // Check if the Fibonacci number for i has already been computed
        if (is_computed[i]) {
            return F[i];
        }

        // Compute Fibonacci number for i
        F[i] = fibbo(i - 1) + fibbo(i - 2);
        is_computed[i] = true;

        // Return the computed Fibonacci number
        return F[i];
    }

    public static int fibbo2(int n) {
        if (n < 2)
            return n;

        int a = 0;
        int b = 1;

        for (int i = 2; i <= n; i++) {
            int new_fib = a + b;
            a = b;
            b = new_fib;
        }

        return b;
    }

    public static void main(String[] args) {
        System.out.println(fibbo(10));
    }
}
