package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Recursion13 {

    private static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    private static void backtrack(int start, String s, List<String> path, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                path.add(s.substring(start, end + 1));
                backtrack(end + 1, s, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(0, s, path, result);
        return result;
    }

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(partition(s));
    }
}
