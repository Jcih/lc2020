//https://www.youtube.com/watch?v=9Q73ScVu2GI
//Google
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int minSwaps = Math.min(numSwap(A[0], A, B), numSwap(B[0], A, B));
        minSwaps = Math.min(minSwaps, numSwap(A[0], B, A));
        minSwaps = Math.min(minSwaps, numSwap(B[0], B, A));
        return minSwaps == Integer.MAX_VALUE ? -1 : minSwaps;
    }
    public int numSwap(int target, int[] A, int[] B) {
        int numSwap = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i]  != target && B[i] != target) {
                return Integer.MAX_VALUE;
                
            } else if (A[i] != target) {
                numSwap++;
            }
        }
        
        return numSwap;
    }
}