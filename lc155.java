class MinStack {

    Stack<Integer> stack;
    Stack<Integer> min_value;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min_value = new Stack<>();
    }
    
    
    public void push(int x) {
        if (min_value.isEmpty() || x <= min_value.peek())
            min_value.push(x);
        
        stack.push(x);
    }
    
    public void pop() {
        
        if (stack.peek().equals(min_value.peek())) { //stack.peek() == (min_value.peek()) will have wrong answer
            min_value.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_value.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */