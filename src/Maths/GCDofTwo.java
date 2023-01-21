package Maths;

import java.util.Scanner;

public class GCDofTwo {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two digits:\n");
        int first = sc.nextInt();
        int second = sc.nextInt();
        int gcd = 0;
        
        gcd = first < second ? gcd(first, second) : gcd(second,first); 


        System.out.printf("GCD of %d and %d is : %d\n", first,second,gcd );
        sc.close();

    }

    public static int gcd(int first,int second){
        if( first == 0 ){
            return second;
        }
        return gcd( second%first , first );
    }

}