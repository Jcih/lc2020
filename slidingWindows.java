


//Sliding Window
// https://leetcode.com/problems/minimum-window-substring/
// https://leetcode.com/problems/longest-substring-without-repeating-characters/

// https://leetcode.com/problems/find-all-anagrams-in-a-string/



//76. Minimum Window Substring
//https://www.youtube.com/watch?v=9qFR2WQGqkU
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() < t.length()) return "";
        Map<Character, Integer> wordDict = new HashMap<>();
        for (char c : t.toCharArray()) {
            wordDict.put(c, wordDict.getOrDefault(c, 0) + 1);
        }
        
        
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int matchCount = 0;
        int index = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            Integer count = wordDict.get(ch);
            if (count == null) continue;
            wordDict.put(ch, count - 1);
            
            if (count == 1) {
                matchCount++;
            }
            
            while (matchCount == wordDict.size()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    index = left;
                }
                
                char leftMost = s.charAt(left);
                left++;
                Integer leftMostCount = wordDict.get(leftMost);
                if (leftMostCount == null) continue;
                wordDict.put(leftMost, leftMostCount + 1);
                if (leftMostCount == 0) {
                    matchCount--;
                }
            }
            
            
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(index, index + minLen);
     }
}

// when using hashmap in interview, have to explain what's Key stands, what's Value stands





//3. Longest Substring Without Repeating Characters
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = 0;
        
        HashSet<Character> set = new HashSet<>();
        
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
            
    }
}

// https://leetcode.com/problems/substring-with-concatenation-of-all-words/
// https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
// https://leetcode.com/problems/find-all-anagrams-in-a-string/

//438.Find All Anagrams in a String
//SOlution III sliding window by two arrays 
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() < p.length()) return res;
        int[] phash = new int[26];
        int[] shash = new int[26];
        int window = p.length();
        int left = 0;
        int right = 0;
        
        while (right < window) {
            phash[p.charAt(right) - 'a']++;
            shash[s.charAt(right) - 'a']++;
            right++;
        }
        
        right--;
        while (right < s.length()) {
            if (Arrays.equals(phash, shash)) {
                res.add(left);
            }
            right++;
            if (right != s.length()) {
                shash[s.charAt(right) - 'a']++;
            }
            shash[s.charAt(left) - 'a']--;
            left++;

        }
        return res;
    
    }
}