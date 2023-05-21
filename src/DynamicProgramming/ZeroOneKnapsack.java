package DynamicProgramming;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] value = new int[]{10,40,30,50};
        int[] weight = new int[]{5,4,6,3};
        int W = 10;
        int[] value2 = new int[]{60,100,120};
        int[] weight2 = new int[]{10,20,30};
        int W2 = 50;
        int[] value3 = new int[]{30,20};
        int[] weight3 = new int[]{3,4};
        int W3 = 6;
        System.out.println(zeroOneKnapsackDP(value, weight,W));
        System.out.println(zeroOneKnapsackDP(value2, weight2,W2));
        System.out.println(zeroOneKnapsackDP(value3,weight3,W3));
    }
    //O(2^n)
    public static int zeroOneKnapsack(int[] value,int[] weight, int W,int n){
        if( n < 0 || W == 0 ) return 0;

        if( weight[n] > W ) return zeroOneKnapsack(value, weight, W, n-1);

        int taken = zeroOneKnapsack(value, weight, W-weight[n], n-1);
        int notTaken = zeroOneKnapsack(value, weight, W, n-1);
        return Math.max(taken+value[n], notTaken);
    }
    public static int zeroOneKnapsackDP(int[] value,int[] weight, int W){
        int[][] dp = new int[value.length+1][W+1];
        for(int i = 1;i<=value.length;i++){
            for( int j=1;j<=W;j++ ){
                if( weight[i-1] > j ){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max( dp[i-1][j-weight[i-1]]+value[i-1], dp[i-1][j]);
                }
            }
        }

        return dp[value.length][W];

    }
}
