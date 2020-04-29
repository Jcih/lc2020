
//google , using segment tree
//http://www.noteanddata.com/leetcode-307-Range-Sum-Query-Mutable-google-interview-problem-java-solution-note.html
class NumArray {
    
    private static class Node {
        private int start, end;
        private int sum;
        private Node left, right;
        public Node(int start, int end, int sum, Node left, Node right) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = left;
            this.right = right;
        }
    }
    
    private Node root;
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    
    private Node buildTree(int[] nums, int start, int end) {
        if (start > end) return null;
        else if (start == end) {
            return new Node(start, start, nums[start], null, null);
        } else {
            int mid = start + (end - start)/2;
            Node left = buildTree(nums, start, mid);
            Node right = buildTree(nums, mid+ 1, end);
            int sum = left.sum;
            if (right != null) sum += right.sum;
            return new Node(start, end, sum, left, right);
        }
    }
    
    public void update(int i, int val) {
        update(root, i , val);
    }
    
    private void update(Node node, int i , int val) {
        if (node == null || i < node.start || i > node.end) return;
        else if (node.start == node.end && node.start == i) {
            node.sum = val;
        }
        else {
            update(node.left, i , val);
            update(node.right, i, val);
            int sum = 0;
            if (null != node.left) sum += node.left.sum;
            if (null != node.right) sum += node.right.sum;
            node.sum = sum;
        }
    }
    
    public int sumRange(int i, int j) {
        return sumRange(root, i , j);
    }
    
    private int sumRange(Node node, int i, int j) {
        if (node == null || i > j || i > node.end || j < node.start) return 0;
        else if (i <= node.start && node.end <= j) return node.sum;
        else {
            return sumRange(node.left, i ,j) + sumRange(node.right, i, j);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */