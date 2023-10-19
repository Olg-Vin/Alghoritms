package LinkedList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Minion implements Comparable<Minion> {
    private String name;
    private int eyes;
    private int age;
    private Minion next = null;
    private Minion prev = null;
    public Minion(String name, int eyes, int age) {
        this.name = name;
        this.eyes = eyes;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Minion{" +
                "name='" + name + '\'' +
                ", eyes=" + eyes +
                ", age=" + age +
                '}';
    }
    @Override
    public int compareTo(Minion o) {
        return this.name.compareTo(o.name);
    }
}
