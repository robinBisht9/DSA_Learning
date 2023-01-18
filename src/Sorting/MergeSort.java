package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {10,5,8,20,15,4,1,3};

        mergeSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr,int low,int end){
        if(  low<end ){
            int mid = low+(end-low)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr,mid+1, end);
            merge(arr, low, mid,end);
        }
    }
    public static void merge(int[] arr,int low,int mid,int high){
        int[] left = new int[mid-low+1];
        int[] right = new int[high-mid];
        for( int i = 0;i<(mid-low+1);i++ ) {left[i] = arr[low+i];}
        for( int i = 0;i<(high-mid);i++ ) {right[i] = arr[mid+1+i];}

        int i = 0,j=0,k=low;
        while( i<(mid-low+1) && j<(high-mid) ){
            if( left[i] > right[j] ){
                arr[k++] = right[j++];
            }
            else if( left[i] < right[j] ){
                arr[k++] = left[i++];
            }
            else{
                arr[k++] = left[i++];
                arr[k++] = right[j++];
            }
        }
        while( i < (mid-low+1) ){
            arr[k++] = left[i++];
        }
        while( j<(high-mid) ){
            arr[k++] = right[j++];
        }


    }
    
}
