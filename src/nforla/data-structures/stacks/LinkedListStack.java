package stacks;

public class LinkedListStack {

    private Node top;
    private Node bottom;
    private int length;

    public LinkedListStack() {
        this.length = 0;
    }

    public Object peek() {
        if(this.length > 0) {
           return this.top.getValue();
        }
        return null;
    }

    public void push(Object value) {

        Node node = new Node(value);

        if(this.length == 0) {
            this.bottom = node;
        }

        node.setNext(this.top);

        this.top = node;

        length++;
    }

    public Object pop() {

        if(this.top == null) {
            return null;
        }

        Node elementToPop = this.top;

        this.top = elementToPop.getNext();

        length--;

        if(this.length == 0) {
            this.bottom = null;
        }

        return elementToPop;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public Object getBottom() {
        if(this.length > 0) {
            return this.bottom.getValue();
        }
        return null;
    }

    public void printStack() {
        System.out.println("----TOP----");
        Node current = this.top;

        while(current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }

        System.out.println("----BOTTOM----");
    }

    public static void main(String[] args) {

        LinkedListStack linkedListStack = new LinkedListStack();
        linkedListStack.push("This");
        linkedListStack.push("That");
        linkedListStack.push("There");
        linkedListStack.printStack();
        System.out.println("BOTTOM: " + linkedListStack.getBottom());
        linkedListStack.pop();
        linkedListStack.printStack();
        System.out.println("PEEK: " + linkedListStack.peek());
        linkedListStack.pop();
        linkedListStack.printStack();
        System.out.println("PEEK: " + linkedListStack.peek());
        linkedListStack.pop();
        linkedListStack.printStack();
        System.out.println("PEEK: " + linkedListStack.peek());

    }
}
