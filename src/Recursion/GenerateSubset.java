package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GenerateSubset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.next();
        ArrayList<String> arl = new ArrayList<>();
        generateSubsets(str,arl);
        System.out.println(arl);
        sc.close();
    }

    public static void generateSubsets(String str,ArrayList<String> arl){
        if( str.length() == 0 ){
            return;
        }

        String subs = str.length() == 1 ? "": str.substring(1) ;
        String curr = str.substring(0,1);

        generateSubsets(subs, arl);

        int size = arl.size();
        ArrayList<String> newArl = new ArrayList<>();

        for(int i = 0;i<size;i++){
            newArl.add(0, curr+arl.get(i));
        }
        newArl.add(0, curr);

        arl.addAll(0,newArl);

    }
    
}
