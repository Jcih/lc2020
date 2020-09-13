
//https://www.programcreek.com/2014/07/leetcode-palindrome-linked-list-java/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        //find list center
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;
        
        //reverse second part of the list
        ListNode p1 = secondHead;
        ListNode p2 = p1.next;
        while (p1 != null && p2 != null) {
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }
        
        secondHead.next = null;
        
        //compare two sublist
        ListNode p = (p2 == null ? p1 : p2);
        ListNode q = head;
        
        while (p != null) {
            if (p.val != q.val)
                return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }
}





//Solution II
//20200809
//https://www.youtube.com/watch?v=wk4QsvwQwdQ
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        
        //get the mid point
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) { 
            slow = slow.next;
            fast = fast.next.next;
        }

        //  3  2    1    2  3     
        //        slow
        // 3 -> 2 
        // 3 -> 2 -> 1


        // 3  2  1  1    2  3
        //          slow 
        // 3 -> 2 -> 1
        // 3 -> 2 -> 1

       
        ListNode mid = reverse(slow);
        
        slow = head;
        
        while (slow != null && mid != null) {
            if (slow.val != mid.val)
                return false;
            slow = slow.next;
            mid = mid.next;
                
        }
        return true;
        
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null)
            return head;
        
        ListNode prev = null;
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