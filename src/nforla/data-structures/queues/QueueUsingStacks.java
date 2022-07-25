package queues;

import stacks.ArrayStack;

public class QueueUsingStacks {

    private ArrayStack finalOrderStack;
    private ArrayStack reverseStack;
    private int length;

    public QueueUsingStacks() {
        finalOrderStack = new ArrayStack();
        reverseStack = new ArrayStack();
        this.length = 0;
    }

    public Object peek() {
        if(this.length > 0) {
            return finalOrderStack.peek();
        }
        return null;
    }

    public void push(Object value) {

        while(!finalOrderStack.isEmpty()) {
            reverseStack.push(finalOrderStack.pop());
        }

        this.finalOrderStack.push(value);

        while(!reverseStack.isEmpty()) {
            finalOrderStack.push(reverseStack.pop());
        }

        length++;

    }

    public Object pop() {
        Object elementToPop = finalOrderStack.pop();
        length--;
       return elementToPop;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public void printQueue() {
        finalOrderStack.printStack();
    }

    public static void main(String[] args) {

        QueueUsingStacks queue = new QueueUsingStacks();
        queue.push("This");
        queue.push("That");
        queue.push("There");
        queue.push(123);
        queue.push(11);
        queue.printQueue();
        System.out.println("PEEK: " + queue.peek());
        queue.pop();
        queue.printQueue();
        System.out.println("PEEK: " + queue.peek());
        queue.pop();
        queue.printQueue();
        System.out.println("PEEK: " + queue.peek());
        queue.pop();
        queue.printQueue();
        System.out.println("PEEK: " + queue.peek());
    }
}
