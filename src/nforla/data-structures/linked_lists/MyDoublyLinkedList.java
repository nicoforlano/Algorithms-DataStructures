package linked_lists;

public class MyDoublyLinkedList extends MyLinkedList {

    public MyDoublyLinkedList(Object headValue) {
        this.head = new DoublyLinkedNode(headValue, null, null);
        this.tail = head;
        this.length = 1;
    }

    @Override
    public void append(Object value) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(value, (DoublyLinkedNode) this.tail, null);
        this.tail.setNext(newNode);
        this.tail = newNode;
        this.length++;
    }

    @Override
    public void prepend(Object value) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(value, null, (DoublyLinkedNode) this.head);
        ((DoublyLinkedNode) this.head).setPrevious(newNode);
        this.head = newNode;
        this.length++;
    }

    @Override
    public void insert(Integer insertionIndex, Object value) {
        //TODO
        super.insert(insertionIndex, value);
    }

    @Override
    public void remove(Integer removalIndex) {
        //TODO
        super.remove(removalIndex);
    }

    @Override
    public Node traverseToIndex(int index) {
        //TODO
        return super.traverseToIndex(index);
    }

    public void traverseAndPrintReverse() {
        System.out.println("** LinkedList Reversed **");
        DoublyLinkedNode node = (DoublyLinkedNode) this.tail;
        while(node != null) {
            System.out.print("Node: " + node.getValue() + " --> ");
            node = node.getPrevious();
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        MyDoublyLinkedList doublyLinkedList = new MyDoublyLinkedList(100);
        doublyLinkedList.append("123");
        doublyLinkedList.prepend(987);
        doublyLinkedList.traverseAndPrint();
        doublyLinkedList.traverseAndPrintReverse();
    }
}
