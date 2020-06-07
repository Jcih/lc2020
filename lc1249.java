//https://www.youtube.com/watch?v=thL70BR3yMA&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=176
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        
        int open = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;   
            } else if (c == ')') {
                if (open == 0) continue;
                open--;
            }
            sb.append(c);
        }
        
        StringBuilder res = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '(' && open > 0) {
                open--;
                continue;
            }
            res.append(sb.charAt(i));
            //res.insert(0, sb.charAt(i));
        }
        //return res.toString();
        return res.reverse().toString();
        
    }
}