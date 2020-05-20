//Apple
//https://www.youtube.com/watch?v=rnwmE9m9EMM
class Solution {
    public int balancedStringSplit(String s) {
        int res = 0;
        int count = 0;
        for (Character c : s.toCharArray()) {
            if(c == 'L') {
                count++;
            } else if(c == 'R') {
                count--;
            }
            if (count == 0) {
                res++;
            }
        }
        return res;
    }
}