package Tree;

public class Main {
    public static void main(String[] args) {
        Node<Integer> startNode = new Node<>(10);
        BinaryTree<Integer> binaryTree = new BinaryTree<>(startNode);

//        binaryTree.setKey(10);
        binaryTree.setKey(5);
        binaryTree.setKey(15);
        binaryTree.setKey(1);
        binaryTree.setKey(20);
        binaryTree.setKey(0);
        binaryTree.setKey(6);
        binaryTree.setKey(2);
        binaryTree.setKey(11);
        binaryTree.setKey(12);
//        System.out.println(binaryTree.getRootNode());
        System.out.println(binaryTree.asIndentedPreOrder(2));

        System.out.println();
        binaryTree.preOrder();

    }
}
