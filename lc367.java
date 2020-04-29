
//binary search

class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 0;
        long right = num;
        long mul = 0;
        
        while (left <= right) {
            long mid = (right + left) / 2;
            mul = mid * mid;
            if (mul < num) {
                left = mid + 1;
            } else if (mul > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
        
    }
}