public class PasswordStrengthChecker {
    public static String getPasswordStrength(String password) {
        // Rule 1: At least one uppercase letter
        boolean rule1 = !password.equals(password.toLowerCase());
        
        // Rule 2: At least one lowercase letter
        boolean rule2 = !password.equals(password.toUpperCase());
        
        // Rule 3: At least one digit
        boolean rule3 = password.matches(".*\\d.*");
        
        // Rule 4: At least one special character
        boolean rule4 = password.matches(".*[!@#$%^&*()_+{}|:<>?].*");
        
        // Count how many rules are satisfied
        int satisfiedRules = 0;
        if (rule1) satisfiedRules++;
        if (rule2) satisfiedRules++;
        if (rule3) satisfiedRules++;
        if (rule4) satisfiedRules++;
        
        // Determine the strength based on the number of satisfied rules
        if (satisfiedRules == 1 || password.length() < 8) {
            return "Weak";
        } else if (satisfiedRules == 2) {
            return "Medium";
        } else if (satisfiedRules == 3) {
            return "Good";
        } else {
            return "Strong";
        }
    }
    
    public static void main(String[] args) {
        // Test cases
        String input1 = "Qw!1";
        String input2 = "Qwertyuiop";
        String input3 = "QwertY123";
        String input4 = "Qwerty@123";
        
        System.out.println("O/P: " + getPasswordStrength(input1));  // Output: Weak
        System.out.println("O/P: " + getPasswordStrength(input2));  // Output: Medium
        System.out.println("O/P: " + getPasswordStrength(input3));  // Output: Good
        System.out.println("O/P: " + getPasswordStrength(input4));  // Output: Strong
    }
}
