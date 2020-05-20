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


//Solution II
//facebook
//https://www.youtube.com/watch?v=C6r1fDKAW_o

class Solution {
	public int kthSmallest(TreeNode root, int k) {
		int[] nums = new int[2];
		helper(root, k, nums);
		return nums[1];
	}

	private void helper(TreeNode root, int k, int[] nums) {
		if (root == null)
			return;
		helper(root.left, k, nums);
		if (++nums[0] == k) {
			nums[1] = root.val;
			return;
		}
		helper(root.right, k, nums);

	}
}