package Tree;

import java.util.List;
import java.util.function.Consumer;

public interface AbstractBinaryTree<E>{
    E getKey(); // return key of current node.
    AbstractBinaryTree<E>getLeft(); // return left under-the-tree
    AbstractBinaryTree<E>getRight(); // return right under-the-tree
    void setKey(E key); // insert new node
    String asIndentedPreOrder(int indent); // print tree as string
    List<AbstractBinaryTree<E>> preOrder(); // return tree as list in
    List<AbstractBinaryTree<E>>inOrder(); // return tree as list in
    List<AbstractBinaryTree<E>>postOrder(); // return tree as list in
    void forEachInOrder(Consumer<E> consumer); // выполнение заданного действия для каждого узла в порядке симметричного обхода
}
