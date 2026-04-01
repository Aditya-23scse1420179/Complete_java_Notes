package graph;

import java.io.*;
import java.util.*;

public class RoundTrip {
    static ArrayList<ArrayList<Integer>>list;
    static int[]parent;
    static boolean[]visit;
    static boolean found;
    static ArrayList<Integer> path=new ArrayList<>();
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }for(int i=0;i<m;i++){
            st=new  StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }parent=new int[n+1];
        Arrays.fill(parent,-1);
        visit=new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(!visit[i]&&!found){
                dfs(i,-1);
            }
        }
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        if(!found){
            bw.write("IMPOSSIBLE");
            bw.flush();
            return;
        }
        bw.write(path.size() + "\n");
        for (int i : path) {
            bw.write(i + " ");
        }
        bw.flush();
    }public static void dfs(int src,int par){
        visit[src]=true;
        for(int a:list.get(src)){
            if(found)return;
            if(!visit[a]){
                parent[a]=src;
                dfs(a,src);
            }else if(a!=par){
                buildpath(src,a);
                found=true;
                return;
            }
        }
    }public static void buildpath(int src,int a){
        path.add(a);
        int curr=src;
        while(curr!=a){
            path.add(curr);
            curr=parent[curr];
        }path.add(a);
        Collections.reverse(path);
    }
}
