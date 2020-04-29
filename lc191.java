public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {  // why != 0. not == 1??
                res++;
            }
        }
        return res;
    }
}