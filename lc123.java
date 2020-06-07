class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }
        
        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
            
        }
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, left[i] + right[i]);
            
        }
        return profit;
    }
}


//
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        
        
        //calculate left
        int min_buy = Integer.MAX_VALUE;
        int profit_left = 0;
        for (int i = 0; i < prices.length; i++) {
            min_buy = Math.min(min_buy, prices[i]);
            profit_left = Math.max(profit_left, prices[i] - min_buy);
            left[i] = profit_left;
        }
        
        //calculate right
        int max_sell = Integer.MIN_VALUE;
        int profit_right = 0;
        for (int j = prices.length - 1; j >= 0; j--) {
            max_sell = Math.max(max_sell, prices[j]);
            profit_right = Math.max(profit_right, max_sell - prices[j]);
            right[j] = profit_right;
        }
 
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }
        
        return profit;
    }
}