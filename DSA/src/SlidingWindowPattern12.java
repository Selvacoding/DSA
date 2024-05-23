public class SlidingWindowPattern12 {
    public static int characterReplacement(String s, int k) {
        int l=0, r=0, max_freq=0, max_len=0;
        int[] hash = new int [26];

        while(r<s.length()){
            hash[s.charAt(r)-'A']++;
            max_freq = Math.max(hash[s.charAt(r)-'A'],max_freq);

            if((r-l+1)-max_freq >k){ 
                // here as usual we can use while also
                // This can be necessary if decrementing the frequency of a character and moving the left pointer l by one is not sufficient 
                // to make the window valid, particularly when the window becomes invalid for multiple consecutive 
                hash[s.charAt(l)-'A']--;
                l++;
            }
            max_len = Math.max(r-l+1, max_len);
            r++;
        }
        return max_len;
    }

    public static void main(String a[]){

    }

}
