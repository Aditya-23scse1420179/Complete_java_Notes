package graph;

class DFS{
    static int []dr={-1,1,0,0};//up,down,left,right
    static int []dc={0,0,-1,1};
    static int rowL;
    static int colL;
    public static void main(String[] args){
        int [][]grid={{1,1,0,0},{1,1,0,0},{0,0,1,1},{0,0,1,1}};
        rowL=grid.length;
        colL=grid[0].length;
        boolean[][]visit=new boolean[rowL][colL];
        int component=0;
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(!visit[i][j]&&grid[i][j]==1){
                    dfs(i,j,visit,grid);
                    component++;
                }
            }
        }
        System.out.println(component);
    }

    private static void dfs(int r, int c, boolean[][] visit, int[][] grid) {
        if(r<0||c<0||r>=rowL||c>=colL||grid[r][c]==0) return;
        if(visit[r][c])return ;
        visit[r][c]=true;
        /*dfs(r+1,c,visit,grid);//down
        dfs(r-1,c,visit,grid);//up
        dfs(r,c+1,visit,grid);//right
        dfs(r,c-1,visit,grid);//left */ // ya to aise to gobal nahi bana padega ;
        for(int i=0;i<4;i++){
            dfs(r+dr[i],c+dc[i],visit,grid);
        }
    }
}