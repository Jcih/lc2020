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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        
        String sb = "";
        helper(root, res, sb);
        return res;
    }
    
    private void helper(TreeNode root, List<String> res, String s) {
        if (root == null)
            return;
        s = s + "->" + root.val;
        if (root.left == null && root.right == null) {
            res.add(s.substring(2));
            return;
        }
        if (root.left != null) {
            helper(root.left, res, s);
            
        }
        if (root.right != null) {
            helper(root.right, res, s);
        }
            
    }
}