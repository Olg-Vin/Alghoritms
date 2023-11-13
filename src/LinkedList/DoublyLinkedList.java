package LinkedList;

import java.util.*;

public class DoublyLinkedList implements Iterable<Minion> {
    public Minion head;
    public Minion tail;
    public int size = 0;
    public DoublyLinkedList() {
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void addLast(Minion minion) {
        if (isEmpty()){
            head = minion;
            tail = minion;
        } else {
            tail.setNext(minion);
            minion.setPrev(tail);
            tail = minion;
        }
        size++;
    }
    public void addFirst(Minion minion) {
        if (isEmpty()){
            head = minion;
            tail = minion;
        } else {
            head.setPrev(minion);
            minion.setNext(head);
            head = minion;
        }
        size++;
    }
    public void addAt(Minion minion, int index) {
        try {
            if (isEmpty()){
                head = minion;
                tail = minion;
            } else if (index == 0){
                addFirst(minion);
            } else if (index == size-1){
                addLast(minion);
            } else {
                Minion current = head;
                for (int i = 1; i <= index; i++) {
                    current = current.getNext();
                }
                minion.setNext(current);
                minion.setPrev(current.getPrev());
                current.getPrev().setNext(minion);
                current.setPrev(minion);
                size++;
            }
        }catch (NullPointerException e) {
            System.out.println("index " + index + " out of range in add");
        }
    }
    public void removeFirst() {
        try {
            if (isEmpty()){
                System.out.println("list is empty");
            } else {
                head = head.getNext();
                head.setPrev(null);
                size--;
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void removeLast() {
        try {
            if (isEmpty()){
                System.out.println("list is empty");
            } else {
                tail = tail.getPrev();
                tail.setNext(null);
                size--;
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void removeAt(int index) {
        try {
            if (isEmpty()){
                System.out.println("list is empty");
            } else if (index == 0){
                removeFirst();
            } else if (index == size-1){
                removeLast();
            } else {
                Minion current = head;
                for (int i = 1; i <= index; i++) {
                    current = current.getNext();
                }
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());
                current.setPrev(null);
                current.setNext(null);
                size--;
            }
        }catch (NullPointerException e) {
            System.out.println("index " + index + " out of range in remove");
        }
    }
    public Minion getNode(int index) {
        try {
            Minion current = head;
            for (int i = 2; i <= index; i++) {
                current = current.getNext();
            }
            return current;
        }catch (NullPointerException e) {
            System.out.println("index " + index + " out of range");
        }
        return null;
    }
    public void update(Minion minion, int index) {
        if (index <= size){
            removeAt(index);
            size++;
            addAt(minion, index);
        }
        else {
            System.out.println("index " + index + " out of range");
        }
    }
    public void printList(Minion minion) {
        while (minion != null) {
            System.out.println(minion);
            minion = minion.getNext();
        }
    }
    @Override
    public Iterator iterator() {
        return new ListIterator<Object>(this.head, this.tail);
    }
    public List<Minion> sort()  {
        List<Minion> list = new ArrayList<>();
        for (Minion minion : this) {
            list.add(minion);
        }
        Collections.sort(list, new DoubleLinkedListComparator());
        for (Minion minion : list) {
            System.out.println(minion);
        }
//        list.sort(new DoubleLinkedListComparator());
        return list;
    }
}

class ListIterator<T> implements Iterator<T> {
    Minion head;
    Minion tail;
    Minion current;
    boolean reverse = false;
    public ListIterator(Minion head, Minion tail) {
        this.current = head;
        this.head = head;
        this.tail = tail;
    }
    @Override
    public boolean hasNext() {
        return current != null;
    }
    public boolean hasPrevious() {
        return current != null;
    }
    @SuppressWarnings("unchecked")
    @Override
    public T next() {
        Minion m = current;
        current = current.getNext();
        return (T) m;
    }
    @SuppressWarnings("unchecked")
    public T previous() {
        Minion m = current;
        current = current.getPrev();
        return (T) m;
    }
    public void reverse() {
        reverse = !reverse;
        if (reverse){
            current = tail;
        } else {
            current = head;
        }
    }
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
