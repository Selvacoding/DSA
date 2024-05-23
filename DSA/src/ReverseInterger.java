class Solution {
    public int reverse(int x) {
        int res = 0;
        while(x != 0){
            int rem = x % 10;
            int new_res = res * 10 + rem;
            if((new_res-rem)/10 != res)
                return 0;
            res = new_res;
            x /= 10;
        }
        return res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.print(s.reverse(120));
    }
}