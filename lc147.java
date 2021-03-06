//https://leetcode.com/problems/insertion-sort-list/discuss/46420/An-easy-and-clear-way-to-sort-(-O(1)-space-)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
                while (head != null){
                    ListNode p = fakeHead;
                    while (p != null) {
                        if ( head.val >= p.val && (p.next == null || head.val <= p.next.val)) {
                            ListNode next = head.next;
                            head.next = p.next;
                            p.next = head;
                            head = next;
                            break;
                        }
                        p = p.next;
                    }
                }
                return fakeHead.next;
    }
}