package TreeTwo;

import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        BinaryTree<Integer> binaryTree = new BinaryTree<>(10);

//        binaryTree.setKey(10);
        binaryTree.setKey(50);
        binaryTree.setKey(15);
        binaryTree.setKey(30);
        binaryTree.setKey(20);
        binaryTree.setKey(80);
        binaryTree.setKey(60);
        binaryTree.setKey(40);
        binaryTree.setKey(11);
        binaryTree.setKey(12);

        binaryTree.printTree(binaryTree, 0);
        System.out.println();

        System.out.println(binaryTree.asIndentedPreOrder(2));
        System.out.println();
        List<AbstractBinaryTree<Integer>> list = binaryTree.postOrder();

        binaryTree.forEachInOrder(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
//        for(AbstractBinaryTree<Integer> b:list){
//            System.out.println(b.getKey());
//        }
    }
}
