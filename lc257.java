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

//Solutino II
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        String str = "";
        helper(res, str, root);
        return res;
    }
    
    private void helper(List<String> res, String str, TreeNode root) {
        
        if (root == null)
            return;
        str = str + root.val;
        
        
        if (root.left == null && root.right == null) {
            res.add(new String(str));
            return;
        }
        
        if (root.left != null) {
            helper(res, str + "->", root.left);
        }
        if (root.right != null) {
            helper(res, str + "->", root.right);
        }
    }
}