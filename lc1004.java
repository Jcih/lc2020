//https://leetcode.com/problems/max-consecutive-ones-iii/discuss/247564/JavaC%2B%2BPython-Sliding-Window
/**
More Similar Sliding Window Problems
Here are some similar sliding window problems.
Also find more explanations.
Good luck and have fun.

1248. Count Number of Nice Subarrays
1234. Replace the Substring for Balanced String
1004. Max Consecutive Ones III
930. Binary Subarrays With Sum
992. Subarrays with K Different Integers
904. Fruit Into Baskets
862. Shortest Subarray with Sum at Least K
209. Minimum Size Subarray Sum
340. Longest Substring with At Most K Distinct Characters 
*/
class Solution {
    public int longestOnes(int[] A, int K) {
        int i = 0;
        int j;
        for (j = 0; j < A.length; j++) {
            if (A[j] == 0) K--;
            if (K <  0 && A[i++] == 0) {
                K++;
                //i++;
            }
        }
        return j - i;
    }
}


//https://www.youtube.com/watch?v=97oTiOCuxho
//easy understand
class Solution {
    public int longestOnes(int[] A, int K) {
        int i = 0;
        int j = 0;
        while (i < A.length) {
            if (A[i] == 0)
                K--;
            if (K < 0) {
                if (A[j] == 0) {
                    K++;
                }
                j++;
            }
            i++;
        }
        return i - j;
    }
}