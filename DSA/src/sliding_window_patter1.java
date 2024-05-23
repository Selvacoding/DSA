// Online Java Compiler
// Use this editor to write, compile and run your Java code online
// static window
class HelloWorld {
    public static void main(String[] args) {
        int a[] = {-1,2,3,4,5,-1};
        int k=4;
        int n =a.length;
        int l=0;
        int r = k-1;
        int sum =0;
        int max_sum =0;
        
        for(int i=0; i<=r;i++){
            max_sum += a[i]; 
        }
        
        sum = max_sum;
        while(r<n-1){
           sum -= a[l];
           l++;
           r++;
           sum +=a[r];
           max_sum = Math.max(max_sum,sum);
        }
        System.out.print(max_sum);
    }
}