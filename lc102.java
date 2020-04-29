//https://www.programcreek.com/2014/04/leetcode-binary-tree-level-order-traversal-java/
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> nodeValues = new ArrayList<>();
        
        if (root == null)
            return res;
        LinkedList<TreeNode> cur = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        cur.add(root);
        
        while (!cur.isEmpty()) {
            TreeNode node = cur.remove();
            if (node.left != null) {
                next.add(node.left);
            }
            if (node.right != null)
                next.add(node.right);
            nodeValues.add(node.val);
            if (cur.isEmpty()) {
                cur = next;
                next = new LinkedList<>();
                res.add(nodeValues);
                nodeValues = new ArrayList<>();
            }
        }
        return res;
    }
}



// written by myself
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                levelNodes.add(cur.val);
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            res.add(levelNodes);
        }
        return res;
    }
}


