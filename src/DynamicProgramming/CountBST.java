package DynamicProgramming;

public class CountBST {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(countBST(n));
    }

    public static int countBST(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        if( n >= 1 ){
            dp[1] = 1;
        }
        for(int i = 2;i<=n;i++){
            for(int j = 0;j<i;j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }

        return dp[n];
    }
}
