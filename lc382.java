

// credit : https://www.programcreek.com/2014/08/leetcode-linked-list-random-node-java/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    Random r = null;
    ListNode  h = null;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        r = new Random();
        h = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int count = 1;
        ListNode p = h;
        int result = 0;
        while (p != null) {
            if (r.nextInt(count) == 0) {
                result  = p.val;
            }
            count++;
            p = p.next;
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */