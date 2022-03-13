package linked_lists;

public class MyLinkedList {

    protected Node head;
    protected Node tail;
    protected int length;

    public MyLinkedList() {
    }

    public MyLinkedList(Object headValue) {
        this.head = new Node(headValue, null);
        this.tail = head;
        this.length = 1;
    }

    public void append(Object value) {
        Node newNode = new Node(value, null);
        this.tail.setNext(newNode);
        this.tail = newNode;
        this.length++;
    }

    public void prepend(Object value) {
        this.head = new Node(value, this.head);
        this.length++;
    }

    public void insert(Integer insertionIndex,  Object value) {
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
        Node leader = this.traverseToIndex(insertionIndex - 1);
        Node newNode = new Node(value, leader.getNext());
        leader.setNext(newNode);
    }

    public void remove(Integer removalIndex) {
        if(removalIndex == null || removalIndex < 0 || removalIndex > this.length) {
            System.out.println("Can't remove at index " + removalIndex);
            return;
        }
        if(removalIndex == 0) {
            this.head = this.head.getNext();
            return;
        }
        Node leader = this.traverseToIndex(removalIndex - 1);
        Node nodeToRemove = leader.getNext();
        leader.setNext(nodeToRemove.getNext());
    }

    public Node traverseToIndex(int index) {
        Node currentNode = this.head;
        int currentIndex = 0;
        while(currentIndex != index) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        return currentNode;
    }

    public void traverseAndPrint() {
        System.out.println("** LinkedList **");
        Node node = this.head;
        while(node != null) {
            System.out.print("Node: " + node.getValue() + " --> ");
            node = node.getNext();
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList(100);
        linkedList.append("Hey");
        linkedList.append("You");
        linkedList.append(5115);
        linkedList.prepend("WTF");
        linkedList.insert(3, 99);
        linkedList.traverseAndPrint();
        linkedList.remove(3);
        linkedList.traverseAndPrint();
    }
}
