package StringsDS;

public class Palindrome {
    public static void main(String[] args) {
        String str = "nitin";
        String str2 = "robin";

        System.out.println("Palindrome check for "+str+" is "+checkPalindrome(str2));
    }

    public static boolean checkPalindrome(String str){
        int left = 0;
        int right = str.length()-1;
        while( left < right ){
            if( str.charAt(right) != str.charAt(left) ){
                return false;
            }
            left++;
            right--;
        } 
        return true;
    }
    
}
