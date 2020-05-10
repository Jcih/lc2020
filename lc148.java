/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode p1 = head;
        ListNode firstEnd = getFirstEnd(head);
        ListNode p2 = firstEnd.next;
        firstEnd.next = null;
        
        //sort each list
        p1 = sortList(p1);
        p2 = sortList(p2);
        
        //merge two lists
        return merge(p1, p2);
    }
    
    //get the list partition point
    private ListNode getFirstEnd(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1 != null && p2 != null) {
            if (p2.next == null || p2.next.next == null) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return head;
    }
    
    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        ListNode p1 = n1;
        ListNode p2 = n2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return head.next;
    }
}





//Solution II
//https://www.youtube.com/watch?v=pNTc1bM1z-4
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode tmp = head;
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            tmp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        tmp.next = null;//tail of first half   , slow = head of 2nd half, fast = tail of 2nd half
        
        ListNode left_side = sortList(head);
        ListNode right_side = sortList(slow);
        
        return merge(left_side, right_side);
        
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode sorted_tmp = new ListNode(0);
        ListNode cur = sorted_tmp;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        
        if (l1 != null) {
            cur.next = l1;
            l1 = l1.next;
        }
        
        if (l2 != null) {
            cur.next = l2;
            l2 = l2.next;
        }
        return sorted_tmp.next;
    }
}