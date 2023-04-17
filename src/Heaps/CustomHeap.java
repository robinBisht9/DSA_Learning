package Heaps;

import java.util.Arrays;

public class CustomHeap {
    private int[] heap;
    private int capacity;
    private int size;

    public CustomHeap(int capacity){
        heap = new int[capacity];
        this.capacity = capacity;
    }
    public void print(){
        System.out.println(Arrays.toString(heap));
    }

    public void insert(int data){
        if( size == capacity ) return;
        size++;
        heap[size-1] = data;
        for( int i = size-1 ; i != 0 && heap[parent(i)] > heap[i]; ){
            int parentOfI = parent(i);
            swap(i, parentOfI );
            i = parent(i);
        }
    }
    public void buildHeap(int[] arr){
        int arrSize = arr.length;
        for(int i = (size-2)/2; i>=0;i-- ){
            heapify(i);
        }
    }
    public int getMin(){
        return heap[0];
    }
    public int extractMin(){
        int data = heap[0];
        heap[0] = heap[size-1];
        heap[size-1] = 0;
        heapify(0);
        return data;
    }

    private void heapify(int ind){
        if( ind >= size ) return;
        int lef = left(ind);
        int ri = right(ind);

        int min = ind;
        if( lef < size && heap[lef] < heap[min] ){
            min = lef;
        }
        if( ri < size && heap[ri] < heap[min] ){
            min = ri;
        }
        if( min != ind ){
            swap(ind, min);
            heapify(min);
        }

    }

    private int parent(int index){
        return  (index - 1)/2 ;
    }
    private int left(int index){
        return 2*index+1;
    }
    private int right(int index){
        return 2*index+2;
    }
    private void swap(int first,int second){
        int mid = heap[first];
        heap[first] = heap[second];
        heap[second] = mid;
    }
}
