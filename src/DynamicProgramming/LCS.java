package DynamicProgramming;

public class LCS {
    public static void main(String[]args){
        String s1="AGGTAB";
        String s2="GXTXAYB";
        int [][]dp=new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        int i=s1.length(),j=s2.length();
        while(i>0&&j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }else {
                j--;
            }
        }
        System.out.println(sb.reverse().toString());
    }
}
/*Set<String> allLCS = backtrack(s1, s2, s1.length(), s2.length());
        for (String s : allLCS) {
            System.out.println(s);
        }
    }
    public static Set<String> backtrack(String s1, String s2, int i, int j) {
        Set<String> result = new HashSet<>();
        if (i == 0 || j == 0) {
            result.add("");
            return result;
        }
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            Set<String> prev = backtrack(s1, s2, i - 1, j - 1);
            for (String str : prev) {
                result.add(str + s1.charAt(i - 1));
            }
        } else {
            if (dp[i - 1][j] >= dp[i][j - 1]) {
                result.addAll(backtrack(s1, s2, i - 1, j));
            }
            if (dp[i][j - 1] >= dp[i - 1][j]) {
                result.addAll(backtrack(s1, s2, i, j - 1));
            }
        }
        return result;
    }
}*/ // to print all lcs
