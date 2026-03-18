package test1;

// User function Template for Java

/*class Solution {
    public int repeatingsubseq(String s) {
        // code here
        Integer[][]dp=new Integer[s.length()+1][s.length()+1];
        return helper(s,s,0,0,dp);
    }
    public static int helper(String s1,String s2,int i,int j,Integer[][]dp){
        if(i==s1.length()||j==s2.length())return 0;
        if(dp[i][j]!=null)return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)&&i!=j){
            return dp[i][j]=1+helper(s1,s2,i+1,j+1,dp);
        }else{
            return dp[i][j]= Math.max(helper(s1,s2,i+1,j,dp),helper(s1,s2,i,j+1,dp));
        }
    }
}*/
// User function Template for Java
//tabulation
class repeatingsubseq {
    public int LongestRepeatingSubsequence(String s) {
        // code here
        int n=s.length();
        int[][]dp=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==s.charAt(j-1)&&i!=j){
                    dp[i][j]=1+(dp[i-1][j-1]);
                }else{
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
//        int lcs= dp[n][m];
//        return (n-lcs)+(m-lcs); if we want to find min deletions to make two strings identical
    }
}
