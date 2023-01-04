package Arrays;

import java.util.Arrays;

public class RemoveSortedDuplicates {
    public static void main(String[] args) {
        int[] arr2= {10,20,20,30,30,30,30,40,50,60,60};
        int[] arr = {10,10,10};

        int curr = -1;
        for(int i = 1;i<arr.length;i++){
            if( curr == -1 ){
                if( arr[i] == arr[i-1] ){
                    curr = i-1;
                    arr[i] = -1;
                }
            }
            else{
                if( arr[i] == arr[curr] ){
                    arr[i] = -1;
                }
                else{
                    curr++;
                    arr[curr] = arr[i];
                    arr[i] = -1;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
