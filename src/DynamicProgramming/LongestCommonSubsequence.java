package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        String one = "ABCDGH";
        String two = "AEDFHR";
        int[][] memo = new int[one.length()+1][two.length()+1];
        Arrays.stream(memo).forEach( arr -> Arrays.fill(arr,-1) );
        System.out.println(longestCommonSubsequence(one, two,one.length()-1,two.length()-1,memo));
        System.out.println(sb.toString());
    }
    public static int longestCommonSubsequence(String one,String two,int t, int b,int[][] memo){
        if( t<0 || b < 0 ) return 0;
        if( memo[t][b] != -1 ) return memo[t][b];
        int res = 0;
        if( one.charAt(t) == two.charAt(b) ){
            sb.append(one.charAt(t));
            res = 1+longestCommonSubsequence(one, two, t-1, b-1,memo);
        }
        else{
            int second = 0;
            int third = 0;
            second = longestCommonSubsequence(one, two,t-1, b,memo);
            third = longestCommonSubsequence(one, two, t, b-1,memo);
            res = Math.max(second,third);
        }
        memo[t][b] = res;
        return res;

    }
}
