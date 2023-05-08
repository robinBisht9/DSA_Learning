package DynamicProgramming;

import java.util.ArrayList;

public class LongesIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {4,10,6,5,8,11,2,20};

        System.out.println(longestIncreasingSubsequence(arr));

    }
    public static int longestIncreasingSubsequenceDP(int[] arr){
        int[] lis = new int[arr.length];

        for( int i = 0;i<lis.length;i++ ){
            lis[i] = 1;
            for( int j = i-1;j>=0;j-- ){
                if( arr[i] > arr[j] ){
                    lis[i] = Math.max(lis[i],lis[j]+1);
                }
            }
        }
        int res = lis[0];
        for( int i = 1;i<lis.length;i++ ){
            res = Math.max(res,lis[i]);
        }
        return res;
    }
    //O(NLogN)
    public static int longestIncreasingSubsequence(int[] arr){
        int[] tail = new int[arr.length];
        int len = 1;
        tail[0] = arr[0];
        for( int i = 1;i<arr.length;i++ ){
            if( arr[i] > tail[len-1] ){
                tail[len++] = arr[i];
            }
            else{
                int c = binarySearchAndAdd(tail,len-1,arr[i]);
                tail[c] = arr[i];
            }
        }
        return len;
    }
    public static int binarySearchAndAdd(int[] tail,int r,int k){
        int l = 0;
        int mid = 0;
        while( l < r ){
            mid = l + ((r-l)/2);
            if( tail[mid] >= k ){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        return r;
    }
}
