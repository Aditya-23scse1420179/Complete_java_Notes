package DynamicProgramming;

public class Painthouse {
    public static int solve(int [][]paint){
        int [][]dp= new int [paint.length][paint[0].length];
        for(int i=0;i<paint[0].length;i++){
            dp[0][i]=paint[0][i];
        }
        for(int i=1;i<paint.length;i++){
            dp[i][0]=paint[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1]=paint[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2]=paint[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);
        }
        return Math.min(dp[paint.length-1][0],Math.min(dp[paint.length-1][1],dp[paint.length-1][2]));
    }
    public static void main(String[]args){
        int [][]paint = {
                {17,2,17},
                {16,16,5},
                {14,3,19}
        };
        System.out.println(solve(paint));

    }
}
