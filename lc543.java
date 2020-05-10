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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
           return 0;
        dfs(root);
        return diameter;
    }
    
    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }
    
    
}