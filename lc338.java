
//Solution I
// using function
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


//bitwise  DP
//https://leetcode.com/problems/counting-bits/discuss/270693/Intermediate-processsolution-for-the-most-voted-solution-i.e.-no-simplificationtrick-hidden
//more readable codes
class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;

        for (int i = 1; i <= num; i++) { 
            if ((i & 1) == 0) {   // i is even, the last digit is 0     i & 1 = i % 2 memorize
                // so the number of 1 is same with res[i >> 1]
                res[i] = res[i >> 1];
            } else {
                // i is odd, the last digit is 1
                // the number of 1 is which of res(num-1) + 1
                //num:     101010101011
                //num - 1: 101010101010
                res[i] = res[i - 1] + 1;
            }
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
//dp
//https://leetcode.com/problems/counting-bits/discuss/79539/Three-Line-Java-Solution

class Solution {
    public int[] countBits(int num) {    
        int[] res = new int[num + 1];
        res[0] = 0;
        
        //f[binary string without the last bit] + last bit is 1 or not
        for (int i = 0; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);// i >> 1 = i/2, i & 1 = i % 2
        }
        return res;

    }
}

