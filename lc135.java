class Solution {
    public int candy(int[] ratings) {
        if (ratings == null) return 0;
        if (ratings.length == 1) return 1;
        
        int[] count = new int[ratings.length];
        Arrays.fill(count, 1);
        
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            }
        }
        
        for (int i = ratings.length - 1; i > 0; i--) {
            
            if (ratings[i - 1] > ratings[i]) {
                count[i - 1] = Math.max(count[i] + 1, count[i - 1]);
            }
            
        }
        
        int res = 0;
        for (int item : count) {
            res += item;
        }
        return res;
    }
}