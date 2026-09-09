package HolidayWork;

import java.util.*;
/*public class Main {
    static long sum(long[] pref,int l,int r) {
        return pref[r+1]-pref[l];
    }
    static int recB(long[]prefA,long[]prefB,long x,int aL,int aR,int bL,int bR,int m){
        if (bL==m) return 0;
        if (bR==m) return recB(prefA,prefB,x,aL,aR,bL+1,bL+1,m);
        long SA = sum(prefA,aL,aR);
        long SB = sum(prefB,bL,bR);
        int best =0;
        if (SA*SB<=x) best = (aR - aL + 1) * (bR - bL + 1);
        int next = recB(prefA, prefB, x, aL, aR, bL, bR + 1, m);
        return Math.max(best, next);
    }
    static int recA(long[]prefA,long[]prefB,long x,int aL,int aR,int n,int m) {
        if (aL ==n) return 0;
        if (aR ==n)return recA(prefA, prefB, x, aL + 1, aL + 1, n, m);
        int here=recB(prefA, prefB, x, aL, aR, 0, 0, m);
        int next=recA(prefA, prefB, x, aL, aR + 1, n, m);
        return Math.max(here, next);
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        int m =sc.nextInt();
        long[]a=new long[n];
        long[]b=new long[m];
        for (int i =0;i< n;i++)a[i]=sc.nextLong();
        for (int i =0;i < m;i++)b[i]= sc.nextLong();
        long x =sc.nextLong();
        long[]prefA = new long[n+1];
        long[]prefB = new long[m+1];
        for (int i = 0;i<n;i++)prefA[i+1]=prefA[i] + a[i];
        for (int i =0;i<m;i++)prefB[i+1]= prefB[i] + b[i];
        int ans = recA(prefA,prefB,x,0,0,n,m);
        System.out.println(ans);
    }
}*/

public class SubRectangle {
    public static long helper(long[] p, int l, int r){
        return p[r+1]-p[l];
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        long[] a=new long[n];
        long[] b=new long[m];
        for(int i=0;i<n;i++)a[i]=sc.nextLong();
        for(int i=0;i<m;i++)b[i]=sc.nextLong();
        long x=sc.nextLong();
        long[] pa=new long[n+1];
        long[] pb=new long[m+1];
        for(int i=0;i<n;i++)pa[i+1]=pa[i]+a[i];
        for(int i=0;i<m;i++)pb[i+1]=pb[i]+b[i];
        long[] minA=new long[n+1];
        long[] minB=new long[m+1];
        Arrays.fill(minA,Long.MAX_VALUE);
        Arrays.fill(minB,Long.MAX_VALUE);
        for(int len=1;len<=n;len++){
            for(int i=0;i+len<=n;i++){
                long s= helper(pa,i,i+len-1);
                if(s<minA[len])minA[len]=s;
            }
        }
        for(int len=1;len<=m;len++){
            for(int i=0;i+len<=m;i++){
                long s= helper(pb,i,i+len-1);
                if(s<minB[len])minB[len]=s;
            }
        }
        int ans=0;
        int j=m;
        for(int i=1;i<=n;i++){
            while(j>0&&minA[i]*minB[j]>x)j--;
            if(j>0)ans=Math.max(ans,i*j);
        }
        System.out.println(ans);
    }
}