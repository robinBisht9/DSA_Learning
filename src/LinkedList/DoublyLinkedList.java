package LinkedList;

public class DoublyLinkedList {
    DoubleNode head;
    public DoublyLinkedList(){
        this.head = null;
    }
    public DoublyLinkedList(DoubleNode head){
        this.head = head;
    }
    public void insertAtFront(int data){
        DoubleNode newNode = new DoubleNode(data);
        if( this.head == null ){
            this.head = newNode;
            return;
        }
        DoubleNode temp = this.head;
        newNode.next = temp;
        temp.prev = newNode;
        this.head = newNode;
    }
    public void add(int data){
        DoubleNode newNode = new DoubleNode(data);
        if( this.head == null ){
            this.head = newNode;
            return;
        }
        DoubleNode temp = this.head;
        while( temp.next != null ){
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }
    public void displayLL(){
        DoubleNode temp = this.head;
        if( temp == null ) return;
        while( temp.next != null ){
            System.out.printf("%d -> ",temp.data);
            temp = temp.next;
        }
        System.out.printf("%d\n",temp.data);
    }
    public void reverse(){
        if( this.head == null ) return;
        DoubleNode temp = this.head;
        while( temp != null ){
            DoubleNode mid = temp.next;
            temp.next = temp.prev;
            temp.prev = mid;
            if( mid == null ){
                this.head = temp;
                break;
            }
            temp = mid;
        }

    }
}
