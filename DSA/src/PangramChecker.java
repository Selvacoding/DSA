public class PangramChecker {
    public static boolean isPangram(String sentence) {
        // Create a string containing all English alphabets
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        // Convert the sentence to lowercase to make the comparison case-insensitive
        sentence = sentence.toLowerCase();
        
        // Iterate through each character of the alphabet
        for (char c : alphabet.toCharArray()) {
            // Check if the character is not present in the sentence
            if (sentence.indexOf(c) == -1) {
                return false;
            }
        }
        
        // If all characters are found, return true
        return true;
    }
    
    public static void main(String[] args) {
        // Test cases
        String input1 = "abc defGhi JklmnOP QRStuv wxyz";
        String input2 = "abc defGhi JklmnOP QRStuv";
        
        System.out.println("O/P: " + isPangram(input1));  // Output: true
        System.out.println("O/P: " + isPangram(input2));  // Output: false
    }
}

