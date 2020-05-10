//Solution I
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        

        //get length of LinkedList
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        

        //get the start position
        int start = len - n + 1;
        if (start == 1) {
            return head.next;
        }
        
        p = head;
        int count = 0;
        while (p != null) {
            count++;
            if (count == start - 1) {
                p.next = p.next.next;
            }
            p = p.next;
        }
        return head;
    }
}




//Solution II
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        //n = len means remove the first node
        if (fast == null) {
            return head.next;
        }
        
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return head;
    }
}