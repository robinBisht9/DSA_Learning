package Sorting;

import java.util.Arrays;

import Swap.SwapInArray;

public class HoareParitiion {
    public static void main(String[] args) {
        int[] arr = {20,15,18,5,4,2,7};

        
        //pivot is the last element
        // j and less are smaller that j+1
        int j = hoareParition(arr,0,arr.length-1);
    
        System.out.println(Arrays.toString(arr));
        System.out.println(j);
    }

    public static int hoareParition(int[] arr,int l,int h){
        int pivot = arr[l];
        int i = l-1,j=h+1;

        while(true){
            do{
                i++;
            }while( arr[i] < pivot );
            do{
                j--;
            }while( arr[j] > pivot );

            if( i>=j ) return j;
            SwapInArray.swap(arr, i, j);

        }


    }
    
}
