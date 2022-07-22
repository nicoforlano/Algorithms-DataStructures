package stacks;

import java.util.ArrayList;
import java.util.List;

public class ArrayStack {

    private final List<Object> array;

    public ArrayStack() {
        array = new ArrayList<>();
    }

    public Object peek() {
        if(array.size() > 0) {
            return array.get(array.size() - 1);
        }
        return null;
    }

    public void push(Object value) {
        array.add(value);
    }

    public Object pop() {
        Object elementToRemove = array.get(array.size() - 1);
        array.remove(array.size() - 1);
        return elementToRemove;
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public Object getBottom() {
        if(this.array.size() > 0) {
            return this.array.get(0);
        }
        return null;
    }

    public void printStack() {
        System.out.println("----TOP----");
        for(int i = array.size() - 1; i >= 0; i--) {
            System.out.println(array.get(i));
        }
        System.out.println("----BOTTOM----");
    }

    public static void main(String[] args) {

        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("This");
        arrayStack.push("That");
        arrayStack.push("There");
        arrayStack.printStack();
        System.out.println("BOTTOM: " + arrayStack.getBottom());
        arrayStack.pop();
        arrayStack.printStack();
        System.out.println("PEEK: " + arrayStack.peek());
        arrayStack.pop();
        arrayStack.printStack();
        System.out.println("PEEK: " + arrayStack.peek());
        arrayStack.pop();
        arrayStack.printStack();
        System.out.println("PEEK: " + arrayStack.peek());

    }
}
