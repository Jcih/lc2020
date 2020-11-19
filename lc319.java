
//Time exceed
class Solution {
    public int bulbSwitch(int n) {
        if (n <= 1) return n;
        
        //round 1  n on
        //round 2
        
        if (n == 2) return 1;
        
        boolean[] on = new boolean[n + 1];
        
        //round 2 
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                on[i] = true;
            }
        }          
        
        for (int i = 3; i <= n; i++) {
            
            int time = n / i;
            for (int j = 1; j <= time; j++) {
                on[j * i] = !on[j * i];
            }   
            
        }
        
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (on[i]) res++;
        }
        
        
        return res;
        
    }
}

// Accepted
class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}