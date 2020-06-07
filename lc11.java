class Solution {
    public int maxArea(int[] height) {
        int res = 0, i = 0, j = height.length - 1;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            res = Math.max(res, (j - i) * h);
            while (i < j && h == height[i]) ++i;
            while (i < j && h == height[j]) --j;
        }
        return res;
    }
}

//Solutino II
class Solution {
    public int maxArea(int[] height) {
        
        int res = 0, i = 0, j = height.length - 1;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            res = Math.max(res, (j - i) * h);
           if (height[i] < height[j]) {
               i++;
           }else {
               j--;
           }
           
        }
        return res;
    }
}


//Solution III O(n^2)
/*
        int max = Integer.MIN_VALUE;
        for (int i= 0; i < height.length; i++) {
            for (int j = height.length - 1; j >= 0; j--) {
                int min = Math.min(height[i], height[j]);
                max = Math.max(max, (j - i) * min);
            }
        }
        return max;
        */