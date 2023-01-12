package Search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {10,24,28,30,32,33,40,46,48};

        System.out.println("Element present in -> "+binarySearch(arr,40));


    }

    public static int binarySearch(int[] arr,int ele){
        int l = 0;
        int r = arr.length-1;

        int mid;
        while( l<=r ){
            mid = l + (r-l)/2 ;
            if( arr[mid] == ele ) return mid;
            else if( arr[mid] > ele ){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }

        return -1;
    }
}
