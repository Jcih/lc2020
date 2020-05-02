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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode p = head;
        int len = 0;
        while (p != null) {
            
            p = p.next;
            len++;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        for (int i = 0; i < k % len; i++) { // be carefull , it's k % len
            fast = fast.next;
        }
        
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        fast.next = head;
        ListNode res = slow.next;
        slow.next = null;
        return res;
    }
}