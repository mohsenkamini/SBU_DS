class Stack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public Stack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int value) {
        queue2.add(value);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }
        queue1 = queue2;
        queue2 = new LinkedList<>();
    }

    public int pop() {
        if (!empty()) {
            return queue1.remove();
        } else {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
    }

    public int top() {
        if (!empty()) {
            return queue1.peek();
        } else {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}


---

class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public void enqueue(int value) {
        stack1.push(value);
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
}