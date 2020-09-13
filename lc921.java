//自己做出来的，牛逼
//20200709
class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        int res = 0;
        for (Character c : S.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else {
                if (stack.isEmpty()) {
                    res++;
                } else {
                    stack.pop();
                    //res++;
                }
            }
        }
        
        while (!stack.isEmpty()) {
            stack.pop();
            res++;
        }
        return res;
    }
}

//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/discuss/181132/C%2B%2BJavaPython-Straight-Forward-One-Pass
class Solution {
    public int minAddToMakeValid(String S) {
        int left = 0, right = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                right++;
            } else if (right > 0) {
                right--;
            } else {
                left++;
            }
        }
        return left + right;
    }
}