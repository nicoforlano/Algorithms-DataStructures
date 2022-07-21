package stacks;

public class Node {

    private Object value;
    private Node next;

    public Node(Object value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return this.next;
    }

    public Object getValue() {
        return this.value;
    }
}
