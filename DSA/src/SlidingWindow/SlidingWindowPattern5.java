// consecutive ones we can flip k zero to get maximum consecutive ones

public class SlidingWindowPattern5 {
    public static void main(String[] args) {
         int [] a = {1,1,1,0,0,0,1,1,1,1,0};
         int k=2;
         
         int l=0, r=0, zero_count =0, max_len=0;
         
         while(r<a.length){
            if(a[r] == 0)
                zero_count++;
            if (zero_count > k) { // here if we put while T.C will be O(N+N)
                // so I put if to reduce the zero_count
                // so for example try to debug this [1,1,1,1,0,0,0] you will know why if is better
                if(a[l]==0){
                    zero_count--;
                }
                l++;
            }
            if(zero_count<=k)
                max_len=Math.max(max_len, r-l+1);
            
            r++;
        }
        System.out.println(max_len);
    }
}
