package LinkedList;

public class MergeSortedLinkedList {
    public static void main(String[] args) {
        Node headA = new Node(10);
        headA.next = new Node(20);
        headA.next.next = new Node(30);

        Node headB = new Node(40);
        headB.next = new Node(50);
        headB.next.next = new Node(25);

        Node newHead = mergeSorted(headA,headB);

        printLL(newHead);
    }

    public static Node mergeSorted(Node headA,Node headB){
        if( headA == null ) return headB;
        if( headB == null ) return headB;

        Node head = null,tail = null;

        if( headA.data <= headB.data ){
            head = tail = headA;
            headA = headA.next;
        }
        else{
            head = tail = headB;
            headB = headB.next;
        }

        while( headA != null && headB != null ){
            if( headA.data <= headB.data ){
                tail.next = headA;
                tail = headA;
                headA = headA.next;
            }
            else{
                tail.next = headB;
                tail = headB;
                headB = headB.next;
            }
        }
        if( headA == null ){
            tail.next = headB;
        }
        else{
            tail.next = headA;
        }

        return head;
    }

    public static void printLL(Node head){
        Node temp = head;
        if( temp == null ) return;
        while( temp.next != null ){
            System.out.printf("%d -> ",temp.data);
            temp = temp.next;
        }
        System.out.printf("%d\n",temp.data);
    }
    
}
