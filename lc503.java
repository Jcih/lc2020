/**
More Good Stack Problems
Here are some problems that impressed me.
Good luck and have fun.

1130. Minimum Cost Tree From Leaf Values
1019. Next Greater Node In Linked List
907. Sum of Subarray Minimums
901. Online Stock Span
856. Score of Parentheses
503. Next Greater Element II
496. Next Greater Element I
84. Largest Rectangle in Histogram
42. Trapping Rain Water
*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len * 2; i++) {
            
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                res[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }
        return res;
    }
}