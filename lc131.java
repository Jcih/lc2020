// classic backtrack and palindrome method
// similar with #46. #93
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(res, new ArrayList<String>(), s);
        return res;
    }
    
    public void helper(List<List<String>> res, List<String> cur, String s) {
        if (s.length() == 0) {
            if (cur.size() > 0) {
                res.add(new ArrayList<String>(cur));
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            if(isPalindrome(s, 0, i)) {
                String part = s.substring(0, i + 1);
                cur.add(part);
                helper(res, cur, s.substring(i + 1));
                cur.remove(cur.size() - 1);//？？？why
            }
        }
    }
    

    //isPalindrome
    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}