class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int tmp = 0;
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int o1 = Integer.valueOf(stack.pop());
                int o2 = Integer.valueOf(stack.pop());
                
                if (s.equals("+")) {
                    tmp = o2 + o1;
                }
                if (s.equals("-")) {
                    tmp = o2 - o1;
                }
                if (s.equals("*")) {
                    tmp = o2 * o1;
                }
                if (s.equals("/")) {
                    tmp = o2 / o1;
                }
                stack.push(tmp);
                
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        
        
        return stack.pop();
    }
}