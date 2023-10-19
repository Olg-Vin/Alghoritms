package LinkedList;

import java.util.Comparator;

public class DoubleLinkedListComparator implements Comparator<Minion> {
    @Override
    public int compare(Minion minion1, Minion minion2) {
        int sum1 = minion1.getAge() + minion1.getEyes();
        int sum2 = minion2.getAge() + minion2.getEyes();
        return Integer.compare(sum1, sum2);
    }
}

