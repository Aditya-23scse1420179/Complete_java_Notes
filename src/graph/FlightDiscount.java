package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FlightDiscount {
    static class pair{
        int node;
        long dist;
        public pair(int node,long dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public static void main(String[]args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        long[]distance=new long[n+1];
        Arrays.fill(distance,Long.MAX_VALUE);
        distance[1]=0;
        long[]distance2=new long[n+1];
        Arrays.fill(distance2,Long.MAX_VALUE);
        distance2[n]=0;
        ArrayList<ArrayList<pair>>list=new ArrayList<>();
        ArrayList<ArrayList<pair>>graph=new ArrayList<>();
        int[][]edges=new int[m][3];
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            list.get(u).add(new pair(v,w));
            graph.get(v).add(new pair(u,w));
            edges[i][0]=u;
            edges[i][1]=v;
            edges[i][2]=w;
        }
        PriorityQueue<pair>q=new PriorityQueue<>((a,b)->Long.compare(a.dist,b.dist));
        q.offer(new pair(1,0));
        while(!q.isEmpty()){
            pair curr=q.remove();
            int u=curr.node;
            long w=curr.dist;
            if(distance[u]<w)continue;
            for(pair a:list.get(u)){
                int v=a.node;
                long W=a.dist;
                if(distance[v]>distance[u]+W){
                    distance[v]=distance[u]+W;
                    q.offer(new pair(v,distance[v]));
                }
            }
        }q.offer(new pair(n,0));
        while(!q.isEmpty()){
            pair curr=q.remove();
            int u=curr.node;
            long d=curr.dist;
            for(pair a:graph.get(u)){
                int v=a.node;
                long w=a.dist;
                if(distance2[v]>distance2[u]+w){
                    distance2[v]=distance2[u]+w;
                    q.offer(new pair(v,distance2[v]));
                }
            }
        }
        long ans=Long.MAX_VALUE;
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            if(distance[u]==Long.MAX_VALUE||distance2[v]==Long.MAX_VALUE)continue;
            ans=Math.min(ans,distance[u]+distance2[v]+w/2);
        }
        System.out.println(ans);
    }
}
