import SampleExam.Question4;

import java.util.Arrays;

import static SampleExam.Question3.createHashTable;
import static SampleExam.Question4.reverse;

public class Main {
    public static void main(String[] args) {

        // Question 4 example
        // Create a sample doubly linked list: 1 <-> 2 <-> 3 <-> 4 <-> 5
        Question4.Node head = new Question4.Node(1);
        Question4.Node node2 = new Question4.Node(2);
        Question4.Node node3 = new Question4.Node(3);
        Question4.Node node4 = new Question4.Node(4);
        Question4.Node node5 = new Question4.Node(5);

        head.next = node2;
        node2.prev = head;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;

        // Print the original doubly linked list
        System.out.println("Original Doubly Linked List:");
        Question4.Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");

        // Reverse the doubly linked list
        Question4.Node reversedCurrent = reverse(head);

        // Print the reversed doubly linked list
        System.out.println("\nReversed Doubly Linked List:");
        current = reversedCurrent;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");


        // Question 3 example
        int[] keys = {12, 44, 13, 88, 23, 94, 11, 39, 20, 16, 5};
        int[] hashTable = createHashTable(keys);

        System.out.println(Arrays.toString(hashTable));
    }
}