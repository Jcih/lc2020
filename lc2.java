/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode p1 = l1, p2 = l2;
        int sum = 0;
        
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            cur.next = new ListNode(sum % 10);
            sum /= 10;
            cur = cur.next;
        }
        if (sum == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode l3 = dummy;
        
        int sum = 0;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            int l1_val = (l1 == null) ? 0 : l1.val;
            int l2_val = (l2 == null) ? 0 : l2.val;
            
            sum = l1_val + l2_val + carry;
            carry = sum / 10;
            sum = sum % 10;
            
            ListNode cur = new ListNode(sum);
            l3.next = cur;
            l3 = l3.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        if (carry > 0) {
            l3.next = new_Node;
            l3 = l3.next;
        }
        return dummy.next;
    }
}