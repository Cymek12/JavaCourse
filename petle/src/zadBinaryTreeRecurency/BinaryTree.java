package zadBinaryTreeRecurency;

public class BinaryTree {
    Node root;

    public int getTreeSum(Node node){
        if(node == null){
            return 0;
        }
        else{
            if(node.getRight() != null){
                return node.getValue() + getTreeSum(node.getRight());
            }
            if(node.getLeft() != null){
                return node.getValue() + getTreeSum(node.getLeft());
            }
            if(node.getLeft() == null && node.getRight() == null){
                return node.getValue();
            }
        }
        return 0;
    }

    public int getTreeSum(){
        return getTreeSum(root);
    }


    public void addNode(int value){
        Node node = new Node();
        node.setValue(value);
        if(root == null){
            root = node;
            return;
        }
        if(root != null){
            addRecursive(root, value);
        }
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



//        if(current.getValue() < value){
//            if(current.getRight() == null){
//                Node node = new Node();
//                node.setValue(value);
//                current.setRight(node);
//                return;
//            }
//            if(current.getRight() != null){
//                addRecursive(current.getRight(), value);
//            }
//        }
//        if(current.getValue() > value){
//            if(current.getLeft() == null){
//                Node node = new Node();
//                node.setValue(value);
//                current.setLeft(node);
//                return;
//            }
//            if(current.getLeft() != null){
//                addRecursive(current.getLeft(), value);
//            }
//        }
    }


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
}