package Maths;

import java.util.Scanner;

public class PrimeFactors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        printPrimeFactors(num);
        sc.close();
    }

    public static void printPrimeFactors(int n){
        if( n <= 1 ) return;

        for( int i = 2;i*i<n;i++ ){
            while( n%i == 0 ){
                System.out.printf("%d ",i);
                n = n/i;
            }
        }

        if( n > 1 ){
            System.out.println(n);
        }

    }
    
}
