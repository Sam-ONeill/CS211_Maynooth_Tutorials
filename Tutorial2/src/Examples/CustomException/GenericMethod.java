package Examples.CustomException;

public class GenericMethod {

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
    public static void main(String args[]) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArr = { 1.1, 2.2, 3.3 };
        String[] stringArray = {"hello", "world"};
        printArray(intArray);
        printArray(doubleArr); // Output: 1.1 2.2 3.3
        printArray(stringArray);
    }
}
