package zadBinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree =  new BinaryTree();

        binaryTree.addNode(3);
        binaryTree.addNode(5);
        binaryTree.addNode(2);
//        binaryTree.addNode(10);
//        binaryTree.addNode(8);
//        binaryTree.addNode(4);

        binaryTree.printTreeInOrder();

        System.out.println("Suma: ");
        System.out.println(binaryTree.getTreeSum());
    }
}
