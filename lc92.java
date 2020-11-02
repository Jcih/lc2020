//Solution I
//https://www.youtube.com/watch?v=GSJuwQzKSnI
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




//Solution II
//https://www.youtube.com/watch?v=wk8-_M-2fzI
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
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        
        ListNode cur = pre.next;
        
        for (int i = 0; i < n - m; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        
        return dummy.next;
    }
}



// did by myself
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
        
        if (head == null) return head;
    
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }
        
        ListNode head2 = prev.next;
        ListNode tail = new ListNode(0);
        tail.next = head;
        for (int i =0 ; i < n; i++) {
            tail = tail.next;
        }
        ListNode end = tail.next;
        tail.next = null;
        
        prev.next = reverse(head2, end);
        
        return dummy.next;
        
    }
    
    public ListNode reverse(ListNode head, ListNode end) {
        ListNode prev = end;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}