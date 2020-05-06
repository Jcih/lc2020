//https://www.youtube.com/watch?v=5AV33YdtDYw&feature=share
//Lyft

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        int i = 0;
        
        while (i < asteroids.length) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])) {
                    stack.pop();
                } 
                
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                } else if (stack.peek() == Math.abs(asteroids[i])) {
                    stack.pop();
                }
            }
            i++;
        }
        
        int[] res = new int[stack.size()];
        for (int j = stack.size() - 1; j >= 0; j--) {
            res[j] = stack.pop();
        }
        return res;
    }
}