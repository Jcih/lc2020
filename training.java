//Linked List training 20200510

//2. Add Two Numbers

class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;

		int sum = 0;
		int carry = 0;

		while (l1 != null || l2 != null) {
			int i = 0;
			int j = 0;
			if (l1 != null) {
				i = l1.val;
			}
			if (l2 != null) {
				j = l2.val;
			}

			sum = i + j + carry;
			ListNode cur = new ListNode(sum % 10);
			p.next = cur;
			p = p.next;
			carry = sum / 10;

			if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
		}

		if (carry > 0) {
			p.next = new ListNode(1);
			p = p.next;
			p.next = null;
		}

		return dummy.next;

	}
}


// 19 Remove Nth Node from end of List

class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return head;

		ListNode slow = head;
		ListNode fast = head;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		if (fast == null)
			return head.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return head;
	}
}

// 21. Merge Two sorted lists
class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode res;
		if (l1.val < l2.val) {
			res = l1;
			res.next = mergeTwoLists(l1.next, l2);
		} else {
			res = l2;
			res.next = mergeTwoLists(l1, l2.next);
		}
		return res;
	}
}



//24.Swap nodes in Pairs

class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = head.next;

		head.next = swapPairs(dummy.next);

		dummy.next = head;
		
		return dummy;
	}
}


//61. Rotate List
class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;

		int len = 0;
		ListNode p = head;
		while (p != null) {
			len++;
			p = p.next;
		}

		int move = k % len;
		ListNode fast = head;

		for (int i = 0; i < move; i++) {
			fast = fast.next;
		}
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		fast.next = head;
        ListNode dummy = slow.next;
		slow.next = null;
		return dummy;
	}
}


//82. Remove duplicates from sorted listII
class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy;


		while (p.next != null && p.next.next != null) {
			if (p.next.val != p.next.next.val) {
				p = p.next;
			} else {
				int dup = p.next.val;
				while (p.next != null && p.next.val == dup) {
					p.next = p.next.next;
				}
				//p = p.next;  
			}

		}
		return dummy.next;

	}
}


//83. Remove Duplicates from Sorted Lits
class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = head;
		
		ListNode p = dummy;

		while (p != null && p.next !=null) {
			if (p.val == p.next.val) {
				p.next = p.next.next;
			} else {
				p = p.next;
			}
		}
		return dummy;

	}
}

//86. Partition List
class Solution {
	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return head;
		}

		ListNode dummy1 = new ListNode(0);
		ListNode head1 = dummy1;
		ListNode dummy2 = new ListNode(0);
		ListNode head2 = dummy2;

		ListNode cur = head;
		while (cur != null) {
			if (cur.val < x) {
				head1.next = new ListNode(cur.val);
				head1 = head1.next;
			} else {
				head2.next = new ListNode(cur.val);
				head2 = head2.next;
			}
			cur = cur.next;
		}

		head1.next = dummy2.next;
		return dummy1.next;
	}
}

//92. Reverse Linked List II
class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null)
			return null;
		//if the first node may be modified, then need to construct a new dummy node before head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev =  dummy;
        
		for (int i = 0; i < m - 1; i++) {
			prev = prev.next;
		}

		ListNode cur = prev.next;
		for (int i = 0; i < n - m; i++) {
			ListNode next = cur.next;
			cur.next = next.next;
			next.next = prev.next;
			prev.next = next;

		}
		return dummy.next;
	}
}

//109. Convert Sorted List to Binary Search Tree
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
       if (head == null)
			return null;
		return helper(head, null);
    }
    
    private TreeNode helper(ListNode start, ListNode end) {
		if (start == end) {
			return null;
		}

		ListNode slow = start;
		ListNode fast = start;
		while (fast != end && fast.next != end) {
			slow = slow.next;
			fast = fast.next.next;
		}

		TreeNode root = new TreeNode(slow.val);
		root.left = helper(start, slow);
		root.right = helper(slow.next, end);
		return root;
	}
}

// Linked list trainning 20200511

//138. Copy List with Random Pointer

class Solution{
	public Node copyRandomList(Node head) {
		if (head == null)
			return head;
		
		//copy a same node after each node
		Node cur = head;
		while (cur != null) {
			Node tmp = new Node(cur.val);
			tmp.next = cur.next;
			cur.next = tmp;
			cur = tmp.next;
		}

		//copy the random pointer to the copied nodes
		cur = head;
		while (cur != null) {
			if (cur.random != null)
				cur.next.random = cur.random.next;
			cur = cur.next.next;
		}

		//break two lists
		cur = head;
		Node dummy = head.next;
		while (cur != null) {
			Node tmp = cur.next;
			cur.next = tmp.next;
			if (tmp.next != null)
				tmp.next = tmp.next.next;
			cur = cur.next;
		}
		return dummy;

	}
}

//141 Linked List Cycle
class Solution {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}
}

//142. Linked List Cycle II
class Solution {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			//has cycle
			if (slow == fast)
				break;
		}
        
        //no cycle
        if (fast == null || fast.next == null)
            return null;

		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}

//143. Reorder List, need repeat
class Solution {
    public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		//find the mid node
		ListNode slow = head;
		ListNode fast = head;
        ListNode l1 = head;
        ListNode prev = null;// tail of first half

		while (fast != null && fast.next != null) {
            prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

        prev.next = null;

		ListNode l2 = reverse(slow);
		merge(l1, l2);
	}

	private ListNode reverse(ListNode head) {
		if (head == null)
			return head;
		ListNode prev = null;
		ListNode cur = head;
		while (cur != null) { // no cur.next != null
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}


	private void merge(ListNode l1, ListNode l2) {
		// merge two listNode by order
		while (l1 != null) {
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;
            l1.next = l2;
            
            if (l1_next == null)
                break;
            l2.next = l1_next;
            
            l1 = l1_next;
            l2 = l2_next;
        }
	}
}


//147. Insertion Sort List  . not understand, need extra review and practice
class Solution {
	public ListNode insertionSortList(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode pre = head;
		ListNode cur = head;
		dummy.next = pre;

		while (cur != null) {
			if (pre.val > cur.val) {
				pre.next = cur.next;
				ListNode headN = dummy;
				while (headN.next != null && headN.next.val < cur.val) {
					headN = headN.next;
				}
				cur.next = headN.next;
				headN.next = cur;
				cur = pre.next;

			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		return dummy.next;
	}
}


//148. Sort List
// merge sort , need extra review and practice
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

//160 Intersection of Two linked lists
public class Solution {
	public ListNode getIntersectionNode(ListNode headA, headB) {
		if (headA == null || headB == null)
			return null;
		ListNode dummyA = headA;
		ListNode dummyB = headB;

		int lenA = 0;
		int lenB = 0;

		while (dummyA != null) {
			lenA++;
			dummyA = dummyA.next;
		}

		while (dummyB != null) {
			lenB++;
			dummyB = dummyB.next;
		}

		int diff = lenA - lenB;
		dummyA = headA;
		dummyB = headB;

		if (diff > 0) {
			//dummyA move diff steps
			for (int i = 0; i < diff; i++) {	
				dummyA = dummyA.next;
			}

		} else {
			//dummyB move diff steps
			for (int i = 0; i < Math.abs(diff); i++) {	
				dummyB = dummyB.next;
			}
		}

		while (dummyA != null && dummyB != null) {
			if (dummyA == dummyB)
				return dummyA;
			dummyA = dummyA.next;
			dummyB = dummyB.next;
			
		}
		return null;

	}
}

//203 Remove Linked List Elements
class Solution {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;

		while (cur.next != null) {
			if (cur.next.val == val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return dummy.next;
	}
}

//206 Reverse Linked List

//Iterative
class Solution {
	public ListNode reverseList(ListNode head) {
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

//Recursion
class Solution {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode p = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}
}



//234. Palindrome Linked List
class Solution {
	public boolean isPalindrome(ListNode head) {
		//1. get the mid point
		//2. reverse the 2nd half list
		//3. traverse the 1st half and 2nd half and compare them

		//corner case
		if (head == null || head.next == null)
			return true;

		//get the mid pointer
		ListNode slow = head, fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode l2 = reverse(slow);
		ListNode l1 = head;

		while (l1 != null & l2 != null) {
			if (l1.val != l2.val) {
				return false;
			} else {
				l1 = l1.next;
				l2 = l2.next;
			}

		}

		return true;
	}
	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}
}


//237  Delete Node in a Linked List
class Solution {
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}