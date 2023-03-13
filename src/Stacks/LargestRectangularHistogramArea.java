package Stacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class LargestRectangularHistogramArea {
    public static void main(String[] args) {
        //Given height of adjacent blocks with unit width, find the largest rectangular area
        int[] arr = {6,2,5,4,1,5,6};
        int[] prev = previousSmaller(arr);
        int[] next = nextSmaller(arr);

        int res = 0;
        for( int i = 0;i<arr.length;i++ ){
            int curr = arr[i];
            curr += ( i - prev[i] - 1)*arr[i];
            curr += ( next[i] - i -1 )*arr[i];
            res = Math.max(curr,res);
        }
        System.out.println("Largest Area for histogram is : "+res);

    }
    public static int[] previousSmaller(int[] arr){
        int[] res = new int[arr.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        res[0] = -1;
        for( int i = 1;i<arr.length;i++){
            while( !stack.isEmpty() && arr[stack.peek()] >= arr[ i ] ){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return res;

    }
    public static int[] nextSmaller(int[] arr){
        int[] res = new int[arr.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(arr.length-1);
        res[res.length-1] = res.length;
        for( int i = arr.length-2;i>=0;i--){
            while( !stack.isEmpty() && arr[stack.peek()] >= arr[ i ] ){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        Collections.reverse(Arrays.asList(res));
        return res;
    }
    
}
