package Tree;

import lombok.Data;

@Data
public class Node<E extends Comparable<E>> implements Comparable<Node<E>> {
    private E value;
    private Node<E> left;
    private Node<E> right;

    Node(E e) {
        this.value = e;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(Node<E> other) {
        return value.compareTo(other.value);
    }
}
