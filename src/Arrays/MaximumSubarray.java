package Arrays;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println("Answer : "+maxSubArray(arr));
    }

    public static int maxSubArray(int[] arr) {
        int ans = arr[0];
        int curr = arr[0];

        for(int i = 1;i<arr.length;i++){
            if( arr[i] > curr+arr[i] ){
                curr = arr[i];
            }
            else{
                curr = curr+arr[i];
            }
            ans = Math.max(curr,ans);
        }

        return ans;
    }
    
}
