package DynamicProgramming;

import java.util.Scanner;

public class boardem {
    static long[]freq;
    static Long[]dp;
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        freq=new long[100001];
        dp=new Long[100001];
        int maxval=0;
        for(int i=0;i<n;i++){
            int x=sc.nextInt();
            freq[x]++;
            maxval=Math.max(maxval,x);
        }
        System.out.println(helper(maxval));
    }public static long helper(int x){
        if(x<0)return 0;
        if(dp[x]!=null)return dp[x];
        long skip=helper(x-1);//skip
        long take=helper(x-2)+freq[x]*x;//take 
        return dp[x]=Math.max(skip,take);
    }
}
