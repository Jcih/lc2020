class Solution {
    public int calculate(String s) {
        
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }

            if ((!Character.isDigit(s.charAt(i))) && ' ' != s.charAt(i) || i == len - 1) {
                if (sign == '+') {
                    stack.addLast(num);
                } else if (sign == '-') {
                    stack.addLast(-num);
                } else if (sign == '/') {
                    stack.addLast(stack.pollLast() / num);

                } else if (sign == '*') {
                    stack.addLast(stack.pollLast() * num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.poll();
        }
        return result;
    }
}



//Solution II
class Solution {
    public int calculate(String s) {
        
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                    
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                
                sign = c;
                num = 0;
            }
            
        }
        
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        
        return res;
    }
}