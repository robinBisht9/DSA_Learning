package Hashing;

public class LongestCommonSubarrayBinary {
    public static void main(String[] args) {
        int[] arr11 = {0,1,0,0,0,0};
        int[] arr12 = {1,0,1,0,0,1};

        int[] arr21 = {0,1,0,1,1,1,1};
        int[] arr22 = {1,1,1,1,1,0,1};

        int[] arr31 = {0,0,0};
        int[] arr32 = {1,1,1};

        int[] arr41 = {0,0,1,0};
        int[] arr42 = {1,1,1,1};
        // Idea is to subtract the first subarray with second and find the longest subarray with zero sum
        System.out.println("Longest common subarray sum in binary -> "+longestCommonSubarraySum(arr41, arr42));
    }

    public static int longestCommonSubarraySum(int[] arr1,int[] arr2){
        int[] modifiedArray = new int[arr1.length];
        for(int i=0;i<arr1.length;i++){
            modifiedArray[i] = arr1[i] - arr2[i];
        }
        return LongestSubarrayEqualZeroOne.findZeroSum(modifiedArray);
        
    }
    
}
