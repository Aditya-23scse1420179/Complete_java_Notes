package HolidayWork;

import java.util.Scanner;
//leave every 3
public class BennyAndBroken {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            String s = String.valueOf(n);
            int ans =helper(s,0,1);
            System.out.println(ans-1);
        }

    }
    public static  int helper(String s,int idx,int tight){
        if(idx==s.length())return 1;
        int lb=0;
        int ub=(tight==1)?s.charAt(idx)-'0':9;
        int res=0;
        for(int digit =lb;digit<=ub;digit++){
            if(digit==3)continue;
            int newTight=(digit==ub && tight==1)?1:0;
            res+=helper(s,idx+1,newTight);
        }
        return res;
    }
}
