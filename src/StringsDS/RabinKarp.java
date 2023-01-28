package StringsDS;

import java.util.ArrayList;

public class RabinKarp {
    public static void main(String[] args) {
        String text = "abcaabcdabcfaabcd";
        String pattern = "aabcd";
        // computes hash for both text and pattern and compares only when the hash maps
        ArrayList<Integer> matchingIndexes = rabinKarpAlgorithm(text, pattern);
        System.out.println(matchingIndexes.toString());
    }

    public static ArrayList<Integer> rabinKarpAlgorithm(String text,String pattern){
        ArrayList<Integer> matchedText = new ArrayList<>();
        int n = text.length(), m = pattern.length();
        int q = 101, d = 256;
        int h = 1;
        for(int i=0;i<m-1;i++){
             h = (h*d)%q;
        }
        int p = 0,t=0;
        for(int i=0;i<m;i++){
            p = (p*d+pattern.charAt(i))%q;
            t = (t*d+text.charAt(i))%q;
        }
        for( int i = 0;i<=(n-m);i++ ){

            if( p == t ){
                boolean isSame = true;
                for( int j=0;j<m;j++){
                    if( text.charAt(i+j) != pattern.charAt(j) ){
                        isSame = false;
                        break;
                    }
                }
                if( isSame ){
                    matchedText.add(i);
                }
            }
            if( i<n-m ){
                t = (d * (t - text.charAt(i)*h )+text.charAt(i+m) )%q;
            }
            if( t<0 ) t+=q;
        }

        return matchedText;
    }
    
}
