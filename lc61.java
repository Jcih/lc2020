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




// 2nd time
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
        
        int len = 0;
        
        ListNode slow = head;
        while (slow != null) {
            len++;
            slow = slow.next;
        }
        
        int move = k % len;
        slow = head;
        ListNode fast = head;
        
        /*
        if (move == 0) {
            return head;
        }
        */
        
        for (int i = 0; i < move; i++) {
            fast = fast.next;
        }
        
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        /*
        ListNode dummy = slow.next;
        fast.next = head;
         */
        
        //if move == 0, slow = fast, slow.next = head.
        fast.next = head;
        ListNode dummy = slow.next;
        //
        slow.next = null;
        return dummy;
        
    }
}