//Solution I

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode p = root;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            res.add(t.val);
            
            t = t.right;
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
        }
        return res;
    }
}


//Solution II
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            helper(root, res);
        }
        return res;
    }
    
    private void helper(TreeNode root, List<Integer> res) {
        if (root.left != null)
            helper(root.left, res);
        
        res.add(root.val);
        
        if (root.right != null)
            helper(root.right, res);
    }
}