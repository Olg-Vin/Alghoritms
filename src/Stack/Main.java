package Stack;

public class Main {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>(5);
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        StackIterator<String> stackIterator = (StackIterator<String>) stack.iterator();
        for (String s: stack) {
            System.out.println(s);
        }
    }
}