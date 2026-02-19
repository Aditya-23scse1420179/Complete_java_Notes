package graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BuildingRoads {
    public static void main(String []args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        boolean[]visit=new boolean[n+1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<n+1 ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0 ; i<m ; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(!visit[i]){
                list.add(i);
                dfs(i,visit,adj);
            }
        }System.out.println(list.size()-1);
        for(int i=0;i<list.size()-1;i++){
            System.out.println(list.get(i)+" "+list.get(i+1));
        }

    }public static  void dfs(int src,boolean[]visit,ArrayList<ArrayList<Integer>>adj){
        visit[src]=true;
        for(int a:adj.get(src)){
            if(!visit[a]){
                dfs(a,visit,adj);
            }
        }
    }
}
