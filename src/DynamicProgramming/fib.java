package DynamicProgramming;

import java.util.Arrays;

public class fib {
    public static void main (String[]args){
        int n=5;
        int []dp= new int[n+1];
        Arrays.fill(dp,-1);
//      int result = fibb(n,dp);  //memoization method calculation
        int result = fibbT(n);//tabulation method calculation in same MixOfAll.array
        System.out.println(result);
    }
    private static int fibb(int n,int[]dp){
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=fibb(n-1,dp)+fibb(n-2,dp);
    }
    private static int fibbT(int n){
        int[]dp=new int[n+1];
//        dp[0]=0;
//        dp[1]=1;
        int seclast =0;
        int last =1;
        for(int i=2;i<=n;i++){
            int result=last+seclast;
            seclast=last;
            last=result;
//            dp[i]=dp[i-1]+dp[i-2];
        }
//        return dp[n];
        return last;
    }
}
