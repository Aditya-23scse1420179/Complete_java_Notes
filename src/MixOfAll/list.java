package MixOfAll;

public class list {
    public static void main(String[] args) {
        // Create the first node (head)
        Node head = new Node(10);

        // Link the second node
        head.next = new Node(20);

        // Link the third node
        head.next.next = new Node(30);

        // Link the fourth node
        head.next.next.next = new Node(40);

        // Print the linked MixOfAll.list
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
