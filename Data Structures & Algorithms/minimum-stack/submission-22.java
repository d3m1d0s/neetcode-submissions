class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min;

    public MinStack() {}

    public void push(int val) {
        if (stack == null) {
            stack = new Stack<>();
            min = new Stack<>();
        }

        stack.push(val);

        if (min.isEmpty() || val <= min.peek()) {
            min.push(val);
        }

    }

    public void pop() {
        if (stack == null)
            return;
        if (stack.peek().equals(min.peek())) {
            min.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}