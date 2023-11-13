package LinkedList;


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DoublyLinkedList myList = new DoublyLinkedList();
        Minion minion1 = new Minion("Steve", 2, 7);
        myList.addLast(minion1);
        Minion minion2 = new Minion("Mark", 2, 2);
        myList.addLast(minion2);
        Minion minion3 = new Minion("Dave", 2, 8);
        myList.addLast(minion3);
        Minion minion4 = new Minion("Bob", 2, 4);
        myList.addLast(minion4);
        Minion minion5 = new Minion("Kevin", 1, 1);
        myList.addLast(minion5);
        for (Minion m:myList){
            System.out.println(m);
        }
        System.out.println();
        myList.sort();
//  COMPARATOR
//        System.out.println();
//        System.out.println("comparator");
//        myList.sort();
//        System.out.println(myIterator.hasNext());
//        while (myIterator.hasNext()) {
//            System.out.println(myIterator.next());
//        }


    }
}
