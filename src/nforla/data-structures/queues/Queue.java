package queues;

import stacks.LinkedListStack;

public class Queue {

    private Node first;
    private Node last;
    private int length;

    public Queue() {
        this.length = 0;
    }

    public Object peek() {
        if(this.length > 0) {
            return first.getValue();
        }
        return null;
    }

    public void enqueue(Object value) {

        Node newNode = new Node(value);
        if(length == 0) {
            this.first = newNode;
        } else {
            this.last.setNext(newNode);
        }
        this.last = newNode;
        length++;

    }

    public Object dequeue() {

        if(this.first == null) {
            return null;
        }

        Node nodeToDequeue = this.first;
        this.first = this.first.getNext();
        length--;
        if(this.first == null) {
            this.last = null;
        }
        return nodeToDequeue.getValue();
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public Object getLast() {
        if(this.last == null) {
            return null;
        }
        return this.last.getValue();
    }

    public void printQueue() {
        System.out.println("----FIRST----");
        Node current = this.first;

        while(current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }

        System.out.println("----LAST----");
    }

    public static void main(String[] args) {

        Queue queue = new Queue();
        queue.enqueue("This");
        queue.enqueue("That");
        queue.enqueue("There");
        queue.printQueue();
        System.out.println("LAST: " + queue.getLast());
        queue.dequeue();
        queue.printQueue();
        System.out.println("PEEK: " + queue.peek());
        queue.dequeue();
        queue.printQueue();
        System.out.println("PEEK: " + queue.peek());
        queue.dequeue();
        queue.printQueue();
        System.out.println("PEEK: " + queue.peek());
    }

}
