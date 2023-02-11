package LinkedList;

public class LinkedList {
    Node head;
    public LinkedList(){
        this.head = null;
    }
    public LinkedList(Node head){
        this.head = head;
    }
    public void add(int data){
        Node value = new Node(data);
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
    public void sortedInsert(int data){
        Node temp = new Node(data);
        if( this.head == null ){
            this.head = temp;
            return;
        }
        if( data <= this.head.data ){
            temp.next = this.head;
            this.head = temp;
            return;
        }
        Node traverse = this.head;
        while( traverse.next != null && data > traverse.next.data ){
            traverse = traverse.next;
        }
        temp.next = traverse.next;
        traverse.next = temp;
        
    }
    public int findMiddle(){
        if( this.head == null ) return -1;
        Node fast = this.head;
        Node slow = this.head;
        while( fast.next != null && fast.next.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }
    public int NFromEnd(int n){
        if( this.head == null) return -1;
        Node fast = this.head;
        Node slow = null;

        int i = 1;
        while( i < n && fast != null ){
            fast = fast.next;
            i++;
        }
        if( fast == null ) return -1;

        slow = this.head;
        while( fast.next != null ){
            fast = fast.next;
            slow = slow.next;
        }

        return slow.data;

    }
    public void reverse(){
        if( this.head == null || this.head.next == null ) return;
         Node prev = null;
         Node curr = this.head;
         
         while( curr != null ){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
         }
         this.head = prev;
    }
    public void reverseRecursive(){
        if( this.head == null ) return;

        this.head = this.recursiveReverse(this.head);

    }
    public Node recursiveReverse(Node curr){
        if( curr.next == null ) return curr;
        Node head = recursiveReverse(curr.next);
        Node next = curr.next;
        next.next = curr;
        curr.next = null;
        return head;
    }

    public void reverseKNodes(int k){
        this.head = reverseK(this.head, k);
    }
    public Node reverseK(Node head,int k){
        Node curr = head, next = null,prev = null;
        int count = 0;
        while( curr != null && count < k ){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if( next != null ){
            Node rest_head = reverseK(next, k);
            head.next = rest_head;
        }
        return prev;
    }

    public void pairWiseSwap(){
        Node curr = this.head,prev = null;

        while( curr != null && curr.next != null ){
            Node next = curr.next;
            curr.next = curr.next.next;
            next.next = curr;
            if( prev != null ){
                prev.next = next;
            }
            else{
                this.head = next;
            }
            prev = curr;
            curr = curr.next;
        }
        
    }
    
}
