package LinkedList;

import java.util.HashMap;
import java.util.Hashtable;

public class LRUCache {

    int capacity;
    DoubleNode head = null;
    HashMap<Integer,DoubleNode> lookup = new HashMap<>();
    public LRUCache(int capacity){
        this.capacity = capacity;
    }
    public void insert(int data){
        if( lookup.size() == 0 ){
            DoubleNode curr = new DoubleNode(data);
            lookup.put(data, curr);
            this.head = curr;
            return;
        }
        if( lookup.containsKey(data) ){
            DoubleNode curr = lookup.get(data);
            if( curr.prev == null ){
                return;
            }
            curr.prev.next = curr.next;
            if( curr.next != null ){
                curr.next.prev = curr.prev;
            }
            curr.prev = null;
            curr.next = this.head;
            this.head.prev = curr;
            this.head = curr;
            return;
        }
        if( lookup.size() <= capacity ){
            DoubleNode curr = new DoubleNode(data);
            curr.next = this.head;
            this.head.prev = curr;
            this.head = curr;
            lookup.put(data,curr);
        }
        if( lookup.size() > capacity ){
            DoubleNode temp = this.head;
            while( temp.next != null ){
                temp = temp.next;
            }
            temp.prev.next = null;
            temp.prev = null;
            lookup.remove(temp.data);
        }
        
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

    
}
