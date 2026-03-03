package HolidayWork;

import java.util.Scanner;

public class DiceRoll {
    static long mod = 1000000007;
    /*public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Long []dp= new Long[n+1];
        long ans = helper(dp, n);
        System.out.println(ans % mod);
    }
    public static long helper(Long[]dp,int n){
        if (n ==0) return 1;
        if(n<0)return 0;
        if (dp[n] !=null) return dp[n];
        long res = 0;
        for (int i =1;i <=6;i++){
            res = (res+helper(dp,n -i))%mod;
        }
        dp[n] =res;
        return res;
    }*/
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[]dp = new long[n + 1];
        dp[0]=1;
        for (int i =1;i<=n;i++) {
            for (int d =1;d <=6;d++) {
                if (i-d >=0){
                    dp[i] +=dp[i-d] %mod;
                }
            }
        }
        System.out.println(dp[n]);
    }

}
