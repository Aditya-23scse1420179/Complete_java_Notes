package HolidayWork;

import java.util.Scanner;

public class ClassyNumber {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            String l = String.valueOf(a - 1);
            String r = String.valueOf(b);
            Long[][][][] dp1 = new Long[r.length() + 1][2][4][2];
            Long[][][][] dp2 = new Long[l.length() + 1][2][4][2];
            long ans = helper(r,0,1,0,1,dp1)-helper(l,0, 1,0,1,dp2);
            System.out.println(ans);
        }
    }
    public static Long helper(String s,int idx,int tight,int count ,int lz,Long[][][][]dp){
        if(count>3)return 0L;
        if(idx==s.length()){
            return 1L;
        }
        int lb=0;
        int ub=(tight==1)?s.charAt(idx)-'0':9;
        long res=0;
        if(dp[idx][tight][count][lz]!=null)return dp[idx][tight][count][lz];
        for(int digit=lb;digit<=ub;digit++){
            int newtight=(tight==1 && digit==ub)?1:0;
            int newlz=(digit==0 && lz==1)?1:0;
            int newcount=count;
            if(digit != 0&&newlz==0)newcount++;
            res+=helper(s,idx+1,newtight,newcount,newlz,dp);
        }
        return dp[idx][tight][count][lz]=res;

    }
}
