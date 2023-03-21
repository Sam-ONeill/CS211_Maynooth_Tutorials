package Examples.CustomException;

import java.util.List;

public class GenericWildcards {
    //This example defines a method sum that takes a list of any subtype of Number.
    // Because the wildcard is upper bounded, you can pass in a list of integers, doubles, or any other number subtype.

    public static double sum(List<? extends Number> nums) {
        double sum = 0.0;
        //The method iterates over the list and calculates the sum of the numbers.
        for (Number num : nums) {
            sum += num.doubleValue();
        }
        return sum;
    }

    //This example defines a method addNumbers that takes a list of any supertype of Integer.
    //Because the wildcard is lower bounded, you can pass in a list of integers, numbers, objects, or any supertype of Integer.
    public static void addNumbers(List<? super Integer> nums) {
        //The method adds the numbers 1, 2, and 3 to the list.
        nums.add(1);
        nums.add(2);
        nums.add(3);

    }
    //This example defines a method printList that takes a list
    // As its an unbounded wild card we can pass it any type of list and the method will run
    public static void printList(List<?> list) {
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }





}
