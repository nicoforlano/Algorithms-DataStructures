package stacks;

public class Stack {

    private Node top;
    private Node bottom;
    private int length;

    public Stack() {
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

        Stack stack = new Stack();
        stack.push("This");
        stack.push("That");
        stack.push("There");
        stack.printStack();
        System.out.println("BOTTOM: " + stack.getBottom());
        stack.pop();
        stack.printStack();
        System.out.println("PEEK: " + stack.peek());
        stack.pop();
        stack.printStack();
        System.out.println("PEEK: " + stack.peek());
        stack.pop();
        stack.printStack();
        System.out.println("PEEK: " + stack.peek());

    }
}
