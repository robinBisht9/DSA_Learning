package StringsDS;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    public static void main(String[] args) {
        String[] words = new String[]{ "oath","pea","eat","rain"};
        char[][] board = new char[][]{ {'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'} };

        System.out.println(findWords(board, words));
    }
    public static List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for( int i = 0;i<words.length;i++ ){
            trie.insert(words[i]);
        }

        TrieNode root = trie.getRootNode();

        List<String> result = new ArrayList<String>();

        int[][] track = new int[board.length][board[0].length];
        for( int i = 0;i<board.length;i++ ){
            for( int j = 0;j<board[0].length;j++ ){
                if( root.children[ board[i][j] - 'a' ] != null ){
                    StringBuilder sb = new StringBuilder();
                    findWords( board,i,j,root,track, result, sb );
                }
            }
        }

        return result;
        
    }

    public static void findWords( char[][] board , int i, int j , TrieNode curr, int [][] track, List<String> result, StringBuilder sb ){
        if( i<0 || j<0 || i>= board.length || j>= board[0].length || track[i][j] == 1 ) return;
        if( curr.children[ board[i][j] - 'a' ] == null ) return;
        sb.append(board[i][j]);
        track[i][j] = 1;
        if( curr.children[ board[i][j] - 'a'].wordCount != 0 ){
            result.add( sb.toString() );
        }
        findWords( board,i,j+1,curr.children[ board[i][j] - 'a' ],track, result, sb );
        findWords( board,i+1,j,curr.children[ board[i][j] - 'a' ],track, result, sb );
        findWords( board,i,j-1,curr.children[ board[i][j] - 'a' ],track, result, sb );
        findWords( board,i-1,j,curr.children[ board[i][j] - 'a' ],track, result, sb );

        sb.deleteCharAt(sb.length()-1);
        track[i][j] = 0;

        return;

    }
    
}

class Trie {
    TrieNode root = null;
    public Trie() {
        root = new TrieNode();
    }

    public TrieNode getRootNode(){
        return root;
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for( int i = 0; i<word.length();i++ ){
            int index = word.charAt(i) - 'a';
            if( curr.children[index] == null ){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.wordCount++;
    }
    
}
class TrieNode{
    public int wordCount;
    public TrieNode[] children;
    public TrieNode(){
        children = new TrieNode[26];
        wordCount = 0;
    }

}
