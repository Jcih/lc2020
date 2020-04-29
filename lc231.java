class Solution {
    public boolean isPowerOfTwo(int n) {
        /*
        int m = 1;
        
        for (int i = 0; i < n; i++) {
            if (m < n) {
                m *= 2;
            } else if (m == n) {
                return true;
            } else {
                return false;
            }
        }
        
        return false;*/
        if (n == 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        return isPowerOfTwo(n/2);
        
    }
}