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




//Solution II
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        int res = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {  //  != 0 or  == 1, both works.  (n & mask) should have ()
                res++;
            }
            //mask = mask << 1;
            n = n >> 1;
        }
        return res;
    }
}