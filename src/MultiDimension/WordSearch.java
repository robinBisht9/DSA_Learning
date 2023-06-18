package MultiDimension;

public class WordSearch {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "AAB";

        System.out.println( exist(matrix, word) );
    }
    public static  boolean exist(char[][] matrix, String word) {
        int[][] track = new int[matrix.length][matrix[0].length];

        for( int i =0;i<matrix.length;i++ ){
            for( int j =0;j<matrix[0].length;j++ ){
                String sb = "";
                track = new int[matrix.length][matrix[0].length];
                if( foundWord( matrix,i,j,track,word,sb,0) ) return true;
            }
        }

        return false;
    }

    public static boolean foundWord( char[][] matrix, int i ,int j, int[][] track,String word,String sbs, int len ){
        if( len >= word.length() ) return false;
        if( matrix[i][j] != word.charAt(len) ) return false;
        String sb = sbs+matrix[i][j];
        if( len == word.length()-1 ) return word.equals( sb );
        track[i][j] = 1;

        if( ( i>=0 && i< matrix.length && (j+1) >=0 && (j+1)< matrix[0].length) && track[i][j+1] != 1 && foundWord( matrix,i,j+1,track,word,sb,len+1) ) return true;
        if( ( i>=0 && i< matrix.length && (j-1) >=0 && (j-1)< matrix[0].length) && track[i][j-1] != 1 && foundWord( matrix,i,j-1,track,word,sb,len+1) ) return true;
        if( ( (i+1)>=0 && (i+1)< matrix.length && j >=0 && j < matrix[0].length) && track[i+1][j] 
        != 1 && foundWord( matrix,i+1,j,track,word,sb,len+1) ) return true;
        if( ( (i-1)>=0 && (i-1)< matrix.length && j >=0 && j < matrix[0].length) && track[i-1][j] != 1 && foundWord( matrix,i-1,j,track,word,sb,len+1) ) return true;
        track[i][j] = 0;
        return false;
    }
}
