package BackTracking;
public class maxknight {

    static int max = -1;
    public static void main(String[] args) {
        int n = 3;
        char [][]board = new char[n][n];
        for(int i = 0 ; i <n ;i++) {
            for(int j = 0 ; j < n ;j++) {
                board[i][j] = 'x';
            }
        }
        maxK(board,0,0,0);
        System.out.println("max knight possible is"+max);
    }
    public static boolean isSafe(char [][]board,int row,int col) {
        int n = board.length;
        int i,j;
        // 2 up 1 right
        i = row-2;
        j = col+1;
        if(i>=0 && j<n && board[i][j]=='k')return false;
        // 2 up 1 left
        i = row-2;
        j = col-1;
        if(i>=0 && j>=0 && board[i][j]=='k')return false;
        // 2 left 1 up
        i = row-1;
        j = col-2;
        if(i>=0 && j>=0 && board[i][j]=='k')return false;
        // 2 left 1 down
        i = row+1;
        j = col-2;
        if(i < n && j>=0 && board[i][j]=='k')return false;
        // 2 right 1 up
        i = row-1;
        j = col+2;
        if(i >= 0 && j<n && board[i][j]=='k')return false;
        // 2 right 1 down
        i = row+1; j = col+2;
        if(i < n && j<n && board[i][j]=='k')return false;
        // 2 down 1 right
        i = row+2;
        j = col+1;
        if(i < n && j<n && board[i][j]=='k')return false;
        // 2 down 1 left
        i = row+2;
        j = col-1;
        if(i < n && j>=0 && board[i][j]=='k')return false;
        return true;
    }
    private static void maxK(char[][] board, int row, int col, int num) {
        int n = board.length; // base
        if(row == n) {
            max = Math.max(max,num);
//            if(num == 5) {
//                for (int i = 0; i < n; i++) {
//                    for (int j = 0; j < n; j++) {
//                        System.out.print(board[i][j]);
//                    }
//                    System.out.println();
//                }
//                System.out.println();
//            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("-----------------------------");
            return;
        } if(isSafe(board,row,col)) {
            board[row][col] = 'k';
            if(col!=n-1)maxK(board,row,col+1,num+1);
            else { maxK(board,row+1,0,num+1);
            }
            board[row][col] = 'x';
        } if(col!=n-1)maxK(board,row,col+1,num);
        else { maxK(board,row+1,0,num);
        }
    }
}