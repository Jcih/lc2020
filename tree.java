//Tree specific training 20200512

//94. Binary tree inorder Traversal

//left, root, right
//Recursive
class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root != null)
			helper(root, res);
		return res;
	}

	private void helper(TreeNode root, List<Integer> res) {
		if (root.left != null) {
			helper(root.left, res);
		}

		res.add(root.val);

		if (root.right != null) {
			helper(root.right, res);
		}

	}
}

//Iterative
//https://www.youtube.com/watch?v=WZwNoTm_9d8
class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		TreeNode cur = root;

		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}

			cur = stack.pop();
			res.add(cur.val);
			cur = cur.right;
		}
		return res;

	}
}

//144 Binary Tree Preorder traversal
// root, left, right
//Recursive
class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root != null)
			helper(root, res);
		return res;
	}

	private void helper(TreeNode root, List<Integer> res) {
		
		res.add(root.val);
		if (root.left != null)
			helper(root.left, res);
		if(root.right != null){
			helper(root.right, res);
		}
	}
}

//Iterative
class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		Stack<TreeNode>  stack = new Stack<>();
		List<Integer> res = new ArrayList<>();

		stack.add(root);

		while (!stack.isEmpty()) {
			TreeNode tmp = stack.pop();
			if (tmp != null) {
				res.add(tmp.val);
				stack.add(tmp.right);
				stack.add(tmp.left);
			}
		}
		return res;
	}
}


//145 Binary tree Postorder Traversal
// left, right, root
//Recursive
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
        	helper(root, res);

        }
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
    	if(root.left != null) {
			helper(root.left, res);
    	}
    	
    	if (root.right != null) {
    		helper(root.right, res);
    	}
    	
    	res.add(root.val);
    }
}

//Iterative
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null)
        	return res;

		stack.push(root);//memorize
        while (!stack.isEmpty()) {
        	TreeNode cur = stack.pop();
        	if (cur != null) {
        		res.add(0, cur.val);
        		stack.push(cur.left);
        		stack.push(cur.right);
        	}
        }
        return res;
    }

}


// 98. Validate Binary Search Tree
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null); 
    }
    
   private boolean isValidBST(TreeNode root, Integer max, Integer min) { // not int max, int min
		if (root == null)
			return true;
		if (min != null && root.val <= min || max != null && root.val >= max) {
			return false;
		}
		return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
	}
    
}

//100 Same tree
class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		} else {
			if (p.val == q.val) {
				return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
			}else {
				return false;
			}
		}
	}
}

//101 Symmetric Tree
class Solution {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return helper(root.left, root.right);
	}
	private boolean helper(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		} else if (left == null || right == null) {
			return false;
		} else {
			if (left.val == right.val) {
				return helper(left.left, right.right) && helper(left.right, right.left);

			} else {
				return false;
			}
		}
	}
}

//102 Binary Tree Level Order Traversal
// BFS using Queue, Queue using LinkdeList to implement
class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null)
			return res;
		queue.add(root);

		while (!queue.isEmpty()) {
			List<Integer> levelNodes = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.remove();
				levelNodes.add(cur.val);
				if (cur.left != null)
					queue.add(cur.left);
				if (cur.right != null)
					queue.add(cur.right);
			}
			res.add(levelNodes);
		}
		return res;
	}
}

//103 Binary Tree Zigzag Level Order Traversal
//BFS
//need a flag
class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		boolean leftToRight = true;

		while (!queue.isEmpty()) {
			List<Integer> levelNodes = new ArrayList<>();
			
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.remove();
				if (leftToRight) {
					levelNodes.add(cur.val);
				} else {
					levelNodes.add(0, cur.val);
				}
				if (cur.left != null)
					queue.add(cur.left);
				if (cur.right != null)
					queue.add(cur.right);
			}
			res.add(levelNodes);
			leftToRight = !leftToRight;

		}
		return res;

	}
}

//104 Maximum Depth of Binary Tree
//Depth = Math.max/min(left, right) + 1
class Solution {
	public int maxDepth(TreeNode root) {
        if (root == null)
        	return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int depth = Math.max(left, right);
        return depth + 1;
	}
}

//111 Minimum Depth of Binary Tree
//Depth = Math.max/min(left, right) + 1
class Solution{
	public int minDepth(TreeNode root) {
		if (root == null) 
			return 0;
		int left = minDepth(root.left);
		int right = minDepth(root.right);
        
        //if left no subtree, length doesn't count
        if (left == 0)
            return right + 1;
        if (right == 0)
            return left + 1;

		return Math.min(left, right) + 1;
	}
}


//105 Construct Binary Tree from Preorder and Inorder Traversal

// preorder , root first
// find the root position in inorder
// recursive
class Solution {
	public TreeNode buildtree(int[] preorder, int[] inorder) {
		return helper(0, 0, inorder.length - 1, preorder, inorder);
	}

	private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
		if (preStart > preorder.length - 1 || inStart > inEnd)
			return null;
		TreeNode root = new TreeNode(preorder[preStart]);
		int inIndex = 0;
		for (int i = 0; i <= inEnd; i++) {
			if (inorder[i] == root.val) {
				inIndex = i;
			}
		}

		root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
		//inIndex - inStart is the length of left subtree
		root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
		return root;
	}
}

//106 Construct binary tree from inorder and postorder
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(0, inorder.length - 1,  postorder.length - 1, inorder, postorder);
    }
    private TreeNode helper(int inStart, int inEnd, int postEnd, int[] inorder, int[] postorder) {
		if (postEnd < 0 || inStart > inEnd)
			return null;
		TreeNode root = new TreeNode(postorder[postEnd]);
		int inIndex = 0;
		for (int i = inEnd; i >= inStart; i--) {
			if (inorder[i] == root.val) {
				inIndex = i;
			}
		}
		//(inEnd - inIndex) is the length of right subtree
		root.left = helper(inStart,inIndex - 1, postEnd - (inEnd - inIndex) - 1, inorder, postorder);
		root.right = helper(inIndex + 1, inEnd, postEnd - 1, inorder, postorder);
        
        return root;
	}
}

//107 Binery Tree Level Order traversal II
//res.add(0, levelNodes)
class Solution {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> levelNodes = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.remove();
				levelNodes.add(cur.val);

				if (cur.left != null)
					queue.add(cur.left);
				if (cur.right != null)
					queue.add(cur.right);
			}
			res.add(0, levelNodes);
		}
		return res;
	}
}

//108 Convert Sorted Array to Binary Search Tree
class Solution {
	public TreeNode sortedArrayTpBST(int[] nums) {
		return helper(0, nums.length - 1, nums);
	}
	private TreeNode helper(int left, int right, int[] nums) {
		//base case
		if (nums == null || left > right)
			return null;
		int mid = left + (right - left) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(left, mid - 1, nums);
		root.right = helper(mid + 1, right, nums);
		return root;
	}
}

//110 Balanced Binary Tree
class Solution {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		if (helper(root) == -1)
			return false;
		return true;
	}
	private int helper(TreeNode root) {
		//base case
		if (root == null)
			return 0;
		int left = helper(root.left);
		int right = helper(root.right);
		int height = Math.max(left, right) + 1;
		if (left == -1 || right == -1)
			return -1;
		if (Math.abs(left - right) > 1)
			return -1;
		return height;
	}
}


//112 Path Sum
class Solution {
	public boolean hasPathSum(TreeNode root, int sum) {
		//base case
		if (root == null)
			return false;
		if (root.left == null && root.right == null && root.val == sum)
			return true;
		//recursive call
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}

//113 Path Sum II
//backtrack template apply
class Solution {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		List<Integer> nodes = new ArrayList<>();
		nodes.add(rootval);
		helper(res, nodes, root, sum - root.val);
		return res;
	}

	public void helper(List<List<Integer>> res, List<Integer> nodes, TreeNode root, int sum) {
		//base case
		if (root.left == null && root.right == null && sum == 0) {
			ArrayList<Integer> tmp = new ArrayList<>();
			tmp.addAll(nodes);
			res.add(tmp);
			return;
		}

		//recursive call
		if(root.left != null) {
			nodes.add(root.left.val);
			helper(res, nodes, root.left, sum - root.left.val);
			nodes.remove(nodes.size() - 1);
		}
		if (root.right != null) {
			nodes.add(root.right.val);
			helper(res, nodes, root.right, sum - root.right.val);
			nodes.remove(nodes.size() - 1);
		}

	}
}

//114 Flatten binary tree to linked list
class Solution {
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();

			if (cur.right != null)
				stack.push(cur.right);
			if (cur.left != null)
				stack.push(cur.left);

			if (!stack.isEmpty()) {
				cur.right = stack.peek();
			}
			cur.left = null;
		}

	}
}

//116 Populating Next Right Pointers in Each Node
class Solution {
	public Node connect(Node root) {
		if (root == null)
			return root;
		if (root.left != null) {
			root.left.next = root.right;
			if(root.next != null) {
				root.right.next = root.next.left;
			}
		}
		connect(root.left);
		connect(root.right);
		return root;

	}
}

//117 Populating Next Right Pointers in Each Node II
class Solution {
	public Node connect(Node root) {
		if (root == null)
			return root;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Node cur = queue.remove();
				if (i != size - 1) {
					cur.next = queue.peek();
				}

				if (cur.left != null)
					queue.add(cur.left);
				if (cur.right != null)
					queue.add(cur.right);
			}
		}
		return root;
	}
}


// 124 Binary Tree Maximum Path Sum
//https://www.youtube.com/watch?v=mOdetMWwtoI
class Solution {
    
    int max_path_sum;
    public int maxPathSum(TreeNode root) {
        max_path_sum = Integer.MIN_VALUE;
        pathSum(root);
        return max_path_sum;
    }
    
    public int pathSum(TreeNode node) {
        if (node == null)
            return 0;
        int left = Math.max(0, pathSum(node.left));
        int right = Math.max(0, pathSum(node.right));
        max_path_sum = Math.max(max_path_sum, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

}

//129 Sum Root to Leaf Numbers
class Solutin {
	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		return helper(root, 0 , 0);
	}
	private int helper(TreeNode root, int num, int sum) {
		if (root == null)
			return sum;

		//base case
		num = num * 10 + root.val;
		if ( root.left == null && root.right == null) {
			sum += num;
			return sum;
		}

		sum = helper(root.left, num, sum) + helper(root.right, num, sum);
		return sum;
	}
}

//173 Binary Search Tree Iterator
class BSTIterator {

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
        
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode cur = this.stack.pop();
        if (cur.right != null) {
            this.stack.push(cur.right);
            TreeNode tmp = cur.right.left;
            while (tmp != null) {
                this.stack.push(tmp);
                tmp = tmp.left;
            }
        }
        return cur.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }
} 


//199 Binary Tree Right Side View
class Solution {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				if (i == size - 1) {
					res.add(cur.val);
				}
				if (cur.left != null)
					queue.offer(cur.left);
				if (cur.right != null)
					queue.offer(cur.right);
			}
		}
		return res;
	}
}

//226 Invert Binary Tree
class Solution {
	public TreeNode invertTree(TreeNode root) {
        if (root == null)
        	return root;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
	}
}


//230. Kth Smallest Element in a BST
//https://www.youtube.com/watch?v=C6r1fDKAW_o
//inorder traverse
class Solution {
	public int kthSmallest(TreeNode root, int k) {
		int[] nums = new int[2];
		helper(root, k, nums);
		return nums[1];
	}

	private void helper(TreeNode root, int k, int[] nums) {
		if (root == null)
			return;
		helper(root.left, k, nums);
		if (++nums[0] == k) {
			nums[1] = root.val;
			return;
		}
		helper(root.right, k, nums);

	}
}



//235  Lowest Common Ancestor of a Binary Search Tree
//https://www.youtube.com/watch?v=kulWKd3BUcI
class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else {
			return root;
		}
	}
}

//236 Lowest Common Ancestor of a Binary Tree
//https://www.youtube.com/watch?v=13m9ZCB8gjw
class Solution {
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	 	 if (root == null) return null;
	 	 if (root == p || root == q)
	 	 	return root;
	 	 TreeNode left = lowestCommonAncestor(root.left, p, q);
	 	 TreeNode right = lowestCommonAncestor(root.right, p, q);
	 	 if (left == null && right == null) return null;
	 	 if (left != null && right != null) return root;
	 	 return left != null ? left : right;
	 }
}

//257 Binary Tree Paths
//backtracking
class Solution {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
        	return res;
        String str = "";
        helper(root, res, str);
        return res;
	}
	private void helper(TreeNode root, List<String> res, String str) {
		
        str = str + root.val;

		//basecase
		if (root.left == null && root.right == null) {
			res.add(str);
			return;
		}

		if (root.left != null) {
			helper(root.left, res, str + "->");
		}

		if (root.right != null) {
			helper(root.right, res, str + "->");
        }
	}
}

//337  House Robber III


//404 Sum of Left Leaves
class Solution {
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;
		else if (root.left != null && root.left.left == null && root.left.right == null) {
			return root.left.val + sumOfLeftLeaves(root.right);
		} else {
			return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
		}
	}
}