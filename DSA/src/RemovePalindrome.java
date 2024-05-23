import java.util.ArrayList;
import java.util.List;

public class RemovePalindrome {
    
    public static boolean isPalindrome(String word) {
        return word.equals(new StringBuilder(word).reverse().toString());
    }
    
    public static String removePalindromes(String sentence) {
        String[] words = sentence.split("\\s+");
        List<String> nonPalindromeWords = new ArrayList<>();
        
        for (String word : words) {
            if (!isPalindrome(word)) {
                nonPalindromeWords.add(word);
            }
        }
        
        return String.join(" ", nonPalindromeWords);
    }

    public static void main(String[] args) {
        String input1 = "He did a good deed";
        String output1 = removePalindromes(input1);
        System.out.println(output1);  // Output: He good

        String input2 = "Hari speaks malayalam";
        String output2 = removePalindromes(input2);
        System.out.println(output2);  // Output: Hari speaks
    }
}
