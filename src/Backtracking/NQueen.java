package Backtracking;

import java.util.Arrays;

public class NQueen {
    public static void main(String[] args) {
        int n = 6;
        nQueenSolution(n);
    }
    public static void nQueenSolution(int n){
        int[][] board = new int[n][n];
        if( nQueen(board,0) == false ){
            System.out.println("False");
        }
        else{
            printBoard(board);
        }
    }
    public static boolean nQueen(int[][] board,int row){
        if( row >= board.length ) return true;
        for( int i=0;i<board.length;i++){
            if( isSafe(board, row, i) ){
                board[row][i] = 1;
                if( nQueen(board, row+1) )  return true;
                board[row][i] = 0;
            }
        }
        return false;
    }
    public static boolean isSafe( int[][] board,int r , int c){
        for( int i = 0;i<board.length;i++ ){
            if( i != r && board[i][c] == 1  ) return false;
        }
        for( int i = 0;i<board.length;i++ ){
            if( i != c && board[r][i] == 1  ) return false;
        }
        int currR = r-1,currC = c-1;
        while( currC >= 0 && currC < board.length && currR < board.length && currR >= 0 ){
            if( board[currR][currC] == 1 ) return false;
            currC-=1;
            currR-=1;
        }
        currR = r+1;
        currC = c+1;
        while( currC >= 0 && currC < board.length && currR < board.length && currR >= 0 ){
            if( board[currR][currC] == 1 ) return false;
            currC+=1;
            currR+=1;
        }
        currR = r-1;
        currC = c+1;
        while( currC >= 0 && currC < board.length && currR < board.length && currR >= 0 ){
            if( board[currR][currC] == 1 ) return false;
            currC+=1;
            currR-=1;
        }
        currR = r+1;
        currC = c-1;
        while( currC >= 0 && currC < board.length && currR < board.length && currR >= 0 ){
            if( board[currR][currC] == 1 ) return false;
            currC-=1;
            currR+=1;
        }
        return true;
    }
    public static void printBoard(int[][] board){
        for( int[] row : board ){
            System.out.println(Arrays.toString(row));
        }
    }
}
