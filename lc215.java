//Solution I  Time Complexity O(nlogn), using quick sort
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}


//Solution II 
//Priority Queue  , it's an improvement of Solution I, time complexity O(nlogk), k < n
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Arrays.sort(nums);
        //return nums[nums.length - k];
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        for (int i : nums) {
            q.offer(i);
            if (q.size() > k)
                q.poll();
        }
        return q.peek();
    }
}

//https://www.youtube.com/watch?v=FrWq2rznPLQ

//http://10.10.0.9:8080/aphrodite/home.xhtml
//Solution III select sort

//https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60294/Solution-explained