package DynamicProgramming;
import java.util.Scanner;
public class KnapsackUnbound {
    /*public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[]wt=new int[n];
        int[]val=new int[n];
        for(int i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            val[i]=sc.nextInt();
        }
        System.out.println(helper(0,wt,val,c));
    }
    public static int helper(int idx,int[]wt,int[]val,int C){
        if(idx==wt.length||C<=0)return 0;
        int take=-(int)1e9;
        if(wt[idx]<=C){
            take=helper(idx,wt,val,C-wt[idx])+val[idx];
        }
        int nottake=helper(idx+1,wt,val,C);
        return Math.max(take,nottake);
    }*/
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int C = sc.nextInt();
        int[] wt = new int[n];
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }
        int[][] dp = new int[n+1][C+1];
        for (int i =1;i<=n;i++) {
            for (int j=1;j<=C;j++) {
                int take=-(int) 1e9;
                if (wt[i-1]<=j){
                    take = dp[i][j-wt[i-1]]+val[i-1];
                }
                int nottake =dp[i-1][j];
                dp[i][j]=Math.max(take,nottake);
            }
        }
        System.out.println(dp[n][C]);
    }
}
