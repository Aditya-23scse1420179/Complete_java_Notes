package graph;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class shortestRoute1 {
    static class pair{
        int node;
        long dist;
        public pair(int node, long dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public static void main(String[]args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());//cities
        int m=Integer.parseInt(st.nextToken());//edges
        long []distance=new long[n+1];
        Arrays.fill(distance,Long.MAX_VALUE);
        ArrayList<ArrayList<pair>>list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            long w=Long.parseLong(st.nextToken());
            list.get(u).add(new pair(v,w));
        }distance[1]=0;
        PriorityQueue<pair>q=new PriorityQueue<>((a,b)->Long.compare(a.dist,b.dist));
        q.offer(new pair(1,0));
        while(!q.isEmpty()){
            pair curr=q.poll();
            int node=curr.node;
            long dist=curr.dist;
            if(distance[node]<dist)continue;
            for(pair a:list.get(node)){
                int v=a.node;
                long w=a.dist;
                if(distance[v]>distance[node]+w){
                    distance[v]=distance[node]+w;
                    q.offer(new pair(v,distance[v]));
                }
            }
        }
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1;i<distance.length;i++){
            bw.write(distance[i]+" ");
        }bw.flush();
    }
}
