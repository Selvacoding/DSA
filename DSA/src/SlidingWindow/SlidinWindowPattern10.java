
//  find the no of substring which is having all the 3 characters 

public class SlidinWindowPattern10 {
    public static void main(String[] args) {
        String s ="bbacba";
        
        int l=0, r=0, count=0;
        int[] hash = new int [3];
        
        while(r< s.length()){
            hash[s.charAt(r)-'a']++;
            if(hash[0]>0 && hash[1] >0 && hash[2]> 0){
                count += s.length()-r; 
                hash[s.charAt(l)-'a']--;
                l++;
            }
            r++;
        }
        System.out.println(count);
        main2();
    }
    public static void main2() {
    String s = "bbacba";

    // This array will store the latest indices of characters 'a', 'b', and 'c'
    int[] hash = { -1, -1, -1 };
    int count = 0;

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        // Update the hash array with the latest index of the characters 'a', 'b', and 'c'
        switch (c) {
            case 'a' -> hash[0] = i;
            case 'b' -> hash[1] = i;
            case 'c' -> hash[2] = i;
        }

        // If all three characters have been seen at least once
        if (hash[0] != -1 && hash[1] != -1 && hash[2] != -1) {
            // The minimum index among the latest occurrences of 'a', 'b', and 'c'
            int minIndex = Math.min(hash[0], Math.min(hash[1], hash[2]));
            // Every substring that starts from any previous position to minIndex and ends at i
            // will contain at least one of each 'a', 'b', and 'c'
            count += (minIndex + 1);
        }
    }
    System.out.println(count);
    }
}
