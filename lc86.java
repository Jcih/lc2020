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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode d1head = dummy1;
        ListNode dummy2 = new ListNode(0);
        ListNode d2head = dummy2;
        
        while (head != null) {
            if (head.val < x) {
                ListNode tmp  = new ListNode(head.val);
                d1head.next = head;
                d1head = d1head.next;
            } else {
                d2head.next = head;
                d2head = d2head.next;
            }
            head = head.next;
        }
        d2head.next = null;
        d1head.next = dummy2.next;
        return dummy1.next;
    }
}




//2nd time

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
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(0);
        ListNode l1_dummy = l1;
        ListNode l2 = new ListNode(0);
        ListNode l2_dummy = l2;
        
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                l1_dummy.next = new ListNode(p.val);
                l1_dummy = l1_dummy.next;
            } else {
                l2_dummy.next = new ListNode(p.val);
                l2_dummy = l2_dummy.next;
            }
            p = p.next;
        }
        
        l1_dummy.next = l2.next;
        return l1.next;
    }
}