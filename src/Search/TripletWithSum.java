package Search;

public class TripletWithSum {
    public static void main(String[] args) {
        int[] arr = {2,3,4,8,9,20,40};

        int sumNeeded = 33;

        System.out.println("Triplet exists - > "+tripletSumExist(arr, sumNeeded));
    }

    public static boolean tripletSumExist(int[] arr, int x){
        for( int i = 0;i<arr.length-2;i++ ){
            if( twoSum(arr, i+1, x-arr[i])  ) return true;
        }
         return false;
    }
    public static boolean twoSum(int[] arr,int start, int sum){
        int l = start;
        int r = arr.length - 1;

        while( l < r ){
            if( ( arr[l] + arr[r] ) == sum  ){
                return true;
            }
            else if( (arr[l] + arr[r] ) > sum ){
                r--;
            }
            else{
                l++;
            }
        }
        return false;
    }
    
}
