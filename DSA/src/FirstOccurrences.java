import java.util.HashMap;
import java.util.Map;

public class FirstOccurrences {
    public static String findFirstOccurrences(String str1, String str2) {
        // Create a map to store the first occurrence index of each character in str2
        Map<Character, Integer> firstOccurrenceMap = new HashMap<>();
        
        // Initialize the map with -1 as the default value
        for (char c : str2.toCharArray()) {
            firstOccurrenceMap.put(c, -1);
        }
        
        // Find the first occurrence index of each character in str2 in str1
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (firstOccurrenceMap.containsKey(c) && firstOccurrenceMap.get(c) == -1) {
                firstOccurrenceMap.put(c, i);
            }
        }
        
        // Find the minimum and maximum occurrence indices
        int minIndex = Integer.MAX_VALUE;
        int maxIndex = Integer.MIN_VALUE;
        for (char c : str2.toCharArray()) {
            int index = firstOccurrenceMap.get(c);
            if (index != -1) {
                minIndex = Math.min(minIndex, index);
                maxIndex = Math.max(maxIndex, index);
            }
        }
        
        // Extract the substring between the minimum and maximum occurrence indices
        if (minIndex != Integer.MAX_VALUE && maxIndex != Integer.MIN_VALUE) {
            return str1.substring(minIndex, maxIndex + 1);
        } else {
            return ""; // If no occurrences found, return an empty string
        }
    }
    
    public static void main(String[] args) {
        // Test case
        String str1 = "ZOHOCORPORATION";
        String str2 = "PORT";
        System.out.println("O/P: " + findFirstOccurrences(str1, str2));  // Output: OHOCORPORAT
    }
}
