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