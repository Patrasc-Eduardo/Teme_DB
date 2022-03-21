package tema2.mylist;

import java.util.ArrayList;
import java.util.List;

public class MyList<T>{
    ArrayList<T> list;

    public MyList(){

    }

    public MyList(int dimension) {
        list = new ArrayList<>(dimension);
    }

    public void add(T element) {
        list.add(element);
    }

    public void print () {
        list.forEach(System.out::println);
    }

    public boolean lookup (T element) {
        return list.contains(element);
    }
}
