//https://github.com/fishercoder1534/Leetcode/blob/master/src/main/java/com/fishercoder/solutions/_371.java
//https://www.polarxiong.com/archives/LeetCode-371-sum-of-two-integers.html
class Solution {
    public int getSum(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return getSum(sum, carry);
    }
}