/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0, len2 = 0;
        ListNode p1 = headA, p2 = headB;
        
        if (p1 == null || p2 == null)
            return null;
        
        //get length of linkedlist A
        while (p1 != null) {
            len1++;
            p1 = p1.next;
        }
        //get length of linkedlist B
        while (p2 != null) {
            len2++;
            p2 = p2.next;
        }
        
        int diff = 0;
        p1 = headA;
        p2 = headB;
        
        if (len1 > len2) {
            diff = len1 - len2;
            int i = 0;
            while (i < diff) {
                p1 = p1.next;
                i++;
            }
        } else {
            diff = len2 - len1;
            int i = 0;
            while (i < diff) {
                p2 = p2.next;
                i++;
            }
        }
        
        while (p1 != null && p2 != null) {
            if (p1 == p2) //compare node, not value
                return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}









//Same solution 
// did by  myself
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if (headA == null || headB == null)
            return null;
        
        //get two lengths of two lists
        ListNode dummyA = headA;
        int lenA = 0;
        while (dummyA != null) {
            lenA++;
            dummyA = dummyA.next;
        }
        
        ListNode dummyB = headB;
        int lenB = 0;
        while (dummyB != null) {
            lenB++;
            dummyB = dummyB.next;
        }
        
        int diff = lenA - lenB;
        dummyA = headA;
        dummyB = headB;
        if (diff > 0) {
            
            for (int i = 0; i < diff; i++) {
                dummyA = dummyA.next;
            }
        } else {
           
            for (int i = 0; i < Math.abs(diff); i++) {
                dummyB = dummyB.next;
            }
        }
       while (dummyA != null && dummyB != null) {
           if (dummyA == dummyB) {
               return dummyA;
           } else {
               dummyA = dummyA.next;
               dummyB = dummyB.next;
           }
       }
       return null;
    
        
    }
}


//Solution II
//https://www.youtube.com/watch?v=CPXIkMWNn5Q
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    
        Set<ListNode> visited = new HashSet<>();
        while (headA != null) {
            visited.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (visited.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;

    }
}