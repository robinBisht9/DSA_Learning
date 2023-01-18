package Sorting;

import java.util.Arrays;

import Swap.SwapInArray;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {20,15,18,5,4,2,7};

        qSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void qSort(int[] arr,int l,int h){
        if( l<h ){
            // int p = LPartition(arr, l, h);
            int p = hoareParition(arr, l, h);
            qSort(arr, l, p);
            qSort(arr, p+1, h);
        }
    }

    public static int LPartition(int[] arr,int l,int h){
        int pivot = arr[h];
        int i = l-1;
        for( int j = l;j<h;j++ ){
            if( arr[j] < pivot ){
                i++;
                SwapInArray.swap(arr, j, i);
            }
        }
        SwapInArray.swap(arr, h, ++i);
        return i;
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
