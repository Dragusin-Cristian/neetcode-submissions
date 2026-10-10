class Item {
    public int value;
    public int min;
    public Item(int val, int min) {
        this.value = val;
        this.min = min;
    }
}

class MinStack {
    Stack<Item> stack;

    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        if (this.stack.size() == 0) {
            this.stack.push(new Item(val, val));
        } else {
            // get the top element
            Item x = this.stack.peek();

            // check if it's min < new val
            if (x.min < val) {
                // if yes, the new item will have as min the same min
                this.stack.add(new Item(val, x.min));
            } else {
                // if no, the new item will have as min it's own value
                this.stack.add(new Item(val, val));
            }
        }
    }
    
    public void pop() {
        this.stack.pop();
    }
    
    public int top() {
        Item x = this.stack.peek();
        return x.value;
    }
    
    public int getMin() {
        Item x = this.stack.peek();
        return x.min;
    }
}
