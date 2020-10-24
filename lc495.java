//20201014
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        if (timeSeries == null || timeSeries.length == 0) return 0;
        if (timeSeries.length == 1) return duration;
        
        int len = timeSeries.length;
        for (int i = 1; i < len; i++) {
            if (timeSeries[i - 1] + duration < timeSeries[i]) {
                res += duration;
            } else {
                res = res + timeSeries[i] - timeSeries[i - 1];
            }
        }
        return res + duration;
    }
}