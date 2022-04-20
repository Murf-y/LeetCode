public class MyStack {
	class Queue{
	    private class NodeS{
	        public int val;
	        public NodeS next;
	        public NodeS(int i) {val = i;}
	    }
	    private NodeS head;
	    private NodeS tail;
	    public Queue(){
	        head = null;
	    }
	    public void enqueue(int i){
	    	NodeS n = new NodeS(i);
	        if(tail == null){
	            head = n;
	            tail = n;
	        }
	        else{
	            tail.next = n;
	            tail = n;
	        }
	    }
	    public int dequeue(){
	        if(head == null) return 0;
	        int i = head.val;
	        head = head.next;
	        return i;
	    }
	    public int peek(){
	        if(head == null) return 0;
	        int i = head.val;
	        return i;
	    }
	    public boolean isEmpty() {return head == null;}
	}
    private Queue q;
    public MyStack() {
        q = new Queue();
    }
    
    public void push(int x) {
        Queue temp = new Queue();
        temp.enqueue(x);
        while(!q.isEmpty()){
            temp.enqueue(q.dequeue());
        }
        q = temp;
    }
    
    public int pop() {
        return q.dequeue();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */