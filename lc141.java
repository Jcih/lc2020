// fast and slow pointer
// did 2 times

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        
        ListNode slow = head, fast = head;
        
        while (fast != null && fast.next != null) { // use fast, not slow
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) // node equivation
                return true;
        }
        return false;
    }
}

//Solution II
//3rd times
//https://www.youtube.com/watch?v=6OrZ4wAy4uE
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (slow != fast) {
            
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true;
    }
}