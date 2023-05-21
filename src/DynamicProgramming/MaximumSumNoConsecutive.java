package DynamicProgramming;

public class MaximumSumNoConsecutive {
    public static void main(String[] args) {
        int arr[] = new int[]{1,10,2};
        int[] arr2 = new int[]{8,7,6,10};
        int[] arr3 = new int[]{10,5,15,20,2,30};

        System.out.println(maximumSumNoConsecutive(arr));
        System.out.println(maximumSumNoConsecutive(arr2));
        System.out.println(maximumSumNoConsecutive(arr3));
    }
    public static int maximumSumNoConsecutive(int[] arr,int n){
        if( n == 1 ) return arr[0];
        else if( n == 2 ) return Math.max(arr[0], arr[1]);

        return Math.max( maximumSumNoConsecutive(arr, n-1) , maximumSumNoConsecutive(arr, n-2)+arr[n-1]);
    }
    public static int maximumSumNoConsecutive(int[] arr){
        int[] dp = new int[arr.length+1];
        dp[0] = 0;
        dp[1] = arr[0];
        for( int i=2;i<=arr.length;i++ ){
            dp[i] = Math.max(dp[i-1], dp[i-2]+arr[i-1]);
        }
        return dp[arr.length];
    }
    
}
