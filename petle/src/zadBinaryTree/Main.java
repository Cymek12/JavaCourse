package zadBinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree =  new BinaryTree();

        binaryTree.addIterativeNode(3);
        binaryTree.addIterativeNode(5);
        binaryTree.addIterativeNode(2);

        binaryTree.addRecursiveNode(10);
        binaryTree.addRecursiveNode(8);
        binaryTree.addRecursiveNode(4);

        binaryTree.printTreeInOrder();

//        System.out.println("Suma: ");
//        System.out.println(binaryTree.getTreeSum());
    }
}
