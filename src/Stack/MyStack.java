package Stack;

import java.util.Iterator;

public class MyStack<T> implements Iterable<T>{
    private int sizeOfStack;
    private Object[] arrayForStack;
    MyStack(int size){
        this.sizeOfStack = 0; 
        this.arrayForStack = new Object[size];
    }
    public void pop(){
        sizeOfStack--;
        arrayForStack[sizeOfStack] = null;
    }
    public void push(T obj){
        if (sizeOfStack == arrayForStack.length-1){
            increaseSpace(this.arrayForStack);
        }
        arrayForStack[sizeOfStack] = obj;
        sizeOfStack++;
    }
    @SuppressWarnings("unchecked")
    public T peek(){
        return (T) arrayForStack[sizeOfStack-1];
    }
    public boolean empty(){
        return sizeOfStack == 0;
    }
    public int size(){
        return this.sizeOfStack;
    }
    public void increaseSpace(Object[] array){
        this.arrayForStack = new Object[this.arrayForStack.length*2];
        System.arraycopy(
        array, 0, arrayForStack, 0, array.length);
    }
    @Override
    public Iterator<T> iterator() {
        return new StackIterator<>(this.arrayForStack, sizeOfStack);
    }
}
class StackIterator<T> implements Iterator<T> {
    int count;
    Object[] arrayForIteration;
    public StackIterator(Object[] stack, int size) {
        arrayForIteration = stack;
        count = size;
    }
    @Override
    public boolean hasNext() {
        try {
            return arrayForIteration[count-1] != null;
        }
        catch (Exception e){
            return false;
        }
    }
    @SuppressWarnings("unchecked")
    @Override
    public T next() {
        count--;
        return (T) arrayForIteration[count];
    }
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}