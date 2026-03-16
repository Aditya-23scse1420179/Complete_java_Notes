package HolidayWork;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LuckyCommonSubseq {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine().trim();
        String s2 = br.readLine().trim();
        String virus = br.readLine().trim();
        int n = s1.length();
        int m = s2.length();
        int v = virus.length();
        int[][] nxt = new int[v][26];
        int[] lps = new int[v];
        for (int i =1,j= 0;i< v;) {
            if (virus.charAt(i)== virus.charAt(j)) {
                lps[i++] =++j;
            }else if(j>0){
                j =lps[j-1];
            }else{
                lps[i++] =0;
            }
        }
        for (int i = 0;i <v;i++) {
            for (int c = 0;c< 26;c++) {
                int j =i;
                while(j>0&&virus.charAt(j)!= (char)('A' + c)) {
                    j =lps[j-1];
                }
                if (virus.charAt(j) ==(char)('A' + c)) {
                    j++;
                }
                nxt[i][c]=j;
            }
        }
        int[][][] dp = new int[n + 1][m + 1][v];
        String[][][] choice = new String[n + 1][m + 1][v];
        for (int i = n; i >= 0; i--) {
            for (int j = m; j >= 0; j--) {
                for (int k = 0; k < v; k++) {
                    int best = 0;
                    String bestStr = "";
                    if (i < n && dp[i + 1][j][k] > best) {
                        best = dp[i + 1][j][k];
                        bestStr = "SKIP1";
                    }
                    if (j < m &&dp[i][j + 1][k] > best) {
                        best = dp[i][j + 1][k];
                        bestStr = "SKIP2";
                    }
                    if (i < n && j <m && s1.charAt(i) == s2.charAt(j)) {
                        int c = s1.charAt(i) - 'A';
                        int nk = nxt[k][c];
                        if (nk < v) {
                            int cand = 1 + dp[i + 1][j + 1][nk];
                            if (cand > best) {
                                best = cand;
                                bestStr = "TAKE";
                            }
                        }
                    }
                    dp[i][j][k] = best;
                    choice[i][j][k] = bestStr;
                }
            }
        }
        if (dp[0][0][0] == 0) {
            System.out.println(0);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0, k = 0;
        while (i <= n && j <= m) {
            String act = choice[i][j][k];
            if (act == null || act.isEmpty()) break;
            if (act.equals("SKIP1")) {
                i++;
            } else if (act.equals("SKIP2")) {
                j++;
            } else if (act.equals("TAKE")) {
                char c = s1.charAt(i);
                sb.append(c);
                int newK = nxt[k][c - 'A'];
                i++;
                j++;
                k = newK;
            }
        }
        System.out.println(sb.toString());
    }
}
