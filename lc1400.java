//https://leetcode.com/problems/construct-k-palindrome-strings/discuss/563379/JavaC%2B%2BPython-Straight-Forward
class Solution {
    public boolean canConstruct(String s, int k) {
        int odd = 0;
        int n = s.length();
        int[] arr = new int[26];
        
        for (char c : s.toCharArray()) {
            arr[c - 'a'] ^= 1;//?
            odd += arr[c - 'a'] > 0 ? 1 : -1;
            
        }
        return odd <= k && k <= n;
        
    }
}

//


class Solution {
    public boolean canConstruct(String s, int k) {
        int odd = 0;
        int n = s.length();
        int[] arr = new int[26];
        
        //count number of odd charss
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        
        for (int i : arr) {
            if (i % 2 == 1) odd++;
        }
        
        return odd <= k && k <= n;
        
    }
}