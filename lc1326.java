//1326

// == 1024
class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
             
        for (int i = 0; i <= n; i++) {
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            for (int j = left + 1; j <= right; j++) {
                dp[j] = Math.min(dp[j], dp[left] + 1);
            }
        }
        return dp[n] == n + 1 ?  - 1: dp[n];
        
    }
}


//greedy
//https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/discuss/506853/Java-A-general-greedy-solution-to-process-similar-problems
// jump game II
class Solution {
    public int minTaps(int n, int[] ranges) {
        //construct the array like jump game II 
        int[] arr = new int[n + 1];
        for (int i =0 ;i < ranges.length; i++) {
            if (ranges[i] == 0) continue;
            int left = Math.max(0, i - ranges[i]);
            arr[left] = Math.max(arr[left], i + ranges[i]);
        }
        
        //Same solution with Jump Game II
        int end = 0, farCanReach = 0, count = 0;
        for (int i = 0; i < arr.length && end < n; end = farCanReach) {
            count++;
            while (i < arr.length && i <= end) {
                farCanReach = Math.max(farCanReach, arr[i]);
                i++;
            }
            if (end == farCanReach) return -1;
        }
        return count;
    }

    
}