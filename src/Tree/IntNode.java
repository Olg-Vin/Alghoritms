package Tree;

import lombok.Data;

@Data
public class IntNode<E> implements Comparable<IntNode<E>>{
    private int value;
    private IntNode<E> left;
    private IntNode<E> right;

    IntNode(int e){
        this.value = e;
        this.left = null;
        this.right = null;
    }
    @Override
    public int compareTo(IntNode<E> o) {
        return this.value-o.value;
    }
}
