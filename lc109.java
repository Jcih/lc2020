/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return helper(head, null);
    }
    
    private TreeNode helper(ListNode head, ListNode end) {
        
        if (head == end) return null;// head == end , not null

        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != end && fast.next != end) { // don;t forget fast.next != end, not null
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode cur = new TreeNode(slow.val);
        cur.left = helper(head, slow);
        cur.right = helper(slow.next, end); // end, not null
        
        return cur;
        
    }
}