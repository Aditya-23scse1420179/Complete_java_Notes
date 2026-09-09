package HolidayWork;

import java.util.*;

public class CsesLPS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0;i <n;i++)dp[i][i] = 1;
        for (int len = 2; len <= n;len++) {
            for (int i = 0;i+ len-1< n; i++) {
                int j = i+len-1;
                if(s.charAt(i)==s.charAt(j)) {
                    dp[i][j] = 2 + (i + 1 <= j - 1?dp[i+1][j-1]:0);
                }else{
                    dp[i][j] =Math.max(dp[i+1][j],dp[i][j - 1]);
                }
            }
        }
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        int i = 0,j=n -1;
        while (i<=j) {
            if (s.charAt(i)==s.charAt(j) &&(i==j||dp[i][j]==2+(i+1<= j-1?dp[i+1][j-1]:0))){
                if (i == j) left.append(s.charAt(i));
                else {
                    left.append(s.charAt(i));
                    right.append(s.charAt(j));
                }
                i++;
                j--;
            }
            else {
                int down =(i+1<= j)?dp[i+1][j]: -1;
                int leftVal = (i<=j-1)?dp[i][j -1]:-1;
                if (down>=leftVal) i++;
                else j--;
            }
        }
        System.out.println(left.toString() + right.reverse().toString());
    }
}
