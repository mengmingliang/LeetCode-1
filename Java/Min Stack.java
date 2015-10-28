/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

Tags: Stack, Design
Similar Problems: (H) Sliding Window Maximum


Thoughts:
Use a regular Stack: linked list.
Save that minimum integer in a HashMap with each stack value. At each level of the stack, it always stores the min till that moment.
Use another stack to hold that 'up-to-date' min values.

Note:
Stack: peek()

*/


class MinStack {
	public Stack<Integer> stack = new Stack<Integer>();
    public Stack<Integer> minStack = new Stack<Integer>();
    public void push(int x) {
    	stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            int min = minStack.peek() > x ? x : minStack.peek();
            minStack.push(min);
        }
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
