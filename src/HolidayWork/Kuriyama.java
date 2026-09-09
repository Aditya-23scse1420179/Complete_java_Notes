package HolidayWork;

import java.util.*;

public class Kuriyama {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a =new int[n];
        for (int i =0;i< n;i++) a[i] = sc.nextInt();
        int[] pre1 = new int[n+1];
        for (int i =1;i <=n;i++) {
            pre1[i] =pre1[i-1]+a[i-1];
        }
        int[]b =Arrays.copyOf(a, n);
        Arrays.sort(b);
        int[] pre2 = new int[n+1];
        for (int i =1;i <=n;i++){
            pre2[i] = pre2[i-1] +b[i -1];
        }
        int m =sc.nextInt();
        while (m-->0){
            int type =sc.nextInt();
            int l =sc.nextInt();
            int r =sc.nextInt();
            if (type==1){
                System.out.println(pre1[r]-pre1[l-1]);
            }else{
                System.out.println(pre2[r] - pre2[l-1]);
            }
        }
    }
}

