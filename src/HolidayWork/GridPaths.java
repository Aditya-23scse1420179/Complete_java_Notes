package HolidayWork;

import java.util.Scanner;

class GridPaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] grid= new char[n][n];
        for(int i=0;i<n;i++){
            grid[i]=sc.next().toCharArray();
        }
        Integer[][]dp=new Integer[n][n];
        System.out.println(helper(grid,n,0,0,dp));
    }
    public static int helper(char[][] grid, int n, int i, int j,Integer[][]dp) {
        if (i >=n||j >= n|| grid[i][j] =='*') return 0;
        if (i == n-1&&j==n-1) return 1;
        if (dp[i][j]!= null) return dp[i][j];
        int down = helper(grid,n,i + 1,j,dp);
        int right = helper(grid,n,i,j+1,dp);
        return dp[i][j] =(right+down)%1000000007;
    }
}
