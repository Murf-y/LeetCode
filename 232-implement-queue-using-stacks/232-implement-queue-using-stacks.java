class MyQueue {
    private Stack<Integer> stack;
    public MyQueue() {
        stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(stack.empty()) stack.push(x);
        else{
            Stack<Integer> temp = new Stack<Integer>();
            while(!stack.empty()){
                temp.push(stack.pop());
            }
            stack.push(x);
            while(!temp.empty()){
                stack.push(temp.pop());
            }
        }
    }
    
    public int pop() {
        return stack.pop();
    }
    
    public int peek() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */