package LinkedList;

public class TraverseLinkedList {
    public static void main(String[] args) {
        // LinkedList ll = new LinkedList();
        // Node first = new Node(10);
        // ll.add(first);
        // ll.add(new Node(30));
        // ll.add(new Node(40));
        // ll.insertAtStart(new Node(120));
        // ll.add(new Node(80));
        // ll.add(new Node(1900));
        // ll.deleteHead();
        // ll.deleteLastNode();
        // ll.insertAt(2, 81);
        // ll.displayLL();

        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtFront(30);
        dll.insertAtFront(40);
        dll.insertAtFront(12);
        dll.insertAtFront(90);
        dll.add(109);

        dll.displayLL();
        dll.reverse();
        dll.displayLL();

    }
    
}
