package graph;
//ts sc=O(nxm) for bfs and path construction
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*public class Labyrinth {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    static char[]dir={'U','D','L','R'};
    static int m;
    static int n;
    static class pair {
        int row;
        int col;

        public pair(int row,int col) {
            this.row = row;
            this.col = col;
        }
    }
    static boolean[][]visit;
    static int[][]parent;
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        m=sc.nextInt();
        n=sc.nextInt();
        char[][]grid=new char[m][n];
        for(int i=0;i<m;i++){
            String s=sc.next();
            for(int j=0;j<n;j++){
                grid[i][j]=s.charAt(j);
            }
        }
        int sr=0,scc=0,er=0,ec=0;
        visit=new boolean[m][n];
        parent=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='A'){sr=i;scc=j;}
                if(grid[i][j]=='B'){er=i;ec=j;}
            }
        }
        visit[sr][scc]=true;
        bfs(sr,scc,grid);
        StringBuilder path=new StringBuilder();
        int r=er;int c=ec;
        while(grid[r][c]!='A'){
            int d=parent[r][c];
            path.append(dir[d]);
            r=r-dr[d];
            c=c-dc[d];
        }System.out.print("yes");
        System.out.println(path.length());
        System.out.println(path.reverse());
    }public static void bfs(int i,int j,char[][]grid){
        Queue<pair>q=new LinkedList<>();
        q.offer(new pair(i,j));
        while(!q.isEmpty()){
            pair curr=q.remove();
            int r=curr.row;
            int c=curr.col;
            for(int k=0;k<4;k++){
                int nr=r+dr[k];
                int nc=c+dc[k];
                if(nr>=0&&nc>=0&&nr<m&&nc<n&&grid[nr][nc]!='#'&&!visit[nr][nc]){
                    visit[nr][nc]=true;
                    parent[nr][nc]=k;
                    q.offer(new pair(nr,nc));
                }
            }
        }
    }
}*/
class labyrinth{
    static int[]dr={-1,1,0,0};
    static int []dc={0,0,-1,1};
     static char []dir={'U','D','L','R'};
    public static void main(String[]args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        boolean[][] visit=new boolean[n][m];
        char[][]parent=new char[n][m];
        char[][]grid=new char[n][m];
        int sr=0,sc=0,er=0,ec=0;
        for(int i=0;i<n;i++){
            String s=br.readLine();
            for(int j=0;j<m;j++){
                grid[i][j]=s.charAt(j);
                if(grid[i][j]=='A'){
                    sr=i;
                    sc=j;
                }if(grid[i][j]=='B'){
                    er=i;
                    ec=j;
                }
            }
        }
        Queue<int[]>q=new LinkedList<>();
        q.offer(new int[]{sr,sc});
        visit[sr][sc]=true;
        while(!q.isEmpty()){
            int []curr=q.remove();
            int r=curr[0];
            int c=curr[1];
            for(int k=0;k<4;k++){
                int nr=r+dr[k];
                int nc=c+dc[k];
                char d=dir[k];
                if(nr>=0&&nc>=0&&nr<n&&nc<m&&grid[nr][nc]=='B'&&!visit[nr][nc]){
                    visit[nr][nc]=true;
                    parent[nr][nc]=d;
                    q.offer(new int[]{nr,nc});
                }
                if(nr>=0&&nc>=0&&nr<n&&nc<m&&grid[nr][nc]=='.'&&!visit[nr][nc]){
                    visit[nr][nc]=true;
                    q.offer(new int[]{nr,nc});
                    parent[nr][nc]=d;
                }
            }
        }StringBuilder path=new StringBuilder();
        int r=er,c=ec;
        while(r!=sr||c!=sc){
            path.append(parent[r][c]);
            if(parent[r][c]=='U')r++;
            else if(parent[r][c]=='D')r--;
            else if(parent[r][c]=='L')c++;
            else if(parent[r][c]=='R')c--;

        }System.out.println(path.reverse());
        System.out.println(path.length());

    }
}
