
//Solution I

//O(n) = n * sizeOf(Integer)
class Solution {
    public int[] countBits(int num) {
        
        if (num == 0) return new int[1];
        
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            //int count = 0;
            
            //calculate 1s in i;
            
            res[i] = Integer.bitCount(i);
        }
        
        return res;
    }
}


//Solution II
class Solution {
    public int[] countBits(int num) {    
        int[] res = new int[num + 1];
        res[0] = 0;
        
        int base = 1;
        while (base <= num) {
            int next = base * 2;
            for (int i = base; i < next && i <= num; i++) {
                res[i] = res[i - base] + 1;
            }
            base = next;
        }
        return res;

    }
}

//Solution III
class Solution {
    public int[] countBits(int num) {    
        int[] res = new int[num + 1];
        res[0] = 0;
        
        for (int i = 0; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;

    }
}