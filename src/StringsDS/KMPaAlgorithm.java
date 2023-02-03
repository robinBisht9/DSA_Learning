package StringsDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class KMPaAlgorithm {
    public static void main(String[] args) {
        String text = "aabaacaadaac";
        String pattern = "aac";

        System.out.println(kmpAlgorithm(text, pattern));

        
        
    }
    public static ArrayList<Integer> kmpAlgorithm(String text, String pattern){
        ArrayList<Integer> arl = new ArrayList<>();
        int n = text.length(),m=pattern.length();
        int[] lps = new int[pattern.length()];
        fillLPS(pattern,lps);

        int i=0,j=0;
        while(i<n){
            if( pattern.charAt(j) == text.charAt(i) ){
                i++;
                j++;
            }
            if( j == m ){
                arl.add(i-j);
                j = lps[j-1];
            }
            else if( i<n && pattern.charAt(j) != text.charAt(i) ){
                if( j == 0 ) i++;
                else j = lps[j-1];

            }
        }

        return arl;
    }

    public static int[] fillLPS(String str,int[] lps){
        int prev = 0;
        for(int i=1;i<lps.length;){
            if( str.charAt(prev) == str.charAt(i) ){
                prev++;
                lps[i] = prev;
                i++;
            }
            else if( prev != 0 ){
                prev = lps[prev-1];
            }
            else{
                lps[i] = 0;
                i+=1;
            }

            
        }
        return lps;
    }
    
}
