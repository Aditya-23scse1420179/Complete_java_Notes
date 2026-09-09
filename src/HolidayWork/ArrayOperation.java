package HolidayWork;

import java.util.*;
class ArrayOperation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k =sc.nextInt();
            long[] a =new long[n];
            for(int i = 0;i <n;i++) a[i] =sc.nextLong();
            Arrays.sort(a);
            int left = 0;
            int right = n-1;
            long ans =0;
            for (int p =0;p <k;p++){
                long num=a[right - k];
                long den=a[right];
                ans += num/den;
                right--;
            }
            for(int i =0;i<n-2*k;i++){
                ans+=a[i];
            }
            System.out.println(ans);
        }
    }
}

