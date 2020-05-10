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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        
        ListNode dummy1 = l1;
        while (dummy1 != null) {
            s1.push(dummy1);
            dummy1 = dummy1.next;
        }
        
        ListNode dummy2 = l2;
        while (dummy2 != null) {
            s2.push(dummy2);
            dummy2 = dummy2.next;
        }
        
        ListNode dummy_res = new ListNode(0);
        ListNode p = dummy_res;
        int carry = 0;
        
        while (!s1.isEmpty() || !s2.isEmpty()) {
            
            int i = 0;
            int j = 0;
            
            if (!s1.isEmpty()) {
                i = s1.pop().val;
                    
            }
            if (!s2.isEmpty()) {
                j = s2.pop().val;
            }
            
            int sum = i + j + carry;
            ListNode cur = new ListNode(sum % 10);
            carry = sum / 10;
            p.next = cur;
            p = p.next;
        }
        
        if (carry == 1) {
            p.next = new ListNode(1);
            p = p.next;
            p.next = null;
        }

        //reverse dummy_res.next
        ListNode prev = null;
        ListNode cur = dummy_res.next;
        
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
        
    }
}