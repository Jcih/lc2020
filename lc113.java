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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (root == null) return res;
        ArrayList<Integer> l = new ArrayList<>();
        l.add(root.val);
        helper(root, sum - root.val, res, l);
        return res;
    }
    
    private void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> l) {
        if (root.left == null && root.right == null && sum == 0) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.addAll(l);
            res.add(tmp);
        }
        
        if (root.left != null) {
            l.add(root.left.val);
            helper(root.left, sum - root.left.val, res, l);
            l.remove(l.size() - 1);
        }
        if (root.right != null) {
            l.add(root.right.val);
            helper(root.right, sum - root.right.val, res, l);
            l.remove(l.size() - 1);
        }
    }
}




//Solution II


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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(res, cur, root, sum);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> cur, TreeNode root, int sum) {
        
        if (root == null)
            return;
        
        if (root.left == null && root.right == null && sum == root.val) {
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(cur);
            tmp.add(root.val);
            res.add(tmp);
            return;
        }
        
        if (root.left != null) {
            cur.add(root.val);
            helper(res, cur, root.left, sum - root.val);
            cur.remove(cur.size() - 1);
        }
        
        if (root.right != null) {
            cur.add(root.val);
            helper(res, cur, root.right, sum - root.val);
            cur.remove(cur.size() - 1);
        }
    }
}