package TreeTwo;


import lombok.NoArgsConstructor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

@NoArgsConstructor
public class BinaryTree<E> implements AbstractBinaryTree<E> {
    private E key;
    private BinaryTree<E> left;
    private BinaryTree<E> right;

    public BinaryTree(E key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
    void printTree(BinaryTree<E> binaryTree, int level) {
        if (binaryTree == null)
            return;
        printTree(binaryTree.right, level + 1);
        for (int i = 0; i < level; i++)
            System.out.print("   ");
        System.out.println(binaryTree.getKey());
        printTree(binaryTree.left, level + 1);
    }
    @Override
    public E getKey() {
        return this.key;
    }

    @Override
    public AbstractBinaryTree<E> getLeft() {
        return this.left;
    }

    @Override
    public AbstractBinaryTree<E> getRight() {
        return this.right;
    }

    @Override
    public void setKey(E key) {
        BinaryTree<E> binaryTree = new BinaryTree<>(key);
        if (this.left == null) {
            this.left = binaryTree;
        } else if (this.right == null) {
            this.right = binaryTree;
        } else {
            if (Math.random() < 0.5) { // рандомный выбор в какую сторону вставлять новое поддерево
                this.left.setKey(key);
            } else {
                this.right.setKey(key);
            }
        }
    }

    @Override
    public String asIndentedPreOrder(int indent) { // BFS
        StringBuilder stringBuilder = new StringBuilder();
        Queue<BinaryTree<E>> queue = new ArrayDeque<>();
        queue.add(this);

        stringBuilder.append(recursionBFS(queue,indent));
        return stringBuilder.toString();
    }
    private String recursionBFS(Queue<BinaryTree<E>> queue, int indent){
        if (queue.isEmpty()){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Queue<BinaryTree<E>> newQueue = new ArrayDeque<>();
        while (!queue.isEmpty()) {
            BinaryTree<E> current = queue.poll();
            stringBuilder.append(current.key).append(" ");
            if (current.left != null) {
                newQueue.add(current.left);
            }
            if (current.right != null) {
                newQueue.add(current.right);
            }
        }
        stringBuilder.append("\n");
        stringBuilder.append(" ".repeat(Math.max(0, indent)));
        return stringBuilder.append(recursionBFS(newQueue,indent*2)).toString();
    }

    @Override
    public List<AbstractBinaryTree<E>> preOrder() {
        return new ArrayList<>(recursionPreOrder(this));
    }
    private List<AbstractBinaryTree<E>> recursionPreOrder(BinaryTree<E> binaryTree){
        List<AbstractBinaryTree<E>> list = new ArrayList<>();
        list.add(binaryTree);
        if (binaryTree.left != null){
            list.addAll(recursionPreOrder(binaryTree.left));
        }
        if (binaryTree.right != null){
            list.addAll(recursionPreOrder(binaryTree.right));
        }
        return list;
    }

//    TODO
    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        return new ArrayList<>(recursionInOrder(this));
    }
    private List<AbstractBinaryTree<E>> recursionInOrder(BinaryTree<E> binaryTree){
        List<AbstractBinaryTree<E>> list = new ArrayList<>();
        if (binaryTree.left != null){
            list.addAll(recursionInOrder(binaryTree.left));
        }
        list.add(binaryTree);
        if (binaryTree.right != null){
            list.addAll(recursionInOrder(binaryTree.right));
        }
        return list;
    }
    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        return new ArrayList<>(recursionPostOrder(this));
    }
    private List<AbstractBinaryTree<E>> recursionPostOrder(BinaryTree<E> binaryTree){
        List<AbstractBinaryTree<E>> list = new ArrayList<>();
        if (binaryTree.left != null){
            list.addAll(recursionPostOrder(binaryTree.left));
        }
        if (binaryTree.right != null){
            list.addAll(recursionPostOrder(binaryTree.right));
        }
        list.add(binaryTree);
        return list;
    }
    @Override
    public void forEachInOrder(Consumer<E> consumer) {
        if (left != null) {
            left.forEachInOrder(consumer);
        }
        consumer.accept(key);
        if (right != null) {
            right.forEachInOrder(consumer);
        }
    }
}
