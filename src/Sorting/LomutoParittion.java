package Sorting;

import java.util.Arrays;

import Swap.SwapInArray;

public class LomutoParittion {
    public static void main(String[] args) {
        int[] arr = {20,15,18,5,4,2,7};

        //pivot is the last element
        lomutoParition(arr,0,arr.length-1);

    System.out.println(Arrays.toString(arr));
    }
    public static void lomutoParition(int[] arr,int l,int h){
        int pivot = arr[h];
        int i = l-1;
        for( int j = l;j<h;j++ ){
            if( arr[j] < pivot ){
                i++;
                SwapInArray.swap(arr, j, i);
            }
        }
        SwapInArray.swap(arr, h, ++i);
    }
    
}
