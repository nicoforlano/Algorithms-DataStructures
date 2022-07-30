package trees;

public class Node {

    private Integer value;
    private Node left;
    private Node right;

    public Node(Integer value) {
        this.value = value;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getRight() {
        return this.right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getLeft() {
        return this.left;
    }

    public Integer getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                "}\n";
    }
}
