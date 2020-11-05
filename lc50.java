class Solution {
    public double myPow(double x, int n) {
        
        
        if (n == 0) return 1.0;
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double res = 1.0;
        for (long i = 0; i < N; i++) {
            res = res * x;
        }
        
         
        return res;
        
    }
}


//Solution II
class Solution {
    public double myPow(double x, int n) {
        
        
        if (n == 0) return 1.0;
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double res = 1.0;
        double cur_prod = x;
        
        for (long i = N; i > 0; i /= 2) {
            
            if ((i % 2) == 1) {
                res = res * cur_prod;
            }
            
            cur_prod = cur_prod * cur_prod;
        }
        
         
        return res;
        
    }
}