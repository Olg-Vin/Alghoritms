package Stack;

public class Main {
    
    public static void main(String[] args) {

        MyStack<String> stack = new MyStack<>(5);

        System.out.println(stack.empty());

        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        stack.push("7");
        stack.push("8");

        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());

        StackIterator<String> stackIterator = (StackIterator<String>) stack.iterator();

        System.out.println(stackIterator.hasNext());
        System.out.println("size = " + stack.size());
        while (stackIterator.hasNext()){
            System.out.println(stackIterator.next());
        }
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        stack.push("7");
        stack.push("8");
        System.out.println();
        for (String s: stack) {
            System.out.println(s);
        }
    }
}