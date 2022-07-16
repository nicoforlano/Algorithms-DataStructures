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
        if(insertionIndex == null || insertionIndex < 0) {
            System.out.println("Can't insert at index null " + insertionIndex);
            return;
        }
        if(insertionIndex == 0) {
            this.prepend(value);
            return;
        }
        if(insertionIndex >= this.length) {
            this.append(value);
            return;
        }

        int index = 0;

        Node node = this.head;

        while(index < insertionIndex - 1) {
            node = node.getNext();
            index++;
        }

        DoublyLinkedNode newNode = new DoublyLinkedNode(value, (DoublyLinkedNode) node, (DoublyLinkedNode) node.getNext());
        ((DoublyLinkedNode) node.getNext()).setPrevious(newNode);
        node.setNext(newNode);

        this.length++;
    }

    @Override
    public void remove(Integer removalIndex) {
        if(removalIndex == null || removalIndex < 0) {
            System.out.println("Can't remove invalid index");
            return;
        }
        if(removalIndex == 0) {
            this.head = this.head.getNext();
            ((DoublyLinkedNode) this.head).setPrevious(null);
            return;
        } else if(removalIndex == this.length - 1) {
            ((DoublyLinkedNode) this.tail).getPrevious().setNext(null);
            return;
        }

        int index = 0;
        Node node = this.head;
        while(index < removalIndex - 1) {
            node = node.getNext();
            index++;
        }
        DoublyLinkedNode nodeToRemove = (DoublyLinkedNode) node.getNext();
        ((DoublyLinkedNode) nodeToRemove.getNext()).setPrevious((DoublyLinkedNode) node);
        node.setNext(nodeToRemove.getNext());

        this.length--;
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
        doublyLinkedList.insert(2, 666);
        doublyLinkedList.traverseAndPrint();
        doublyLinkedList.remove(1);
        doublyLinkedList.traverseAndPrint();
        doublyLinkedList.traverseAndPrintReverse();
    }
}
