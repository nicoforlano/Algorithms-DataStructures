package linked_lists;

public class Node {

    protected Object value;
    protected Node next;

    public Node() {
    }

    public Node(Object value, Node next) {
        this.value = value;
        this.next = next;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue(){
        return this.value;
    }

    public void setNext(Node nextNode) {
        this.next = nextNode;
    }

    public Node getNext() {
        return this.next;
    }
}
