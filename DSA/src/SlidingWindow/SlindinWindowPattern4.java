import java.util.*;

//  Longest substring without repeating charcters
public class SlindinWindowPattern4 {
    public static void main(String[] args) {
        String s = "cadbzabcd";
        int l = 0, r = 0, n = s.length();
        int max_length = 0;
        Map<Character, Integer> seen = new HashMap<>();
        while (r < n) {
            if (seen.containsKey(s.charAt(r))) {
                l = Math.max(seen.get(s.charAt(r)) + 1, l);
            }
            seen.put(s.charAt(r), r);
            max_length = Math.max(max_length, r - l + 1);
            r++;
        }
        System.out.println(max_length);
    }

    public static void main2(String[] args) {
        String s = "cadbzabcd";
        int l = 0, r = 0, n = s.length();
        int max_length = 0;
        Map<Character, Integer> seen = new HashMap<>();
        while (r < n) {
            if (!seen.containsKey(s.charAt(r))) {
                seen.put(s.charAt(r), r);
            } else {
                if (seen.get(s.charAt(r)) >= l) {
                    l = seen.get(s.charAt(r)) + 1;
                }
            }
            max_length = Math.max(max_length, r - l + 1);
            r++;
        }
        System.out.println(max_length);
    }

    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int [] count = new int [128];
        for (int l=0,r=0;r<s.length();r++){
            ++count[s.charAt(r)];
            while (count[s.charAt(r)] > 1)
             --count[s.charAt(l++)];
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}
