package linked_lists;

public class DoublyLinkedNode extends Node {

    private DoublyLinkedNode previous;

    public DoublyLinkedNode(Object value, DoublyLinkedNode previous, DoublyLinkedNode next) {
        super(value, next);
        this.previous = previous;
    }

    public void setPrevious(DoublyLinkedNode previous) {
        this.previous = previous;
    }

    public DoublyLinkedNode getPrevious() {
        return this.previous;
    }
}
