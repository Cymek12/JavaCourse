package wezly.zadBinaryTree;

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

        System.out.print("Czy cyra 8 zawiera się w drzewie: ");
        System.out.println(binaryTree.isContain(8));
        System.out.print("Czy cyfra 1 zawiera się w drzewie: ");
        System.out.println(binaryTree.isContain(1));

    }
}
