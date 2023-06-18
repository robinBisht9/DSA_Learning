package StringsDS;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String str = "babad";

        System.out.println(longestPalindrome(str));
    }
    public static String longestPalindrome(String s) {
        int[] res = new int[]{0,0};

        for( int i = 0;i<s.length()-1;i++ ){
            int[] oddPalindrome = expand(i,i,s);
            if( oddPalindrome[1]-oddPalindrome[0] +1 > (res[1]-res[0]+1) ){
                res[1] = oddPalindrome[1];
                res[0] = oddPalindrome[0];
            }
            int[] evenPalindrome = expand(i,i+1,s);
            if( evenPalindrome[1]-evenPalindrome[0] +1 > (res[1]-res[0]+1) ){
                res[1] = evenPalindrome[1];
                res[0] = evenPalindrome[0];
            }
        }

        return s.substring(res[0],res[1]+1);
    }

    public static int[] expand(int i , int j , String s){
        int[] ans = new int[]{i,j};
        while( i>= 0 && j< s.length() && s.charAt(i) == s.charAt(j) ){
            i--;
            j++;
        }
        ans[0] = ++i;
        ans[1] = --j;

        return ans;
    }
}
