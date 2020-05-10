/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode oddHead = head, evenHead = head.next;
        ListNode prevOdd = oddHead, prevEven = evenHead;
        
        while (prevOdd.next != null && prevEven.next!= null) {
            prevOdd.next = prevEven.next;
            prevOdd = prevOdd.next;
            prevEven.next = prevOdd.next;
            prevEven = prevEven.next;
        }
        prevOdd.next = evenHead;
        return oddHead;
    }
}


//Solution II,  sample solution , did by myself
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode dummy = head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode dummy2 = even;
        
        while (odd != null && odd.next != null && even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
            
        }
        
        odd.next = dummy2;
        return dummy;
    }
}