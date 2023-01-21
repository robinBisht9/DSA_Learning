package Hashing;

import java.util.HashMap;

public class LongestSubarrayEqualZeroOne {
    public static void main(String[] args) {
        int[] arr1 = {1,1,1,1};
        int[] arr2 = {1,0,1,1,1,0,0};
        int[] arr3 = {0,0,1,1,1,1,1,0};

        System.out.println("Longest Subarray with equal zero and one -> : "+longestSubarrayEqualZeroOne(arr2));

    }

    public static int longestSubarrayEqualZeroOne(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i] = arr[i] == 0 ? -1 : 1;
        }
        return findZeroSum(arr);
    }
    public static int findZeroSum(int[] arr){
        int ans = 0;
        int sum = 0;
        HashMap<Integer,Integer> numberCount = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if( sum == 0 ){
                ans = Math.max(ans, i+1 );
            }
            else if( numberCount.containsKey(sum) ){
                ans = Math.max(ans, i-numberCount.get(sum) );
            }
            numberCount.putIfAbsent(sum, i);
        }
        return ans;
    }
    
}
