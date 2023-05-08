package DynamicProgramming;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int N = 54;
        long[] memo = new long[N+1];
        Arrays.fill(memo,-1);
        System.out.println(fibonacciTabulation(N));

    }
    public static long fibonacciDP(int N,long[] memo ){
        if( memo[N] != -1 ) return memo[N];
        long res = 0;
        if( N == 0 || N == 1 ){
            res = N;
        }
        else{
            res = fibonacciDP(N-1, memo) + fibonacciDP(N-2, memo);
        }
        memo[N] = res;
        return res;

    }
    public static long fibonacciTabulation(int N){
        long[] res = new long[N+1];
        res[0] = 0;
        res[1] = 1;
        for( int i = 2;i<=N;i++ ){
            res[i] = res[i-1] + res[i-2];
        }
        return res[N];
    }
    public static long fibonacci(int N){
        long res = 0;
        if( N == 0 || N == 1 ){
            res = N;
        }
        else{
            res = fibonacci(N-1) + fibonacci(N-2);
        }
        return res;

    }
}
