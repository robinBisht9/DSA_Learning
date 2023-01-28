package StringsDS;

import java.util.ArrayList;

public class NaivePatternSearch {
    public static void main(String[] args) {
        String text = "abcabceabcfabcd";
        String pattern = "abcd";

        ArrayList<Integer> matchingIndexes = findMatchingIndexes(text, pattern,false);
        System.out.println(matchingIndexes.toString());
    }

    public static ArrayList<Integer> findMatchingIndexes(String text,String pattern,boolean isPatternDistinct){
        ArrayList<Integer> matchedIndexes = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        if( n<m ) return matchedIndexes;

        for( int textLoop = 0;textLoop<=(n-m); ){
            int patternLoop;
            for( patternLoop = 0;patternLoop<m;patternLoop++ ){
                if( pattern.charAt(patternLoop) != text.charAt(textLoop+patternLoop) ) break;
            }
            if( patternLoop == m ){
                matchedIndexes.add(textLoop);
            }
            if( isPatternDistinct && patternLoop != 0 ) textLoop+=patternLoop; 
            else textLoop++;

        }

        return matchedIndexes;
    }
    
}
