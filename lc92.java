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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return null;
        
        ListNode prev = null;
        ListNode cur_node = head;
        
        while (m > 1) {
            prev = cur_node;
            cur_node = cur_node.next;
            m--;
            n--;
        }
        
        ListNode connection = prev;
        ListNode tail = cur_node;
        
        while (n > 0) {
            ListNode next_node = cur_node.next;
            cur_node.next = prev;
            prev = cur_node;
            cur_node = next_node;
            n--;
        }
        if (connection != null) {
            connection.next = prev;
        } else {
            head = prev;
        }
        
        tail.next = cur_node;
        return head;
    }
}