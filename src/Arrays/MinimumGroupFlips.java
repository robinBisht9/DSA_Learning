package Arrays;

public class MinimumGroupFlips {
    public static void main(String[] args) {
        int[] arr = {1,1,0,0,0,1,0};
        int[] arr2 = {1,0,0,0,1,0,0,1,1,1,1};

        for(int i = 1;i<arr.length;i++){
            if( arr[i] != arr[i-1] ){
                if( arr[i] != arr[0] ){
                    System.out.printf("From %d ",i);
                }
                else{
                    System.out.println("to "+(i-1));
                }
            }
        }
        if( arr[arr.length-1] != arr[0] ){
            System.out.println("to "+(arr.length-1));
        }
    }
    
}
