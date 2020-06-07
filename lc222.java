//credit: https://www.programcreek.com/2014/06/leetcode-count-complete-tree-nodes-java/


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
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
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
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int left = getLeftHeight(root) + 1;
        int right = getRightHeight(root) + 1;
        
        if (left == right) {
            return (2 << left - 1) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    
    private int getLeftHeight(TreeNode root) {
        if (root == null)
            return 0;
        int height = 0;
        
        while (root.left != null) {
            height++;
            root = root.left;
        }
        return height;
    }
    private int getRightHeight(TreeNode root) {
        if (root == null) return 0;
        
        int height = 0;
        while (root.right != null) {
            height++;
            root = root.right;
        }
        return height;
    }
}





//Solution III
//https://www.youtube.com/watch?v=8BPKe6N8xdk
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
    public int countNodes(TreeNode root) {
        int hLeft = 0, hRight = 0;
        TreeNode pLeft = root, pRight = root;
        while (pLeft != null) {
            hLeft++;
            pLeft = pLeft.left;
        }
        while (pRight != null) {
            hRight++;
            pRight = pRight.right;
        }
        if (hLeft == hRight) {
            return (int) Math.pow(2, hLeft) - 1;
        }
        
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}