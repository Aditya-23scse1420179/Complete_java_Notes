package HolidayWork;

import java.util.Scanner;
class gridcses1 {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        int m=sc.nextInt();
        char[][]grid = new char[n][m];
        for(int i =0;i <n;i++){
            grid[i] = sc.next().toCharArray();
        }
        Long[][] dp = new Long[n][m];
        System.out.println(helper(grid, n, m, 0, 0, dp));
    }
    public static long helper(char[][]grid,int n,int m,int i,int j,Long[][] dp){
        if(i>=n|| j>=m)return 0;
        if(grid[i][j] =='#') return 0;
        if(i ==n-1&&j ==m-1) return 1;
        if(dp[i][j]!= null)return dp[i][j];
        long down = helper(grid,n,m,i+1,j,dp);
        long right = helper(grid, n,m, i,j+1,dp);
        return dp[i][j] =(down+right)%MOD;
    }
}
