//https://blog.csdn.net/mine_song/article/details/70493866
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
    }
    private TreeNode helper(int[] inorder, int startIn, int endIn, int[] postorder, int postEnd) {
        if (startIn > endIn) 
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        if(startIn == endIn)
            return root;
        
        for (int i = endIn; i >= startIn; i--) {
            if (inorder[i] == root.val) {
                root.left = helper(inorder, startIn, i - 1, postorder, postEnd - (endIn - i) - 1);
                root.right = helper(inorder, i + 1, endIn, postorder, postEnd - 1);
                
            }
        }
        return root;
    }
}