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