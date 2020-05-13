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