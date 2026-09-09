package HolidayWork;

import java.util.*;

class Subdigit {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[]dp =new int[n+1];
        Arrays.fill(dp, (int)1e9);
        dp[0] =0;
        for (int i =1;i <=n;i++) {
            int x =i;
            while (x>0){
                int d=x%10;
                if (d >0&&i -d >=0){
                    dp[i] = Math.min(dp[i],dp[i-d] +1);
                }
                x/=10;
            }
        }
        System.out.println(dp[n]);
    }
}

