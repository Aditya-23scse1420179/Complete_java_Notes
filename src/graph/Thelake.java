package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*public class Thelake {
    static int []dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    static int n;
    static int m;
    static boolean[][]visit;
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0) {
            n = sc.nextInt();
            m = sc.nextInt();
            int[][] grid = new int[n][m];
            visit = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] > 0 && !visit[i][j]) {
                        ans = Math.max(ans, dfs(i, j, grid));
                    }
                }
            }
            System.out.println(ans);
        }
    }public static int dfs(int r,int c,int[][]grid){
        if(r<0||c<0||r>=n||c>=m||visit[r][c]==true||grid[r][c]==0)return 0;
        visit[r][c]=true;
        int sum=grid[r][c];
        for(int i=0;i<4;i++){
            int nrow=r+dr[i];
            int ncol=c+dc[i];
            sum+=dfs(nrow,ncol,grid);
        }
        return sum;
    }
}*/
// using bfs
class Main{
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    static int n;
    static int m;
    static boolean[][]visit;
    static class pair{
        int row;
        int col;
        public pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            n=sc.nextInt();
            m=sc.nextInt();
            int [][]grid=new int[n][m];
            visit=new boolean[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    grid[i][j]=sc.nextInt();
                }
            }int ans =0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid[i][j]>0&&!visit[i][j]){
                        ans=Math.max(ans,bfs(i,j,grid));
                    }
                }
            }
            System.out.println(ans);
        }
    }public static int bfs(int r,int c,int[][]grid ){
        Queue<pair> q=new LinkedList<>();
        q.offer(new pair(r,c));
        visit[r][c]=true;
        int sum=0;
        while(!q.isEmpty()){
            pair curr=q.remove();
            int ro=curr.row;
            int co=curr.col;
            sum+=grid[ro][co];
            for(int i=0;i<4;i++){
                int nrow=ro+dr[i];
                int ncol=co+dc[i];
                if(nrow>=0&&ncol>=0&&nrow<n&&ncol<m&&!visit[nrow][ncol]&&grid[nrow][ncol]>0){
                    visit[nrow][ncol]=true;
                    q.offer(new pair(nrow,ncol));
                }
            }
        }
        return sum;
    }
}
