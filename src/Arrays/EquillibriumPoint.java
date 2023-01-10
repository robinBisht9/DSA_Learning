package Arrays;

public class EquillibriumPoint {
    public static void main(String[] args) {
        int[] arr = {3,4,8,-9,20,6};

        int rightSum = 0;
        for( int i = 0;i<arr.length;i++){
            rightSum += arr[i];
        }

        int leftSum = 0;

        for(int i = 0;i<arr.length;i++){
            rightSum -= arr[i];
            if( leftSum == rightSum ){
                System.out.println("Equilibrium Point at "+i);
                return;
            }
            leftSum += arr[i];
        }

        System.out.println("No Equillibrium");
    }
    
}
