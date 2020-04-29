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
    private int count, res;
    public int kthSmallest(TreeNode root, int k) {
        if (root.left != null) kthSmallest(root.left, k);
        if (++count == k) res = root.val;
        if (root.right != null) kthSmallest(root.right, k);
        return res;
    }
}