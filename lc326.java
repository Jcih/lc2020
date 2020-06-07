class Solution {
    public boolean isPowerOfThree(int n) {
        
        if (n == 1) return true;
        
        while (n > 0) {
            int m = n % 3;
            if (m == 0) {
                n = n / 3;
                if (n == 1) return true;
            } else {
                return false;
            }
        }
        
        return false;
    }
}



//Solution II
class Solution {
    public boolean isPowerOfThree(int n) {
       if (n < 1)
           return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        
        return n == 1;
        
        
    }
} 