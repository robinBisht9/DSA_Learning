package Arrays;

import java.util.Arrays;

public class LeftRotateD {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int d = 3;

        reverse(arr,0,d-1);
        reverse(arr,d,arr.length-1);
        reverse(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));

        
    }

    public static void reverse(int[] arr,int a, int b){
        int left = a;
        int right = b;
        int temp = 0;
        while( left < right ){
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
