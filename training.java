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





