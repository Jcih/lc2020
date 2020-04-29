class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z > x + y) {
            return false;
        }
        if (z == 0) {
            return true;
        }
        
        int res = gcd(x, y);
        return z % res == 0;
    }


    //greatest common divisor, recursive
    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}