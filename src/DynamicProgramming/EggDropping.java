package DynamicProgramming;

public class EggDropping {
    public static void main(String[] args) {
        int egg = 2 , floor = 10;   
        System.out.println(minAttemptsDP(egg, floor));
    }
    public static int minAttempts(int egg,int floor){
        if( egg == 1 || floor == 1 || floor == 0) return floor;

        int min = Integer.MAX_VALUE;
        int res = 0;
        for( int i = 1;i<=floor;i++ ){
            res =  Math.max( minAttempts(egg-1, i-1) , minAttempts(egg, floor-i) );
            if( res < min ) min = res;
        }
        return min+1;
    }
    public static int minAttemptsDP(int egg,int floor){
        int[][] dp = new int[floor+1][egg+1];
        
        for( int i = 1;i<=floor;i++){
            dp[i][1] = i;
        }
        for( int i = 2;i<=egg;i++ ){
            dp[1][i] = 1;
        }
        for(int i = 2;i<=floor;i++){
            for( int j = 2;j<=egg;j++ ){
                dp[i][j] = Integer.MAX_VALUE;
                for( int x = 1;x<=i;x++ ){
                    dp[i][j] = Math.min(dp[i] [j], 1+Math.max(dp[x-1][j-1],dp[i-x][j])  );
                }
            }
        }

        return dp[floor][egg];

    }
}
