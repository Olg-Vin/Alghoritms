package Tree.SearchTree;

public interface AbstractBinarySearchTree<E extends Comparable<E>> {
    public static class Node<E> {
        public E value;
        public Node<E> leftChild;
        public Node<E> rightChild;

        public Node(E value) {
            this.value= value;
        }

        public Node(E value, Node<E>leftChild, Node<E>rightChild) {
            this.value= value;
            this.leftChild= leftChild;
            this.rightChild= rightChild;
        }
    }

    void insert(E element); //insert element in tree
    boolean contains(E element);
    AbstractBinarySearchTree<E>search(E element); // return tree with element as root
    Node<E> getRoot();
    Node<E> getLeft();
    Node<E> getRight();
    E getValue();
}
