package Arrays;

public class MinimumInRotatedArray {
    
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
        }


    public static int findMin(int[] nums) {
        int l = 0,r=nums.length-1;
        int mid = 0;
        while( l < r ){
            mid = l+((r-l)/2);
            if( nums[mid] >= nums[l] && nums[mid] <= nums[r] ) return nums[l];
            else if( nums[mid] >= nums[l] ){
                l =  mid+1;
            }
            else{
                r = mid;
            }
        }
        return nums[l];
    }

}


