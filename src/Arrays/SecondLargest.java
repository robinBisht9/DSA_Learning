package Arrays;

public class SecondLargest {
    public static void main(String[] args){
        int[] arr = {10,8,4,9,2,11};

        int largest = 0;
        int secondLargest = -1;
        for( int i = 1;i<arr.length;i++ ){
            if( arr[largest] > arr[i] ){
                if( secondLargest == -1 || arr[secondLargest] < arr[i] ){
                    secondLargest = i;
                }
            }
            else if( arr[largest] < arr[i] ){
                secondLargest = largest;
                largest = i;
            }
        }

        System.out.println( secondLargest +" "+arr[secondLargest] );
    }
}
