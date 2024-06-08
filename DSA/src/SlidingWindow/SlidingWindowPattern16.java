// minimum window substring
public class SlidingWindowPattern16 {
    public String minWindow(String s, String t) {
        int l=0, r=0, min_len=Integer.MAX_VALUE;
        int count=0, start_index= -1;
        int[] hash = new int [256];

        for(int i=0; i<t.length(); ++i)
            hash[t.charAt(i)]++;

        while(r < s.length()){
            if(hash[s.charAt(r)]>0)
                count ++;
            hash[s.charAt(r)]--;

            while(count == t.length()){
                if((r-l+1)<min_len){
                    min_len = r-l+1;
                    start_index = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0)
                    count --;
                l++;
            }
            r++;
        }
        return start_index == -1 ? "" : s.substring(start_index, start_index+min_len);
    }
}
