package HolidayWork;

import java.util.*;

public class RectangleCutting {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int a =sc.nextInt();
        int b =sc.nextInt();
        int[][] dp =new int[a+1][b+1];
        for(int i = 1;i <=a;i++){
            for(int j = 1;j <= b;j++){
                if(i==j){
                    dp[i][j] =0;
                }else{
                    int best =(int)1e9;
                    // vertical cuts
                    for(int x = 1;x <i;x++){
                        best =Math.min(best,dp[x][j] +dp[i-x][j]+1);
                    }
                    // horizontal cuts
                    for(int y =1;y <j;y++){
                        best =Math.min(best,dp[i][y]+dp[i][j-y] +1);
                    }
                    dp[i][j] =best;
                }
            }
        }
        System.out.println(dp[a][b]);
    }
}

