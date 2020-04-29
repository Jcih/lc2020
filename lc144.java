/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }
}



//Solution II
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
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