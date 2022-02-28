package linked_lists;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int length;

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

    public void insert(int index) {
    }

    public void remove(int index) {
    }

    public void traverse() {
        Node node = this.head;
        while(node != null) {
            System.out.println("Node: " + node.getValue());
            node = node.getNext();
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList(100);
        linkedList.append("Hey");
        linkedList.append("You");
        linkedList.append(5115);
        linkedList.prepend("WTF");
        linkedList.traverse();
    }
}
