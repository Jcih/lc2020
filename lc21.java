/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        
        ListNode res;
        if (l1.val <= l2.val) {
            res = l1;
            res.next = mergeTwoLists(l1.next, l2);
        } else {
            res = l2;
            res.next = mergeTwoLists(l1, l2.next);
        }
        return res;
        
        
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode l3 = dummy;
        
        while (l1 != null && l2 != null) {
            int l1_val = (l1 == null) ? 0 : l1.val;
            int l2_val = (l2 == null) ? 0 : l2.val;
            
            if (l1_val <= l2_val) {
                l3.next = new ListNode(l1_val);
                l1 = l1.next;
            } else {
                l3.next = new ListNode(l2_val);
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        
        if (l1 != null) {
            l3.next = l1;
        } else if (l2 != null) {
            l3.next = l2;
        }
        
        return dummy.next;
    }
}