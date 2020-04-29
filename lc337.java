
//Solution I
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
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        return getMaxValue(root, map);
    }
    
    private int getMaxValue(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        
        int val = 0;
        if (root.left != null) {
            val += getMaxValue(root.left.left, map) + getMaxValue(root.left.right, map);
        }
        if (root.right != null) {
            val += getMaxValue(root.right.left, map) + getMaxValue(root.right.right, map);
        }
        
        int max = Math.max(root.val + val, getMaxValue(root.left, map) + getMaxValue(root.right, map));
        map.put(root, max);
        return max;
    }
}


//Solution II
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

    public int rob(TreeNode root) {
        int[] num = helper(root);
        return Math.max(num[0], num[1]);
    }
    private int[] helper(TreeNode root){
        if(root==null) return new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }

}