class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minTracker = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int value) {
        stack.push(value);
        if(minTracker.isEmpty() || minTracker.peek() >= value){
            minTracker.push(value);
        }
    }
    
    public void pop() {
        if(minTracker.peek().equals(stack.peek())) minTracker.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minTracker.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */