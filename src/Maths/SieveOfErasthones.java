package Maths;

import java.util.Arrays;
import java.util.Scanner;

public class SieveOfErasthones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        printPrimeLessThan(num);
        sc.close();

    }

    public static void printPrimeLessThan(int n){
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true );

        for( int i = 2;i*i<n;i++ ){
            if( isPrime[i] ){
                for( int j = 2;j*i<=n;j++ ){
                    isPrime[j*i] = false;
                }
            }
        }

        for( int i = 2;i<=n;i++ ){
            if( isPrime[i] ){
                System.out.printf("%d ",i);
            }
        }

    }
}