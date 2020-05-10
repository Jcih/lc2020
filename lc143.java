//https://blog.csdn.net/mine_song/article/details/71762350
//https://leetcode.com/problems/reorder-list/discuss/406322/java-to-143-reorder-list
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        
        ListNode slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode mid = slow;
        //reverse last half  linkedlist
        ListNode pre = mid;
        
        while(pre.next != null) {
            ListNode n = pre.next;
            pre.next = n.next;
            n.next = mid;
            mid = n;
        }
        
        //insert the reversed half to the first half
        ListNode first = head;
        while (mid != null) {
            ListNode cur = mid;
            
            mid = mid.next;
            cur.next = first.next;
            first.next = cur;
            first = cur.next;
        }
        first.next = null;
    }
    
  
}


//Solution II
//https://www.youtube.com/watch?v=xRYPjDMSUFw
//2nd time
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode slow = head, fast = head;
        ListNode l1 = head;
        ListNode prev = null;// tail of first half
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        //reverse 2nd half
        ListNode l2 = reverse(slow);
        // merge two halves
        merge(l1, l2);
       
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        
        while (cur != null) {
            ListNode next_node = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next_node;
        }
        return prev;
    }
    
    private void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;
            
            l1.next = l2;
            
            if (l1_next == null) {
                break;
            }
            l2.next = l1_next;
            l1 = l1_next;
            l2 = l2_next;
        }
    }
}