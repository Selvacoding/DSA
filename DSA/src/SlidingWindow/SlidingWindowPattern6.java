import java.util.HashMap;
import java.util.Map;

public class SlidingWindowPattern6 {
    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0, max_len = 0;
        while (r < fruits.length) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            if (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            if (map.size() <= 2)
                max_len = Math.max(max_len, r - l + 1);
            r++;
        }
        return max_len;
    }
    public static void main(String[] args) {
        
    }
}

