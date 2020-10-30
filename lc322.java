
//https://www.youtube.com/watch?v=1R0_7HqNaW0
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];//why amount + 1, because we start from 0 , to amount, so total is amount + 1
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;//initiate the first case
        
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return dp[amount] > amount ? - 1 : dp[amount];
    }
}


//20201029
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        Arrays.fill(dp, amount + 1);
        
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                } else {
                    break;
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
        
    }
    
}