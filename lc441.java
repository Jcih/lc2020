class Solution {
    public int arrangeCoins(int n) {
        if (n <= 1)
            return n;
        
        int i= 1;
        while (n >= 0) {
            n -= i;
            i++;
        }
        return i - 2;
    }
}