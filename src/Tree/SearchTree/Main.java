package Tree.SearchTree;

public class Main {
    public static void main(String[] args) {

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(10);
        binarySearchTree.insert(5);
        binarySearchTree.insert(15);
        binarySearchTree.insert(17);
        binarySearchTree.insert(6);
        binarySearchTree.insert(11);
        binarySearchTree.insert(2);
        binarySearchTree.insert(4);

        binarySearchTree.printTree(binarySearchTree.getRoot(), 0);
        System.out.println();
        binarySearchTree.insertOrDelete(10);
        binarySearchTree.printTree(binarySearchTree.getRoot(), 0);
        System.out.println();

//        Integer[] array = {1,2,3,4,5,6,7,8,9};
//        binarySearchTree=binarySearchTree.arrayToTree(array);
//        binarySearchTree.printTree(binarySearchTree.getRoot(), 0);
    }
}
