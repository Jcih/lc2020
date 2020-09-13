//https://zhang0peter.com/2020/02/06/LeetCode-309-Best-Time-to-Buy-and-Sell-Stock-with-Cooldown/
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        /**
         there can be two types of profit we need to track
         sellProf[i] - profit earned by selling on ith day
         restProf[i] - profit earned by resting on ith day
         */
        int sellProf = 0;
        int restProf = 0;
        int lastProf = 0;
        for (int i = 1; i < prices.length; i++) {
            lastProf = sellProf;
            //the current sellProf is either by selling on ith day or by resting on ith day
            sellProf = Math.max(sellProf + prices[i] - prices[i - 1], restProf);
            restProf = Math.max(lastProf, restProf);
        }
        return Math.max(sellProf, restProf);
    }
}


//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75927/Share-my-thinking-processpublic int maxProfit(int[] prices) {
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        
        int sell = 0;
        int prev_sell = 0;
        int buy = Integer.MIN_VALUE;
        int prev_buy;
        
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
}