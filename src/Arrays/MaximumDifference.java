package Arrays;

public class MaximumDifference {
    public static void main(String[] args) {
        int[] arr2 = {2,3,10,6,4,8,1};
        int[] arr = {30,10,8,2};

        int diff = Integer.MIN_VALUE;
        int minOfLeft = arr[0];
        for( int i=1;i<arr.length;i++ ){

            int currDiff = arr[i] - minOfLeft;

            if( arr[i] < minOfLeft ){
                minOfLeft = arr[i];
            }

            diff = Math.max(diff, currDiff);

        }

        System.out.println(diff);
    }
    
}
