package Stacks;

import java.util.ArrayDeque;
import java.util.Arrays;

public class StockSpan {
    public static void main(String[] args) {
        int[] arr = {13,15,12,14,16,8,6,4,10,30};
        int[] arr2 = {40,30,20,10};
        int[] arr3 = {30,20,25,28,27,29};

        int[] res = new int[arr.length];

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        res[0] = 1;
        stack.push(0);
        for( int i = 1;i<arr.length;i++ ){
            while( !stack.isEmpty() && arr[i] >= arr[stack.peek()] ){
                stack.pop();
            }
            int span = stack.isEmpty() ? i+1 : i - stack.peek();
            res[i] = span;
            stack.push(i);
        }
        System.out.println(Arrays.toString(res));
    }
    
}
