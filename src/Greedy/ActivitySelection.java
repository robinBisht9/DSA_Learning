package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arl = new ArrayList<>();
        arl.add(new ArrayList<>(Arrays.asList(3,8)));
        arl.add(new ArrayList<>(Arrays.asList(2,4)));
        arl.add(new ArrayList<>(Arrays.asList(1,3)));
        arl.add(new ArrayList<>(Arrays.asList(10,11)));

        System.out.println(activitySelection(arl));
        
    }
    public static int activitySelection(ArrayList<ArrayList<Integer>> arl){
        Collections.sort( arl, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a , ArrayList<Integer> b){
                return a.get(1) - b.get(1);
            }
        } );
        ArrayList<Integer> prev = arl.get(0);
        int res = 1;
        for( int i = 1;i<arl.size();i++ ){
            if( arl.get(i).get(0) >= prev.get(1) ){
                prev = arl.get(i);
                res++;
            }
        }
        return res;
    }
}
