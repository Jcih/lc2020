class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        if (time == null || time.length == 0) return 0;
        
        int[] remainder = new int[60];
        int count = 0;
        for (int i : time) {
            if (i % 60 == 0) {
                count += remainder[0];
            } else {
                count += remainder[60 - i % 60];
            }
            
            remainder[i % 60]++;
        }
        return count;
    }
}