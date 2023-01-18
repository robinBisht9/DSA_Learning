package Sorting;

import java.util.Arrays;

public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        int[] arr = {7,3,2,4,9,12,56};
        int m = 3;
        // need to pick m packets so the distribution is fair
        int[] arr2 = {3,4,1,9,56,7,9,12};
        int m2 = 5;

        System.out.println(divideChocolates(arr, m));

    }

    public static int divideChocolates(int[] arr,int m ){
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int curr = 0;
        int ans = arr[m-1] - arr[0];
        curr = ans;
        for( int i = m;i<arr.length;i++ ){
            curr = arr[i] - arr[i-m+1];
            ans = Math.min(curr, ans);
        }
        return ans;

    }
    
}
