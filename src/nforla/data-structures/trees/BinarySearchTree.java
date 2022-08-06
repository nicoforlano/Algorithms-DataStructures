package trees;

import java.util.Objects;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(Integer value) {

        Node newNode = new Node(value);
        if(this.root == null) {
            this.root = newNode;
            return;
        }

        var currentNode = this.root;

        while(currentNode != null) {
            if(value >= currentNode.getValue()) {
                if(currentNode.getRight() == null) {
                    currentNode.setRight(newNode);
                    break;
                } else {
                    currentNode = currentNode.getRight();
                }
            } else {
                if(currentNode.getLeft() == null) {
                    currentNode.setLeft(newNode);
                    break;
                } else {
                    currentNode = currentNode.getLeft();
                }
            }
        }
    }

    public Node lookup(Integer value) {
        var currentNode = this.root;
        while(currentNode != null) {
            if(Objects.equals(currentNode.getValue(), value)) {
                return currentNode;
            } else if(value > currentNode.getValue()) {
                currentNode = currentNode.getRight();
            } else {
                currentNode = currentNode.getLeft();
            }
        }
        return null;
    }

    public void remove(Integer value) {

        if(this.root == null) {
            return;
        }

        if(this.root.getValue().equals(value)) {
            removeRootNode();
        } else {
            var currentNode = this.root;
            while(currentNode != null) {
               if(value > currentNode.getValue()) {
                   var rightNode = currentNode.getRight();
                   if(rightNode != null && value.equals(rightNode.getValue())) {
                       removeRightNode(rightNode, currentNode);
                       break;
                   } else {
                       currentNode = rightNode;
                   }
               } else {
                   var leftNode = currentNode.getLeft();
                   if(leftNode != null && value.equals(leftNode.getValue())) {
                      removeLeftNode(leftNode, currentNode);
                       break;
                   } else {
                       currentNode = leftNode;
                   }
               }
            }
        }
    }

    private void removeRightNode(Node rightNode, Node currentNode) {
        if(rightNode.getLeft() == null && rightNode.getRight() == null) {
            currentNode.setRight(null);
        } else if(rightNode.getRight() != null && rightNode.getLeft() == null) {
            currentNode.setRight(rightNode.getRight());
        } else if(rightNode.getRight() == null && rightNode.getLeft() != null) {
            currentNode.setRight(rightNode.getLeft());
        } else {
            //We set the biggest element from the left as root
            var node = rightNode.getLeft();
            if(node.getRight() != null) {
                while(node.getRight() != null) {
                    node = node.getRight();
                }
            }
            node.setRight(rightNode.getRight());
            currentNode.setRight(node);
        }
    }

    private void removeLeftNode(Node leftNode, Node currentNode) {
        if(leftNode.getLeft() == null && leftNode.getRight() == null) {
            currentNode.setLeft(null);
        } else if(leftNode.getRight() != null && leftNode.getLeft() == null) {
            currentNode.setLeft(leftNode.getRight());
        } else if(leftNode.getRight() == null && leftNode.getLeft() != null) {
            currentNode.setLeft(leftNode.getLeft());
        } else {
            //We set the biggest element from the left as root
            var node = leftNode.getLeft();
            if(node.getRight() != null) {
                while(node.getRight() != null) {
                    node = node.getRight();
                }
            }
            node.setRight(leftNode.getRight());
            currentNode.setLeft(node);
        }
    }

    private void removeRootNode() {
        if(this.root.getLeft() == null && this.root.getRight() == null) {
            this.root = null;
        } else if(this.root.getLeft() != null) {
            //We set the biggest element from the left as root
            var node = this.root.getLeft();
            if(node.getRight() != null) {
                while(node.getRight().getRight() != null) {
                    node = node.getRight();
                }
            }
            node.getRight().setRight(root.getRight());
            node.getRight().setLeft(root.getLeft());
            this.root = node.getRight();
            node.setRight(null);
        } else {
            //We set the smallest element from the right as root
            var node = this.root.getRight();
            if(node.getLeft() != null) {
                while(node.getLeft().getLeft() != null) {
                    node = node.getLeft();
                }
            }
            node.getLeft().setRight(root.getRight());
            node.getLeft().setLeft(root.getLeft());
            this.root = node.getLeft();
            node.setLeft(null);
        }
    }

    public void recursiveTraverse(Node node) {
        if(node.getLeft() != null) {
            recursiveTraverse(node.getLeft());
        }
        System.out.println("Node " + node.getValue());
        if(node.getRight() != null) {
            recursiveTraverse(node.getRight());
        }
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }

    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        var node = binarySearchTree.lookup(6);
        binarySearchTree.insert(9);
        binarySearchTree.insert(4);
        binarySearchTree.insert(6);
        binarySearchTree.insert(20);
        binarySearchTree.insert(170);
        binarySearchTree.insert(15);
        binarySearchTree.insert(1);
        System.out.println("TREE: " + binarySearchTree);
        binarySearchTree.recursiveTraverse(binarySearchTree.root);
//        node = binarySearchTree.lookup(6);
//        binarySearchTree.remove(651);
//        System.out.println("REMOVING");
//        System.out.println("NEW TREE: " + binarySearchTree);
    }
}
