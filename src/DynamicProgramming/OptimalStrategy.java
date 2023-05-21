package DynamicProgramming;

public class OptimalStrategy {
    public static void main(String[] args) {
        int[] arr = new int[]{20,5,4,6};
        int[] arr2 = new int[]{2,3,15,7};
        
        System.out.println(optimalStrategy(arr));
        System.out.println(optimalStrategy(arr2));
    }

    public static int optimalStrategy(int[] arr,int i, int j){
        if( i+1 == j ) return Math.max(arr[i], arr[j]);

        int opponentChoiceOne = optimalStrategy(arr, i+2, j);
        int opponentChoiceTwo = optimalStrategy(arr, i+1, j-1);
        int opponentChoiceThree = optimalStrategy(arr,i, j-2);
        int opponentChoiceFour = optimalStrategy(arr,i+1, j-1);

        return Math.max(arr[i]+Math.min(opponentChoiceOne, opponentChoiceTwo), arr[j]+Math.min(opponentChoiceThree, opponentChoiceFour));

    }
    public static int optimalStrategy(int[] arr){
        int[][] dp = new int[arr.length][arr.length];
        for( int i = 0;i<arr.length-1;i++ ){
            dp[i][i+1] = Math.max(arr[i],arr[i+1]);
        }
        for( int gap = 3;gap<arr.length;gap+=2  ){
            for( int i = 0;i+gap<arr.length; i++ ){
                int j = i+gap;
                int one = arr[i]+Math.min(dp[i+2][j], dp[i+1][j-1]);
                int two = arr[j]+Math.min(dp[i][j-2],dp[i+1][j-1]);
                dp[i][j] = Math.max(one, two);
            }
        }

        return dp[0][arr.length-1];
    }
}
