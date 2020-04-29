class Solution {
    public String decodeString(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();
        
        StringBuilder sbRes = new StringBuilder();
        
        int size = s.length();
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < size && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                numStack.push(num);
            } else if (c == '[') {
                strStack.push(sbRes.toString());
                sbRes = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder(strStack.pop());
                int repeatTimes = numStack.pop();
                for (int j = 0; j < repeatTimes; j++) {
                    tmp.append(sbRes.toString());
                }
                sbRes = tmp;
            } else {
                sbRes.append(c);
            }
        }
        return sbRes.toString();
        
    }
}