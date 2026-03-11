package HolidayWork;

import java.util.Scanner;

public class knapsack {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        long[]val=new long[n];
        long[]wt=new long[n];
        for(int i=0;i<n;i++){
            wt[i] = sc.nextInt();
            val[i] = sc.nextInt();
        }
        Long[][]dp=new Long[n+1][w+1];
        System.out.println(helper(0,n,w,wt,val,dp));
    }
    public static long helper(int i, int n, int w, long[] wt, long[] val, Long[][] dp){
        if(i==n)return 0;
        if(dp[i][w]!=null)return(dp[i][w]);
        long take=0;
        if(wt[i]<=w){
            take=val[i]+helper(i+1,n, (int) (w-wt[i]),wt,val,dp);
        }
        long not_take=helper(i+1,n,w,wt,val,dp);
        return dp[i][w]=Math.max(take, not_take);
    }
}
