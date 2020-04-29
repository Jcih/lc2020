class Solution {
    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxLen = 0;
        stack.push(0);
        for (String s : input.split("\n")) {
            int lev = s.lastIndexOf("\t") + 1; // get \t number as level
            while (lev + 1 < stack.size()) stack.pop();
            
            int len = stack.peek() + s.length() - lev + 1;
            stack.push(len);
            if (s.contains(".")) maxLen = Math.max(maxLen, len - 1);
        }
        return maxLen;
        
    }
}