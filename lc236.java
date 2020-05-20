
//google 
//https://www.youtube.com/watch?v=13m9ZCB8gjw
//credit http://www.noteanddata.com/leetcode-236-Lowest-Common-Ancestor-of-a-Binary-Tree-java-solution-note.html
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if (root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        
        return (left != null) ? left : right;
    }
}