package HolidayWork;

import java.util.Scanner;

public class EditDistance {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        String t=sc.next();
        Integer[][]dp=new Integer[s.length()+1][t.length()+1];
        System.out.println(helper(s,t,s.length(),t.length(),dp));
    }public static int helper(String s,String t,int i,int j,Integer[][]dp){
        if(i==0)return j;
        if(j==0)return i;
        if(dp[i][j]!=null)return dp[i][j];
        if(s.charAt(i-1)==t.charAt(j-1)){
            return dp[i][j]= helper(s,t,i-1,j-1,dp);
        }else {
            int insert = 1 +helper(s, t,i,j-1,dp);
            int delete= 1+helper(s,t,i-1,j,dp);
            int replace = 1+helper(s,t,i-1,j-1,dp);
            return dp[i][j]=Math.min(insert,Math.min(delete,replace));
        }
    }*/// fail hogaya cses problem pe tabulation karna padega
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++) dp[i][0]=i;
        for(int j=0;j<=m;j++) dp[0][j]=j;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) ==t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = 1 + Math.min(dp[i-1][j],Math.min(dp[i][j-1], dp[i-1][j-1]));
            }
        }
        System.out.println(dp[n][m]);
    }
}
