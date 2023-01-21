package Hashing;

import java.util.HashMap;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        int[] arr1 = {1,9,3,4,2,20};
        int[] arr2 = {8,20,7,30};
        int[] arr3 = {20,30,40};

        System.out.println("Longest common subsequence length -> : "+longestCommonSubsequenceLength(arr3));
    }
    public static int longestCommonSubsequenceLength(int[] arr){
        HashMap<Integer,Boolean> storeNumbers = new HashMap<>();
        for( int i: arr ){
            storeNumbers.put(i, true);
        }
        int curr = 0;
        int max = 0;
        for( int i = 0;i<arr.length && storeNumbers.get(arr[i]) ; i++){
            curr = 1;
            int val = arr[i];
            while( storeNumbers.containsKey(val+1) ){
                curr++;
                val++;
                storeNumbers.replace(val, false);
            }
            max = Math.max(max, curr);
        }
        return max;
    }
    
}
