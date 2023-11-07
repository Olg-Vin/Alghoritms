package Tree;

import lombok.Getter;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

@Getter
public class BinaryTree<E extends Comparable<E>> implements AbstractBinaryTree<E> {
    private Node<E> rootNode; // root node
    private Node<E> currentNode; // current node
    int size = 0; // size of tree
    int height = 0; // height of tree
    StringBuilder stringBuilder = new StringBuilder();

    public BinaryTree() { // Пустое дерево
        this.rootNode = null;
    } // create new empty tree

    public BinaryTree(Node<E> node) {
        this.rootNode = node;
        this.currentNode = node;
    }

    @Override
    public E getKey() {
        if (currentNode == null){
            return null;
        }
        return currentNode.getValue();
    }

    @Override
    public AbstractBinaryTree<E> getLeft() {
        if (rootNode.getLeft() == null){
            return null;
        }
        return new BinaryTree<>(rootNode.getLeft());
    }

    @Override
    public AbstractBinaryTree<E> getRight() {
        if (rootNode.getRight() == null){
            return null;
        }
        return new BinaryTree<>(rootNode.getRight());
    }

    @Override
    public void setKey(E key) {
        rootNode = sortInsertIn(rootNode, key);
    }

    @Override
    public String asIndentedPreOrder(int indent) {
        Queue<Node<E>> newQueue = new ArrayDeque<>();
        newQueue.add(rootNode);
        recursiveBFS(newQueue, indent);
        return stringBuilder.toString();
    }

    public void recursiveBFS(Queue<Node<E>> queue, int n) {
        if (queue.isEmpty()){
            return;
        }
        Queue<Node<E>> newQueue = new ArrayDeque<>();
        while (!queue.isEmpty()) {
            if (queue.peek().getLeft() != null){
                newQueue.add(queue.peek().getLeft());
            }
            if (queue.peek().getRight() != null){
                newQueue.add(queue.peek().getRight());
            }
            stringBuilder.append(queue.poll().getValue()).append(" ");
        }
        stringBuilder.append("\n");
        for (int i = 0; i < n; i++) {
            stringBuilder.append(" ");
        }
        recursiveBFS(newQueue, n * 2);
    }

    @Override
    public List<AbstractBinaryTree<E>> preOrder() {

        return null;
    }

    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        return null;
    }

    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        return null;
    }

    @Override
    public void forEachInOrder(Consumer<E> consumer) {

    }

    public Node<E> sortInsertIn(Node<E> current, E key) {
        if (current == null){
            return new Node<>(key);
        }
        if (key.compareTo(current.getValue()) <= 0){
            current.setLeft(sortInsertIn(current.getLeft(), key));
        } else if (key.compareTo(current.getValue()) > 0){
            current.setRight(sortInsertIn(current.getRight(), key));
        }
        return current;
    }
    public Node<E> insertIn(Node<E> current, E key){
        Queue<Node<E>> nodes = new ArrayDeque<>();
        nodes.add(rootNode);
        while (!nodes.isEmpty()){

        }
        // TODO равномерная вставка без условия
        return null;
    }
}
