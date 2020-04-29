class Solution {
    public int trailingZeroes(int n) {
       int res = 0;
        // 25! has 6 zeros, from 5, 10, 15, 20, 25(2).
        while (n > 4) {
            n /= 5;
            res += n;
        }
        return res;
          
    }
}