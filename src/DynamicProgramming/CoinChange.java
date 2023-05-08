package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coinSupply = new int[]{2,5,3,6};
        int k = 10;
        int[][] memo = new int[coinSupply.length+1][k+1];
        Arrays.stream(memo).forEach( arr -> Arrays.fill(arr,-1) );
        System.out.println(coinChangeDP(coinSupply,k,coinSupply.length-1,memo));
    }
    public static int coinChange(int[] coinSupply,int k,int s){
        if( k < 0 || s < 0 ) return 0;
        if( k == 0 ) return 1;
        int one = coinChange(coinSupply, k-coinSupply[s], s);
        int two = coinChange(coinSupply, k, s-1);

        return one+two;
    }
    public static int coinChangeDP(int[] coinSupply,int k,int s,int[][] memo){
        if( k < 0 || s < 0 ) return 0;
        if( k == 0 ) return 1;
        if( memo[s][k] != -1 ) return memo[s][k];
        int one = coinChange(coinSupply, k-coinSupply[s], s);
        int two = coinChange(coinSupply, k, s-1);
        memo[s][k] = one+two;
        return memo[s][k];
    }
}
