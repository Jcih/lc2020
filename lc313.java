class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] idxPrimes = new int[primes.length];
        int counter = 1;
        while (counter < n) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < primes.length; i++) {
                int temp = dp[idxPrimes[i]] * primes[i];
                min = min < temp ? min : temp;
            }
            for (int i = 0; i < primes.length; i++) {
                if (min == dp[idxPrimes[i]] * primes[i]) {
                    idxPrimes[i]++;
                }
            }
            dp[counter] = min;
            counter++;
        }
        return dp[n - 1];
    }
    

}