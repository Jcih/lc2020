//20200720 break the list to two seperate. need repeat. 

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node p = head;

        //copy every node and insert into list    1 -> 2 -> 3 -> null    ==>>   1 -> 1 -> 2 -> 2 -> 3 -> 3 -> null
        while (p != null) {
            Node copy = new Node(p.val);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }
        
        //copy random pointer for each new node
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        
        //break list to two
        p = head;
        Node newHead = head.next;
        while (p != null) {
            Node tmp = p.next;
            p.next = tmp.next;
            if (tmp.next != null)
                tmp.next = tmp.next.next;
            p = p.next;
        }
        return newHead;
    }
}