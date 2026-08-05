class MinStack {
    class pair{
        int first;
        int second;
        pair(int first,int second)
        {
            this.first = first;
            this.second = second;
        }
    }
    Stack<pair> st = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int value) {
        if(st.empty()) st.push(new pair(value,value));
        else
        {
            if(value<st.peek().second)
            {
                st.push(new pair(value,value));
            }
            else st.push(new pair(value,st.peek().second));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().first;
    }
    
    public int getMin() {
        return st.peek().second;
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