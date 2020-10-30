//https://leetcode.com/problems/longest-string-chain/discuss/294890/C%2B%2BJavaPython-DP-Solution
//similar solution  300
class Solution {
    public int longestStrChain(String[] words) {
        // sort from small to large
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        //key: word, value: longest chain number
        Map<String, Integer> dp = new HashMap<>();
        int res = 0;
        for (String word : words) {
            int maxLen = 0;
            
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                maxLen = Math.max(maxLen, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, maxLen);
            res = Math.max(res, maxLen);
        }
        return res;
    }
}