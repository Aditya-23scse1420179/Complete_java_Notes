package HolidayWork;

import java.util.Arrays;
import java.util.Scanner;

public class Coin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int x =sc.nextInt();
        int[]coins =new int[n];
        for(int i = 0;i< n;i++) coins[i] = sc.nextInt();
        int[]dp = new int[x + 1];
        Arrays.fill(dp,-1);
        dp[0]= 0;  // base
        for(int i = 1;i <=x;i++){
            for(int c :coins){
                if (i -c>=0&& dp[i-c]!=-1) {
                    int candidate = dp[i-c] +1;
                    if (dp[i] ==-1||candidate <dp[i]) {
                        dp[i] =candidate;
                    }
                }
            }
        }
        System.out.println(dp[x]);
    }
}
