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
    public int maxPathSum(TreeNode root) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        getSum(root, max);
        return max[0];
    }
    private int getSum(TreeNode root, int[] max) {
        if (root == null)
            return 0;
        int left = getSum(root.left, max);
        int right = getSum(root.right, max);
        
        //get the max of three Math.max(a, Math.max(b, c))
        int cur = Math.max(root.val, Math.max(root.val + left, root.val + right));
        max[0] = Math.max(max[0], Math.max(cur, left + root.val + right));
        return cur;
            
    }
}