package HolidayWork;

import java.util.Scanner;

public class Digitdp {
    public static long solve(String s,int idx,int tight,int prev,int lz,Long[][][][]dp){   //lz=leading zero
        if(idx==s.length())return 1;
        if(dp[idx][tight][prev][lz]!=null)return dp[idx][tight][prev][lz];
        int lb=0;
        long ub=tight==1 ? s.charAt(idx)-'0' :9;
        long res=0;
        for(int digit =lb;digit<=ub;digit++){
            if(digit==prev &&lz==0)continue;
            int newTight =(digit==ub && tight==1) ?1:0;
            int newLeadingZero = (digit==0 &&lz==1)?1:0;
            res+=solve(s,idx+1,newTight,digit,newLeadingZero,dp);
        }
        return dp[idx][tight][prev][lz]=res;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        long a=sc.nextLong();
        long b=sc.nextLong();
        String l=String.valueOf(a-1);
        String r=String.valueOf(b);
        Long[][][][]dp1= new Long[r.length()+1][2][11][2];
        Long[][][][]dp2= new Long[l.length()+1][2][11][2];
        long ans= solve(r,0,1,10,1,dp1)-solve(l,0,1,10,1,dp2);
        System.out.println(ans);
    }
}
