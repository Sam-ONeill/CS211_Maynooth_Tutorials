package Examples.CustomException;

import java.util.ArrayList;
import java.util.List;

public class MyList<T> {
    private List<T> list = new ArrayList<T>();

    public void add(T object) {
        list.add(object);
    }

    public T get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }

    public static void main(String args[]){
        MyList<Integer> myList = new MyList<Integer>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        System.out.println(myList.get(0)); // Output: 1
        System.out.println(myList.get(1)); // Output: 2
        System.out.println(myList.get(2)); // Output: 3
        System.out.println("Size: "+myList.size()); // Output: 3

        System.out.println(); // Output: 3

        MyList<Character> myList2 = new MyList<Character>();
        myList2.add('a');
        myList2.add('b');
        myList2.add('c');
        System.out.println(myList2.get(0)); // Output: a
        System.out.println(myList2.get(1)); // Output: b
        System.out.println(myList2.get(2)); // Output: c
        System.out.println("Size: "+ myList.size()); // Output: 3


    }
}
