package tema2.mylist;

import java.util.TreeSet;
import java.util.stream.IntStream;

public class TestList {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>(10);

        IntStream.range(0, 11).forEach(list::add);

        list.print();

        list.add(11);

        System.out.println();

        list.print();

        System.out.println();

        System.out.println(list.lookup(12));
        System.out.println(list.lookup(11));

    }

}
