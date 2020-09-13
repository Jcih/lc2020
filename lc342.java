class Solution {
    public boolean isPowerOfFour(int num) {
        while (num >= 4) {
            if (num % 4 == 0) {
                num = num / 4;
            } else {
                return false;
            }
        }
        
        if (num == 1) {
            return true;
        } else {
            return false;
        }
    }
}


//Solution II, same way with power of 3
class Solution {
    public boolean isPowerOfFour(int num) {
        if (num < 1)
            return false;
        while (num % 4 == 0) {
            num /= 4;
        }
        
        return num == 1;
    }
}

//Solution III
public boolean isPowerOfFour(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position 
    }