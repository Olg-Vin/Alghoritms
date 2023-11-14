package Tree;


import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.Consumer;

@NoArgsConstructor
public class BinaryTree<E> implements AbstractBinaryTree<E>{
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
        List<AbstractBinaryTree<E>> list = new ArrayList<>();
        list.add(this);  // Добавляем текущий узел в список
        if (this.left != null) {
            list.addAll(this.left.preOrder());  // Обход левого поддерева и добавление его элементов в список
        }
        if (this.right != null) {
            list.addAll(this.right.preOrder());  // Обход правого поддерева и добавление его элементов в список
        }
        return list;
    }
    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        List<AbstractBinaryTree<E>> list = new ArrayList<>();
        if (this.left != null) {
            list.addAll(this.left.inOrder());  // Обход левого поддерева и добавление его элементов в список
        }
        list.add(this);  // Добавляем текущий узел в список
        if (this.right != null) {
            list.addAll(this.right.inOrder());  // Обход правого поддерева и добавление его элементов в список
        }
        return list;
    }
    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        List<AbstractBinaryTree<E>> list = new ArrayList<>();
        if (this.left != null) {
            list.addAll(this.left.postOrder());  // Обход левого поддерева и добавление его элементов в список
        }
        if (this.right != null) {
            list.addAll(this.right.postOrder());  // Обход правого поддерева и добавление его элементов в список
        }
        list.add(this);  // Добавляем текущий узел в список
        return list;
    }
    @Override
    public void forEachInOrder(Consumer<E> consumer) { // in order - означает в порядке возрастания и убывания?
        if (left != null) {
            left.forEachInOrder(consumer);
        }
        consumer.accept(key);
        if (right != null) {
            right.forEachInOrder(consumer);
        }
    }

    public void printBFS() {
        Queue<BinaryTree<E>> queue = new ArrayDeque<>();
        queue.add(this);
        while (!queue.isEmpty()){
            BinaryTree<E> current = queue.poll();
            System.out.println(current.getKey() + " ");
            if (current.left != null){
                queue.add(current.left);
            }
            if (current.right != null){
                queue.add(current.right);
            }
        }
    }
    public void printDFS() {
        if (this.left != null){
            this.left.printDFS();
        }
        if (this.right != null){
            this.right.printDFS();
        }
        System.out.println(this.getKey() + " ");
    }
}
