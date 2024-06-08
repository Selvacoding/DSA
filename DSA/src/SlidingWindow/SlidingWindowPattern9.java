import java.util.*;

// find the longest substring with atmost k distinct charcters
public class SlidingWindowPattern9 {
    public static void main(String[] args) {
        String s ="aaabbccd";
        int  k=2;
        
        int l=0, r=0,  maxlen=0;
        Map<Character,Integer> map = new HashMap<>();
        
        while(r<s.length()){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            if(map.size()>2){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            if(k>=map.size())
                maxlen = Math.max(maxlen, r-l+1);
            r++;
        }
        System.out.println(" anwer =>"+maxlen);
    }
}
