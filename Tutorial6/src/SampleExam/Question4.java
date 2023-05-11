package SampleExam;

public class Question4 {

   public static class Node {
        public int data;
        public Node prev;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static Node reverseNormal(Node head) {
        Node current = head;
        Node temp = null;
        while (current != null) {
            // swap prev and next pointers for current node
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            // move to the next node
            current = current.prev;
        }
        // update the head of the reversed list
        if (temp != null) {
            head = temp.prev;
        }
        return head;
    }

    public static Node reverse(Node node) {
        // Base case
        if (node == null || node.next == null) {
            return node;
        }

        // Reverse the rest of the list
        Node reversed = reverse(node.next);

        // Swap prev and next pointers for current node
        node.next.next = node;
        node.prev = node.next;
        node.next = null;

        return reversed;
    }



}
