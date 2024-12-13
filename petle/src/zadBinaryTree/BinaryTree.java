package zadBinaryTree;

public class BinaryTree {
    Node root;

    //wypisywanie drzewa w kolejnosci od najmniejszej do najwiekszej
    public void printTreeInOrder(Node current){
        if (current.getLeft() != null) {
            printTreeInOrder(current.getLeft());
        }
        System.out.println(current.getValue());
        if (current.getRight() != null) {
            printTreeInOrder(current.getRight());
        }
    }

    public void printTreeInOrder(){
        printTreeInOrder(root);
    }


    //funkcja sprawdzająca czy dana wartosc zawiera sie w drzewie binarnym
    public boolean isContainRecursive(Node current, int value){
        if(current == null){
            return false;
        }
        if(current.getValue() == value){
            return true;
        }

        return isContainRecursive(current.getLeft(), value) || isContainRecursive(current.getRight(), value);
    }

    public boolean isContain(int value){
        return isContainRecursive(root, value);
    }


    //dodawanie wartości do drzewa metodą rekurencyjną
    public void addRecursiveNode(int value){
        Node node = new Node();
        node.setValue(value);
        if(root == null){
            root = node;
            return;
        }
        addRecursive(root, value);
    }

    public Node addRecursive(Node current, int value){
        if(current == null){
            Node node = new Node();
            node.setValue(value);
            return node;
        }
        if(current.getValue() < value){
            current.setRight(addRecursive(current.getRight(), value));
        }
        else if (current.getValue() > value) {
            current.setLeft(addRecursive(current.getLeft(), value));
        }
        return current;
    }


    //dodawanie wartosci do drzewa metodą iteracyjną
    public void addIterativeNode(int value){
        Node node = new Node();
        node.setValue(value);
        if(root == null){
            root = node;
            return;
        }

        Node current = root;
        Node parent = null;
        while (current != null){
            if(value > current.getValue()){
                parent = current;
                current = current.getRight();
            }
            else if(value < current.getValue()){
                parent = current;
                current = current.getLeft();
            }
        }
        if(value < parent.getValue()){
            parent.setLeft(node);
        }
        if(value > parent.getValue()){
            parent.setRight(node);
        }
    }
}