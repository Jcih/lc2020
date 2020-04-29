//https://www.youtube.com/watch?v=PZYTs9y4f4o

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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        
        return helper(nums, 0, nums.length - 1);
    }
    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;
        
        int mid = left + (right - left) / 2;
        
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = helper(nums, left, mid - 1);
        cur.right = helper(nums, mid + 1, right);
        
        return cur;
    }
}