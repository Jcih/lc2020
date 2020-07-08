// https://www.programcreek.com/2014/04/leetcode-letter-combinations-of-a-phone-number-java/
class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return res;
        res.add("");
        
        for (int i = 0; i < digits.length(); i++) {
            String s1 = map.get(digits.charAt(i));
            ArrayList<String> tmp = new ArrayList<>();
            for (int j = 0; j < res.size(); j++) {
                for (int p = 0; p < s1.length(); p++) {
                    tmp.add(new StringBuilder(res.get(j)).append(s1.charAt(p)).toString());
                }
            }
            res.clear();
            res.addAll(tmp);
        }
        return res;
    }
}

//https://www.youtube.com/watch?v=21OuwqIC56E
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return res;
        String[] mapping = {
            "0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };

        helper(res, digits, "", 0, mapping);
        return res;
    }
    private void helper(List<String> res, String digits, String cur, int idx, String[] mapping) {
        if (idx == digits.length()) {
            res.add(new String(cur));
            return;
        }

         String str = mapping[digits.charAt(idx) - '0'];
        for (int i = 0; i < str.length(); i++) {
            
            //cur = cur + str.charAt(i);
            helper(res, digits, cur + str.charAt(i), idx + 1, mapping);
            //cur = cur.substring(0, cur.length() - 2);
        }
    }
}