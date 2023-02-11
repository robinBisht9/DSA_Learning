package LinkedList;

public class TraverseLinkedList {
    public static void main(String[] args) {

        LRUCache lru = new LRUCache(4);
        lru.insert(10);
        lru.insert(20);
        lru.insert(10);
        lru.insert(30);
        lru.insert(40);
        lru.insert(50);
        lru.insert(30);
        lru.insert(40);
        lru.insert(60);
        lru.insert(30);
        lru.displayLL();

    }
    
}
