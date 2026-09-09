package BackTracking;
public class nQueen {
    public static void main(String[] args) {
        int n=8;
        char [][]board = new char[n][n];
        for(int i = 0 ; i < n;i++) {
            for(int j = 0 ; j < n;j++) {
                board[i][j]='x';
            }
        }
        nQueenP(board,0);
    }
    private static void nQueenP(char[][] board, int row) {
        int n = board.length; // base condition
         if(row == n) {
             for(int i = 0 ; i < n ;i++) {
                 for(int j = 0 ; j < n ;j++) {
                     System.out.print(board[i][j]);
                 } System.out.println();
             } System.out.println();
             return;
         } for(int j = 0; j < n ;j++) {
             if(isSafe(board,row,j)) {
                 board[row][j] = 'q';
                 nQueenP(board,row+1);
                 board[row][j] = 'x';
             }
         }
    }
    private static boolean isSafe(char[][] board, int row, int col) { // check col
        int n = board.length;
        for(int i = 0; i< n;i++) {
            if(board[i][col] == 'q')return false;
        } // row
        for(int j = 0; j< n;j++) {
            if(board[row][j] == 'q')return false;
        } // left upper diagonal
        int i = row;
        int j = col;
        while(i >=0 && j >=0) {
            if(board[i][j] == 'q')return false;
            i--;
            j--;
        } // right upper
        i = row;
        j = col;
        while(i>=0 && j<n) {
            if(board[i][j] == 'q')return false;
            i--;
            j++;
        }
        return true;
    }
}