/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = head.next;
        head.next = swapPairs(head.next.next);
        dummy.next = head;
        
        return dummy;
    }
}


//did 2nd time

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        //need to consider head.next == null, cause we use head.next
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = head.next;
        head.next = swapPairs(dummy.next);
        dummy.next = head;
        return dummy;
    }
}