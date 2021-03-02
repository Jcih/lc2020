
 
/*
1. example
2. Data Structutr / algo
    two array: left, right
3. logic
    left: if (num[i + 1] > num[i]) candy[i + 1]++;
    right: if (num[i - 1] > num[i]) right[i - 1] = max(candy[i] + 1, candy[i - 1])
4. result
5. analysis
==========================
[1, 0, 2]

[1, 1, 1], [2, 1, 1], [2, 1, 2]

==========================

Time: O(N), Space: O(n)
==========================


*/

class Solution {
    public int candy(int[] ratings) {
        if (ratings == null) return 0;
        if (ratings.length == 1) return 1;
        
        int[] count = new int[ratings.length];
        Arrays.fill(count, 1);
        
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            }
        }
        
        for (int i = ratings.length - 1; i > 0; i--) {
            
            if (ratings[i - 1] > ratings[i]) {
                count[i - 1] = Math.max(count[i] + 1, count[i - 1]);
            }
            
        }
        
        int res = 0;
        for (int item : count) {
            res += item;
        }
        return res;
    }
}