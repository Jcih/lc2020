//FACEBOOK
//https://leetcode.com/problems/check-completeness-of-a-binary-tree/discuss/205682/JavaC%2B%2BPython-BFS-Level-Order-Traversal
class Solution {
	public boolean isCompleteTree(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (q.peek() != null) { // 不懂
			TreeNode tmp = q.poll();
			q.offer(tmp.left);
			q.offer(tmp.right);
		}
		while (!q.isEmpty() && q.peek() == null) {//不懂
			q.poll();//不懂
		}
		return q.isEmpty();
	}
}

//Optimization
public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();
        bfs.offer(root);
        while (true) {
            TreeNode node = bfs.poll();
            if (node.left == null) {
                if (node.right != null)
                    return false;
                break;
            }
            bfs.offer(node.left);
            if (node.right == null) break;
            bfs.offer(node.right);
        }
        while (!bfs.isEmpty()) {
            TreeNode node = bfs.poll();
            if (node.left != null || node.right != null)
                return false;
        }
        return true;
    }