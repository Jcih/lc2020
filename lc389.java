class Solution {
    public char findTheDifference(String s, String t) {
        
        char c = 0;
        int i = 0;
        int n = t.length();
        
        while (i < n - 1) {
            c += t.charAt(i) - s.charAt(i);
            i++;
        }
        
        c += t.charAt(n - 1);
        return c;
    }
}


//Solution II
class Solution {
    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        char res = 0;
        
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        
        for (char c : t.toCharArray()) {
            arr[c - 'a']--;
            if (arr[c - 'a'] == -1)
                return c;
        }
        
        return res;
    }
}


//Solution III
class Solution {
    public char findTheDifference(String s, String t) {
        char res = 0;
        
        for (char c : s.toCharArray()) {
            res ^= c;
        }
        for (char c : t.toCharArray()) {
            res ^= c;
        }
        
        return res;
    }
}