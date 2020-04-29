//https://blog.csdn.net/styshoo/article/details/53212043

class Solution {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        
        int base = 0;
        for (int i = 0; i < A.length; i++) {
            base += i * A[i];
        }
        
        int max = base;
        for (int i = 1; i < A.length; i++) {
            int sumIndex = -i + A.length;
            base += sum - A.length * A[sumIndex];
            max = (max < base) ? base : max;
        }
        return max;
    }
}