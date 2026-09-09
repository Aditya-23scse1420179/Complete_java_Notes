package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Monster {
    static int []dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    static char[]dir={'U','D','L','R'};
    static int n;
    static int m;
    static boolean[][]visit;
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        char[][]grid=new char[n][m];
        int[][]dism=new int [n][m]; //to store distance of each cell from nearest monster
        int[][]disp=new int [n][m];//to store distance of each cell from player
        for(int x[]:dism){
            Arrays.fill(x,Integer.MAX_VALUE);
        }//to store distance of each cell from nearest monster
        for(int x[]:disp) {
            Arrays.fill(x,Integer.MAX_VALUE);
        }//to store distance of each cell from  player
        char parent[][]=new char[n][m];//to reconstruct path
        Queue<int[]>qm=new LinkedList<>();//monster queue
        Queue<int[]>qp=new LinkedList<>();//player queue
        boolean[][]vism=new boolean[n][m];//monster visited
        boolean[][]vis=new boolean[n][m];//player visited
        int pr=0,pc=0;
        for(int i=0;i<n;i++){
            String s=sc.next();
            for(int j=0;j<m;j++){
                grid[i][j]=s.charAt(j);
                if(grid[i][j]=='M'){//monster bfs initialization
                    qm.offer( new int[]{i,j});
                    dism[i][j]=0;
                    vism[i][j]=true;
                }if(grid[i][j]=='A'){//player bfs initialization
                    pr=i;
                    pc=j;
                    vis[i][j]=true;
                    qp.offer(new int[]{i,j});
                    disp[pr][pc]=0;
                }
            }
        }//update monster distance monster bfs
        while(!qm.isEmpty()){
            int []curr=qm.poll();
            int r=curr[0];
            int c=curr[1];
            int dis=dism[r][c];
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0&&nc>=0&&nr<n&&nc<m&&!vism[nr][nc]&&grid[nr][nc]=='.'&&1+dis<dism[nr][nc]){
                    dism[nr][nc]=1+dis;
                    vism[nr][nc]=true;
                    qm.offer(new int[]{nr,nc});
                }
            }
        }//player bfs
        int er=-1,ec=-1;
        while(!qp.isEmpty()){
            int []curr=qp.poll();
            int r=curr[0];
            int c=curr[1];
            int dis=disp[r][c];
            if(r==0||c==0||r==n-1||c==m-1){
                er=r;ec=c;
                break;
            }
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                char direction=dir[i];
                if(nr>=0&&nc>=0&&nr<n&&nc<m&&!vis[nr][nc]&&grid[nr][nc]=='.'&&1+dis<disp[nr][nc]&&dis + 1 < dism[nr][nc]){
                    disp[nr][nc]=1+dis;
                    vis[nr][nc]=true;
                    qp.offer(new int[]{nr,nc});
                    parent[nr][nc]=direction;
                }
            }
        }//path reconstruction
        if(er==-1&&ec==-1)
        {
            System.out.println("NO");
            return;
        }
        StringBuilder path=new StringBuilder();
        int r=er,c=ec;
        while(r!=pr||c!=pc){
            path.append(parent[r][c]);
            if(parent[r][c]=='U')r++;
            else if(parent[r][c]=='D')r--;
            else if(parent[r][c]=='L')c++;
            else if(parent[r][c]=='R')c--;

        }System.out.println("YES");
        System.out.println(path.length());
        System.out.println(path.reverse());
    }

}
