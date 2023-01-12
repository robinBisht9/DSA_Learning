package Search;

public class AllocateMinimumPages {

    public static void main(String[] args) {
        int[] arr = {10,5,30,1,2,5,10,10};
        int k = 3;
        System.out.println("Minimum of maxmum pages -> "+minPages(arr,arr.length,k)); // O(n*log(sum-mx))
    }

    public static int minPages(int[] arr,int n,int k){
        int sum=0,mx = arr[0];
        for( int i=0;i<n;i++ ){
            sum+=arr[i];
            mx = Math.max(mx, arr[i]);
        }
        int low = mx,high = mx,res = 0;
        while( low<=high ){
            int mid = (low+high)/2;
            if( isFeasible(arr, n, k, mid) ){
                res = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return res;
    }

    public static boolean isFeasible(int[] arr, int n,int k, int ans){
        int curr = 0;
        int res = 1;
        for(int i = 0;i<n;i++){
            if( curr+arr[i] > ans ){
                res++;
                curr = arr[i];
            }
            else{
                curr+=arr[i];
            }
        }

        return res <= k;
    }

    public static int minPagesRecursive(int[] arr,int n, int k){
        if( n == 1 ){
            return arr[0];
        }
        if( k == 1 ){
            return sumOfArray(arr,0,n-1);
        }
        int ans = Integer.MAX_VALUE;
        for( int i = 1;i<n;i++ ){
            ans = Math.min( ans, Math.max( minPagesRecursive(arr,i, k-1)  , sumOfArray(arr,i,n-1) ));
        }
        return ans;
    }

    public static int sumOfArray(int[] arr,int start,int end){
        int sum = 0;
        for( int i = start;i<=end;i++ ){
            sum+=arr[i];
        }
        return sum;
    }
    
}
