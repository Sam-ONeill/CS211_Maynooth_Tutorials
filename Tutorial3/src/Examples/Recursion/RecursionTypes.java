package Examples.Recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionTypes {

    // Linear recursion
    public int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    //Binary recursion
    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    //Multiple recursion


    // Define the Node class representing a node in the general tree
    public static class Node {
        int value;
        List<Node> children;

        // Node constructor
        public Node(int value) {
            this.value = value;
            this.children = new ArrayList<>();
        }

        // Method to add a child node to the current node
        public void addChild(Node child) {
            children.add(child);
        }
    }

    // treeSize method calculates the size of a tree rooted at the given node
    public static int treeSize(Node node) {
        if (node == null) {
            return 0;
        }
        int size = 1;
        for (Node child : node.children) {
            size += treeSize(child);
        }
        return size;
    }

    // Tail recursion
    public int Tail_factorial(int n) {
        return factorialHelper(n, 1);
    }

    private int factorialHelper(int n, int accumulator) {
        if (n == 0) {
            return accumulator;
        }
        return factorialHelper(n - 1, n * accumulator);
    }



    // The main method demonstrates the usage of the treeSize method
    public static void main(String[] args) {
        // Create a tree with the following structure:
        //         1
        //        / \
        //       2   3
        //      /   /
        //     4   5
        //        /
        //       6
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        // Build the tree by connecting nodes
        root.addChild(node2);
        root.addChild(node3);
        node2.addChild(node4);
        node3.addChild(node5);
        node5.addChild(node6);

        // Calculate the tree size using the treeSize method
        int size = treeSize(root);
        // Output the tree size
        System.out.println("The size of the tree is: " + size);


    }
}
