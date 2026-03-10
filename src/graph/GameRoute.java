package graph;

import java.io.*;

import java.util.*;

public class GameRoute {
    static int mod=1000000007;
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());//cities
        int m=Integer.parseInt(st.nextToken());//flight
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        int []indegree=new int[n+1];
        int[]ways=new int[n+1];//dp
        ways[1]=1;
        for(int i=1;i<=m;i++){
            st=new  StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }//now bfs
        while(!q.isEmpty()){
            int u=q.remove();
            for(int v:list.get(u)){
                if(ways[u]>0&&ways[u]+ways[v]>ways[v]){
                    ways[v]=(ways[u]+ways[v])%mod;
                }
                indegree[v]--;
                if(indegree[v]==0){
                    q.offer(v);
                }
            }
        }
        System.out.println(ways[n]);
    }
}
