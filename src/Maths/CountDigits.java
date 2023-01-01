package Maths;

import java.util.Scanner;

public class CountDigits {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a digit\n");
        int digit = sc.nextInt();
        int count = 0;
        if( digit == 0 ){
            count = 1;
        }

        while( digit > 0){
            count++;
            digit = digit/10;
        }

        System.out.println("Count of digits is :"+ count);
        sc.close();

    }
    
}
