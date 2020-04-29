class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new LinkedList<>();
        int len = input.length();
        for (int i = 0; i < len; i++) {
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> ans1 = diffWaysToCompute(part1);
                List<Integer> ans2 = diffWaysToCompute(part2);
                for (int a1 : ans1) {
                    
                    for(int a2 : ans2) {
                        int res = 0;
                        switch (input.charAt(i)) {
                            case '+':
                                res = a1 + a2;
                                break;
                            case '-':
                                res = a1 - a2;
                                break;
                            case '*':
                                res = a1 * a2;
                                break;
                            default:
                                break;
                        }
                        ans.add(res);
                    }
                    
                    
                }
            }
        }
        if (ans.size() == 0)
            ans.add(Integer.valueOf(input));
        return ans;
    }
}