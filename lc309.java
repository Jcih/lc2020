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