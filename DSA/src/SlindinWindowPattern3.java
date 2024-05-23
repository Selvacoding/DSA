// given a cards we ahve to pick k card but it should either from start or end or mixed of start and end
//  but you should not pick it from the middle
public class SlindinWindowPattern3 {
    public static void main(String[] args) {
        int[] a = {6,2,3,4,7,2,1,7,1};
        int k=4;
        
        int lsum =0, rsum=0, maxsum, n=a.length;
        
        for(int i=0;i<k;i++){
            lsum+=a[i];
        }
        maxsum =lsum;
        int rindex = n-1;
        for(int i=k-1; i>=0;--i){
            lsum -= a[i];
            rsum +=a[rindex];
            rindex--;
            maxsum = Math.max(maxsum, lsum+rsum);
        }

        System.out.println(maxsum);
    }
}
