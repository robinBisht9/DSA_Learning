package DynamicProgramming;

import java.util.Arrays;

public class MinimumCoinChange {
    public static void main(String[] args) {
        int[] coins = new int[]{25,10,5};
        int[] coinsTwo = new int[]{9,6,5,1};
        int value = 30;
        int valueTwo = 11;
        System.out.println(coinChange(coinsTwo,valueTwo,coinsTwo.length));
        System.out.println(coinChangeDP(coinsTwo,valueTwo));

    }
    public static int coinChange(int[] coins,int value,int n){
        if( value == 0 ) return 0;
        int res = Integer.MAX_VALUE;
        for( int i = 0;i<n;i++ ){
            if( coins[i] <= value ){
                int sub_res = coinChange(coins, value-coins[i], n);
                if( sub_res != Integer.MAX_VALUE ){
                    res = Math.min(res, sub_res+1);
                }
            }
        }
        return res;
    }
    public static int coinChangeDP(int[] coins,int value){
        int[] table = new int[value+1];
        Arrays.fill(table,Integer.MAX_VALUE);
        table[0] = 0;
        for( int i = 1;i<=value;i++ ){
            for( int j=0;j<coins.length;j++ ){
                if( coins[j] <= i ){
                    if( table[i-coins[j]] != Integer.MAX_VALUE  ){
                        table[i] = Math.min(table[i],table[i-coins[j]]+1);
                    }
                }
            }
        }
        return table[value];
    }
}
