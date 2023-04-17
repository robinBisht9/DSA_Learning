package Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Heaps {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<Integer>(Arrays.asList(10,20,30)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(5,15)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(1,9,11,18)));
        System.out.println(mergeKSortedArray(matrix));;

    }
    public static int purchaseMaximumItems(int[] cost,int sum){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0;i<cost.length;i++ ){
            pq.add(cost[i]);
        }
        int ans = 0;
        while( sum > 0 ){
            int value = pq.poll();
            sum -= value;
            if( sum >= 0 ) ans++;
        }
        return ans;
    }
    public static ArrayList<Integer> mergeKSortedArray(ArrayList<ArrayList<Integer>> matrix){
        PriorityQueue<Triplet> pq = new PriorityQueue<>((t1,t2) -> t1.getValue() - t2.getValue());
        ArrayList<Integer> arl = new ArrayList<>();
        for( int i =0;i<matrix.size();i++ ){
            pq.add(new Triplet(matrix.get(i).get(0), i, 0));
        }
        while( !pq.isEmpty() ){
            Triplet mid = pq.poll();
            arl.add(mid.getValue());
            int row = mid.getRowPosition();
            int col = mid.getArrPosition();
            if( col+1 < matrix.get(row).size() ){
                pq.add(new Triplet(matrix.get(row).get(col+1), row, col+1));
            }
        }
        return arl;

    }
    static class Triplet{
        int value;
        int rowPosition;
        int arrPosition;
        public Triplet(int value,int rowPosition,int arrPosition){
            this.value = value;
            this.rowPosition = rowPosition;
            this.arrPosition = arrPosition;
        }
        public int getValue(){ return this.value;}
        public int getRowPosition(){ return this.rowPosition;}
        public int getArrPosition(){ return this.arrPosition;}
    }
}
