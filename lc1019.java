//https://www.youtube.com/watch?v=wVsGnpXoxPI

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> node_vals = new ArrayList<>();
        
        ListNode cur = head;
        while (cur != null) {
            node_vals.add(cur.val);
            cur = cur.next;
        }
        
        int[] res = new int[node_vals.size()];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < node_vals.size(); i++) {
            
            //tricky part, important
            while (!stack.isEmpty() && node_vals.get(stack.peek()) < node_vals.get(i)) {
                res[stack.pop()] = node_vals.get(i);
            }
            
            
            stack.push(i);
        }
        return res;
        
    }
}