class Solution {
    public int calculate(String s) {
       /* todo 

       redo the iteration in a quite environment
       use stack, ArrayDeque<>();
       figure out what poll() pollLast() addLast() poll() of ArrayDeque.

       if (s.length() == 0 || s == null) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int n = s.length();
        int num = 0;
        char operator = '+';
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } 
            
            if (!Character.isDigit(c) && c != ' ') {
                if (operator == '-') {
                    stack.push(-num);
                } else if (operator == '/') {
                    stack.push(stack.pop() / num);
                } else if (operator == '*') {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(num);
                }
                operator = c;
            }
            
        }      
        
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;*/
        
        
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