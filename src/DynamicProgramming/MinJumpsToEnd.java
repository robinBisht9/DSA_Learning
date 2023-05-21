package DynamicProgramming;

import java.util.Arrays;

public class MinJumpsToEnd {
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,2,1,2,1};
        int[] arr2 = new int[]{4,1,5,3,1,3,2,1,8};
        System.out.println(minJumpsDP(arr));
        System.out.println(minJumpsDP(arr2));
    }
    public static int minJumps(int[] arr,int n){
        if( n == arr.length-1 ) return 0;
        int min = Integer.MAX_VALUE;
        for( int i = 1;i<=arr[n];i++ ){
            int curr = n+i;
            if( curr < arr.length ){
                int res = minJumps(arr,curr);
                if( res!=Integer.MAX_VALUE ){
                    min = Math.min(min, res+1);
                }
            }
        }
        return min;
    }
    public static int minJumpsDP(int[] arr){
        int[] dp = new int[arr.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for( int i = 1;i<arr.length;i++ ){
            for( int j=0;j<i;j++ ){
                if( j+arr[j] >= i ){
                    if( dp[j] != Integer.MAX_VALUE ){
                        dp[i] = Math.min(dp[j]+1, dp[i]);
                    }
                }
            }
        }
        return dp[arr.length-1];
    }
}
