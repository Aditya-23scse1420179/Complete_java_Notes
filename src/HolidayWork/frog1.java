package HolidayWork;

import java.util.Scanner;

class frog1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        Integer []dp=new Integer[n+1];
        System.out.println(helper(arr,0,dp));
    }
    public static int helper(int []arr,int i,Integer[]dp){
        int n=arr.length;
        if(dp[i]!=null) return dp[i];
        if(i==n-1)return 0;
        int jumpOne = helper(arr,i+1,dp) + Math.abs(arr[i]-arr[i+1]);
        int jumpTwo = Integer.MAX_VALUE;
        if(i+2<n){
            jumpTwo = helper(arr,i+2,dp) + Math.abs(arr[i]-arr[i+2]);
        }
        return dp[i]=Math.min(jumpOne,jumpTwo);
    }
}
