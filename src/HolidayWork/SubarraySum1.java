package HolidayWork;

import java.util.Scanner;

public class SubarraySum1 {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        long s=sc.nextLong();
        long big;
        if(s==1000000000L){
            big=1;
        }else{
            big=s+1;
        }
        for(int i=0;i<k;i++){
            System.out.print(s+" ");
        }
        for(int i=k;i<n;i++){
            System.out.print(big+" ");
        }
    }
}
