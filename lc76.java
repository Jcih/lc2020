//https://www.youtube.com/watch?v=9qFR2WQGqkU
//20201009
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() < t.length()) return "";
        Map<Character, Integer> wordDict = new HashMap<>();
        for (char c : t.toCharArray()) {
            wordDict.put(c, wordDict.getOrDefault(c, 0) + 1);
        }
        
        int left = 0;
        int right = 0;
        int len = s.length();
        int matchCount = 0;
        int minLen = Integer.MAX_VALUE;
        int index = 0;
        for (int ritght = 0; right < len; right++) {
            char ch = s.charAt(right);
            Integer count = wordDict.get(ch);
            if (count == null) continue;
            wordDict.put(ch, count - 1);
            if (count == 1) {
                // match character
                matchCount++;
            }
            
            while (matchCount == wordDict.size()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    index = left;
                }
                char leftMost = s.charAt(left);
                left++;
                Integer leftCount = wordDict.get(leftMost);
                if (leftCount == null) continue;
                wordDict.put(leftMost, leftCount + 1);
                if (leftCount == 0) {
                    matchCount--;
                }
            }
           
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(index, index + minLen);
    }
}