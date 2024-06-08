public class slindinWindowPattern2 {
// Dynamic Window
    public static void main(String[] args) {
        int[] a = {2, 5, 1, 7, 10};
        int k = 14; // max value should be less than or equal to 14
        int l = 0;
        int r = 0;
        int sum = 0;
        int max_length = 0;

        while (r < a.length) {
            sum += a[r];
            if (sum >= k) { // here if i put while T.C will be O(N+N) 
                // if i put if T.C  is O(N) we are going to return maxlength only
                // we don't need to shrink it so that we use if 
                // but there is  a catch i have to use if in the maxlength also
                sum -= a[l];
                l++;
            }
            if(sum < k) // this if condition we need to because of not using while
                max_length = Math.max(max_length, r - l + 1);
            r++;
        }

        System.out.println(" "+max_length);
    }
}
