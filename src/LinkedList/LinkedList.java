package LinkedList;

public class LinkedList {
    Node head;
    public LinkedList(){
        this.head = null;
    }
    public LinkedList(Node head){
        this.head = head;
    }
    public void add(Node value){
        Node temp = this.head;
        if( this.head == null ){
            this.head = value;
            return;
        }
        while( temp.next != null ){
            temp = temp.next;
        }
        temp.next = value;
    }
    public void displayLL(){
        Node temp = this.head;
        if( temp == null ) return;
        while( temp.next != null ){
            System.out.printf("%d -> ",temp.data);
            temp = temp.next;
        }
        System.out.printf("%d\n",temp.data);
    }
    public void insertAtStart(Node value){
        Node temp = this.head;
        value.next = temp;
        this.head = value;
    }
    public void deleteHead(){
        if( this.head == null ) return;
        this.head = this.head.next;
    }
    public void deleteLastNode(){
        if( this.head == null ) return;
        if( this.head.next == null ){
            this.head = null;
            return;
        }
        Node temp = this.head;
        while( temp.next.next != null ){
            temp = temp.next;
        }
        temp.next = null;
    }
    public void insertAt(int index,int data){
        Node dataNode = new Node(data);
        Node prev = null;
        Node curr = this.head;
        if( this.head == null && index > 0 ){
            return;
        }
        if( index == 0 ){
            dataNode.next = this.head;
            this.head = dataNode;
            return;
        }
        int counter = 0;
        while( curr != null ){
            if( counter == index ) break;
            counter++;
            prev = curr;
            curr = prev.next;

        }
        if( curr == null && counter != index ) return;
        prev.next = dataNode;
        dataNode.next = curr;

    }
    
}
