package HolidayWork;

import java.util.*;

public class G_one {
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i =2;i*i <= n;i++)
            if (n%i == 0) return false;
        return true;
    }
    public static long helper(int idx, int tight, int sum, String s, Long[][][] dp) {
        if (idx==s.length())return isPrime(sum)? 1 :0;
        if (dp[idx][tight][sum]!=null)return dp[idx][tight][sum];
        int ub=(tight==1)?(s.charAt(idx)-'0'):9;
        int lb=0;
        long res=0;
        for (int digit =lb;digit<= ub;digit++) {
            int ntight =(tight==1&&digit==ub)?1:0;
            res+=helper(idx+1,ntight,sum+digit,s,dp);
        }
        return dp[idx][tight][sum] = res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            long a=sc.nextLong();
            long b=sc.nextLong();
            String l =String.valueOf(a - 1);
            String r =String.valueOf(b);
            Long[][][]dp1 =new Long[r.length()+1][2][163];
            Long[][][]dp2 =new Long[l.length()+1][2][163];
            long ans =helper(0,1,0,r,dp1) - helper(0,1,0,l,dp2);
            System.out.println(ans);
        }
    }
}