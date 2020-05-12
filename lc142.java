//https://blog.csdn.net/willduan1/article/details/50938210


//did 3 times
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
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        
        ListNode slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            //have circle
            if (fast == slow)
                break;
        }
        
        //if not have this, will get run time error. don't know why 
        // now I know, this means linked list has no cycle, code exit while 
        if (fast == null || fast.next == null)
            return null;
        
        slow = head;
        //get circle's start point, how to prove?
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}