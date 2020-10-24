//20200924

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        if (cardPoints == null || cardPoints.length == 0) return 0;
        
        int res = 0;
        int sum = 0;
        
        int[] left = new int[k + 1];
        int[] right = new int[k + 1];
        
        left[0] = 0;
        right[k] = 0; 
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
            left[i + 1] = sum;
        }
        
        sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[cardPoints.length - i - 1];
            right[i + 1] = sum;
        }
        
        for (int i = 0; i <= k; i++) {
            res = Math.max(res, left[i] + right[k - i]);
        }
        return res;
        
    }
}