//https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/discuss/146808/C%2B%2BJavaPython-One-Pass
//first time know Pair classs
//FACEBOOK
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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return helper(root).getValue();
    }
    private Pair<Integer, TreeNode> helper(TreeNode root) {
         if (root == null)
             return new Pair(0, null);
        Pair<Integer, TreeNode> left = helper(root.left);
        Pair<Integer, TreeNode> right = helper(root.right);
        
        int leftHeight = left.getKey();
        int rightHeight = right.getKey();
        if (leftHeight == rightHeight) {
            return new Pair(leftHeight + 1, root);
        } else if (leftHeight < rightHeight) {
            return new Pair(rightHeight + 1, right.getValue());
        } else {
            return new Pair(leftHeight + 1, left.getValue());
        }
    }
}