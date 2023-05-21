package DynamicProgramming;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {10,3,2,5,6};
        int sum = 8;
        int store = subsetSum(arr, sum);
        System.out.println(store);
    }
    public static int subsetSum(int[] arr,int sum,int n){
        if( n < 0 ) return sum == 0 ?1: 0;

        return subsetSum(arr, sum-arr[n], n-1)+subsetSum(arr, sum, n-1);

    }
    public static int subsetSum(int[] arr,int sum){
        int[][] dp = new int[arr.length+1][sum+1];
        for( int i = 0;i<dp.length;i++ ){
            dp[i][0] = 1; 
        }
        for( int i = 1;i<dp.length;i++ ){
            for( int j = 1;j<dp[0].length;j++){
                dp[i][j] = dp[i-1][j];
                if( j >= arr[i-1] ){
                    dp[i][j] += dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[arr.length][sum];

    }
}
