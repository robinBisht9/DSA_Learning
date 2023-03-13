package DequeDS;

import java.util.ArrayDeque;

import javax.crypto.Cipher;

public class FirstCircularTour {
    public static void main(String[] args) {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int[] petrol = {4,8,7,4};
        int[] dist = {6,5,3,5};

        int[] petrol1 = {50,10,60,100};
        int[] dist1 = {30,20,100,10};

        int curr_petrol = 0;
        int start = 0,prev_petrol = 0;
        for(int i=0;i<petrol.length;i++){
            curr_petrol += (petrol[i] - dist[i]);
            if( curr_petrol < 0 ){
                start = i+1;
                prev_petrol += curr_petrol;
                curr_petrol = 0;
            }
        }

        System.out.println( (curr_petrol+prev_petrol) >= 0 ? start+1 : -1 );


    }
    
}
