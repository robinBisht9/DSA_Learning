package StringsDS;

import java.util.Arrays;

public class ReverseWords {
    public static void main(String[] args) {
        String str = "Hello World for reverse words";
        System.out.println(reverseWords(str));
    }

    public static String reverseWords(String str){
        StringBuilder reversedString = new StringBuilder("");
        String[] arr = str.split(" ");
        for(int i=arr.length-1;i>=0;i-- ){
            reversedString.append(arr[i]);
            reversedString.append(" ");
        }
        return reversedString.toString().trim();
    }
    
}
