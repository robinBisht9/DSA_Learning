package Search;

public class MedianTwoSorted {
    public static void main(String[] args) {
        int[] first = {10,20,30,40,50};
        int[] second = {5,15,25,30,35,55,65,75,85};

        int[] firstA = {20,30,40};
        int[] secondA = {1,2,3,4,5,6,7};

        // consider first as having smaller length
        // need to find middle elments without merging
        // use binary search to find a point which will help to segregate two halves
        // first.length + second.length -> even ( min of perceived second half + max of perceived first half )
        // if odd -> min of second half

        System.out.println("The median is : "+ median(first, second));
    }

    public static double median(int[] first,int[] second){
        int n1= first.length;
        int n2 = second.length;

        int begin=0,end=n1-1;

        while( begin <= end ){
            int i1 = (begin+end)/2;
            int i2 = (n1+n2+1)/2 - i1;

            int min1 = ( i1 == n1  ) ? Integer.MAX_VALUE : first[i1];
            int max1 = ( i1 == 0  ) ? Integer.MIN_VALUE : first[i1-1];

            int min2 = ( i2 == n2  ) ? Integer.MAX_VALUE : second[i2];
            int max2 = ( i2 == 0  ) ? Integer.MIN_VALUE : second[i2-1];

            if( max1 <= min2 && max2 <= min1 ){
                if( (n1+n2)%2 == 0 ){
                    return (double)(Math.max( max1,max2)+Math.min(min1, min2)) / 2;
                }
                return Math.min(min1,min2);
            }
            else if( max1 > min2 ){
                end = i1-1;

            }
            else{
                begin = i1+1;
            }

        }
        return 0;
    
    }
    
}
