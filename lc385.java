/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        
        if(s.charAt(0) != '[') {
            return new NestedInteger(Integer.valueOf(s));
        }
        NestedInteger fakeBaba = new NestedInteger();
        int start = 1;
        Stack<NestedInteger> stack = new Stack<>();
        stack.push(fakeBaba);
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '-' || (c <= '9' && c >= '0')) {
                continue;
            }
            if (c == '[') {
                NestedInteger nestedInteger = new NestedInteger();
                stack.peek().add(nestedInteger);
                stack.push(nestedInteger);
            }
            else {
                if('0' <= s.charAt(i-1) && s.charAt(i-1) <= '9') {
                    int num = Integer.valueOf(s.substring(start,i));
                    NestedInteger nestedInteger = new NestedInteger(num);
                    stack.peek().add(nestedInteger);
                }
                if(c == ']') {
                    stack.pop();
                }
            }
            start = i +1;
        }
        return fakeBaba.getList().get(0);
        

    }
}