package tema2.mylist;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyList<T> {
    T[] list;
    int size;
    int capacity;

    public MyList() {

    }

    public MyList(int  dimension) {
        if (dimension > 0) {
            //list = clazz.cast(Array.newInstance(clazz.getComponentType(), dimension));
            list = (T[]) new Object[dimension];
            size = 0;
            capacity = dimension;
        } else if (dimension == 0) {
            list = null;
            size = 0;
            capacity = 0;
        } else {
            throw new IllegalArgumentException("Capacity must be a positive number");
        }
    }

    public void add(T element) {
        if (size < capacity) {
            list[size++] = element;
        } else {
            capacity = (capacity << 1); // double the capacity
            //list = MyList(T[].class, )
            list[size++] = element;
        }
    }

    public void print() {
        System.out.println(Arrays.toString(list));
    }

    public boolean lookup(T element) {
        return Arrays.asList(list).contains(element);
        /*
        or

        for(int i = 0; i < size; ++i) {
            if (list[i] == element) return true
        }

        return false
         */
    }
}
