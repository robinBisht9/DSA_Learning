package Greedy;

import java.util.PriorityQueue;

public class HuffmanCoding {
    public static void main(String[] args) {
        char[] characters = new char[]{'a','d','e','f'};
        int[] freq = new int[]{30,40,60,80};
        Node root = huffmanCoding(characters, freq);
        printCodes(root,"");
    }
    static class Node{
        char ch;
        int frequency;
        Node left;
        Node right;
        public Node(char ch, int frequency,Node left,Node right){
            this.ch = ch;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }
    }
    public static Node huffmanCoding(char[] arr, int[] freq){
        PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2)->n1.frequency - n2.frequency);
        for( int i = 0;i<arr.length;i++){
            pq.add(new Node(arr[i],freq[i],null,null));
        }
        while( pq.size() > 1 ){
            Node left = pq.poll();
            Node right = pq.poll();
            pq.add(new Node('$',left.frequency+right.frequency,left,right));
        }
        return pq.poll();
    }
    public static void printCodes(Node root,String st){
        if( root == null ) return;
        if( root.ch != '$' ){
            System.out.println(root.ch+"-> "+st);
        }
        printCodes(root.left, st+"0");
        printCodes(root.right, st+"1");
    }
}
