package Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class BasicHash {
    public static void main(String[] args) {
        int[] arr = {30,20,25,10,15,14,15,30,20,30,30,20};

        System.out.println("Distinct elements are : "+distinctNumbers(arr));
        printFrequency(arr);
    }

    public static int distinctNumbers(int[] arr){
        HashSet<Integer> setOfDistinct = new HashSet<>();
        for(int i : arr){
            setOfDistinct.add(i);
        }
        return setOfDistinct.size();
    }
    public static void printFrequency(int[] arr){
        HashMap<Integer,Integer> frequencyCounter = new HashMap<>();
        for( int i: arr ){
            frequencyCounter.put(i,frequencyCounter.getOrDefault(i, 0)+1);
        }
        System.out.println(frequencyCounter);
    }
    
}
