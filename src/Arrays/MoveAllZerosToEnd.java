package Arrays;

import java.util.Arrays;

import Swap.SwapInArray;

public class MoveAllZerosToEnd {
    public static void main(String[] args) {
        int[] arrN = {8,5,0,20,0,0,1,0};
        int[] arr = {0,0,10,0,2,0};

        int curr = -1;
        for(int i=0;i<arr.length;i++){
            if( arr[i] == 0 && curr == -1){
                curr = i;
                continue;
            }
            if( arr[i]!=0 && curr != -1 ){
                SwapInArray.swap(arr, i, curr);
                curr++;
            }

        }

        System.out.println(Arrays.toString(arr));
    }
}
