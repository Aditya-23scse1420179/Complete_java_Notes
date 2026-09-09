package HolidayWork;

import java.util.Scanner;

public class CountingTower {
    static Long[]a =new Long[1000001];
    static Long[]b =new Long[1000001];
    static boolean[]seen = new boolean[1000001];
    public static void main(String[] var0) {
        Scanner var1 =new Scanner(System.in);
        int var2=var1.nextInt();
        while(var2-->0) {
            int var3=var1.nextInt();
            helper(var3);
            long var4=(a[var3]+b[var3]) % 1000000007L;
            System.out.println(var4);
        }
    }
    public static void helper(int var0) {
        if(!seen[var0]){
            seen[var0] =true;
            if (var0==1){
                a[var0]=1L;
                b[var0]=1L;
            }else{
                helper(var0-1);
                a[var0] =(2L*a[var0-1]+b[var0-1])%1000000007L;
                b[var0] =(a[var0-1]+4L*b[var0-1])%1000000007L;
            }
        }
    }
}