class Solution {
    public int countPrimes(int n) {
        
        int count = 0;
        boolean[] isPrime = new boolean[n];
        
        
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        //The Sieve of Eratosthenes uses an extra O(n) memory and its runtime complexity is O(n log log n)
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
    
        return count;
    }
    
}


//Solution I  Brute force
class Solution {
    public int countPrimes(int n) {
       
        
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }
    private boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
}