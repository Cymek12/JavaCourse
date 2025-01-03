package wezly.kolekcjaLIFO;

public class Stack<T> {
    private Node<T> top;
    private int size;

    public void push(T value) {
        Node<T> node = new Node<>();
        node.setValue(value);
        node.setNext(top);
        this.top = node;
        size++;
    }

    public T pop() {
        if(size == 0){
            throw new IllegalStateException("stack is empty");
        }
        T temp = top.getValue();
        top = top.getNext();
        size--;

        return temp;
    }

    public void printStack() {
        Node<T> currentNode = top;

        while (currentNode != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNext();
        }

    }

    public boolean remove(T value) {
        Node<T> currentNode = top;
        if (top.getValue().equals(value)) {
            top = top.getNext();
            size--;
            return true;
        }

        while (currentNode != null) {
            if (currentNode.getNext().getValue().equals(value)) {
                currentNode.setNext(currentNode.getNext().getNext());
                size--;
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    public void addBottom(T value) {
        Node<T> node = new Node<>();
        node.setValue(value);
        node.setNext(null);

        Node<T> currentNode = top;
        if (top == null) {
            top = node;
        }

        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(node);
        size++;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
