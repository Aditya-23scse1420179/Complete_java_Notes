package graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Investigation {
    static class pair{
        int node;
        long dist;
        public pair(int node,long dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public static void main(String[]args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());//cities
        int m=Integer.parseInt(st.nextToken());//edges
        long[]distance=new long[n+1];
        Arrays.fill(distance,Long.MAX_VALUE);
        int[]minF=new int[n+1];
        Arrays.fill(minF,Integer.MAX_VALUE);
        int[]maxF=new int[n+1];
        Arrays.fill(maxF,Integer.MIN_VALUE);
        int []ways=new int[n+1];
        distance[1]=0;
        ways[1]=1;
        minF[1]=0;
        maxF[1]=0;
        ArrayList<ArrayList<pair>>list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            list.get(u).add(new pair(v,w));
        }
        PriorityQueue<pair> q=new PriorityQueue<>((a,b)->Long.compare(a.dist,b.dist));
        q.offer(new pair(1,0));
        while(!q.isEmpty()){
            pair curr=q.remove();
            int node=curr.node;
            long dist=curr.dist;
            if(distance[node]<dist)continue;
            for(pair a:list.get(node)){
                int v=a.node;
                long w=a.dist;
                if(distance[v]>distance[node]+w){
                    distance[v]=distance[node]+w;
                    ways[v]=ways[node];
                    q.offer(new pair(v,distance[v]));
                    maxF[v]=maxF[node]+1;
                    minF[v]=minF[node]+1;
                }else if(distance[v]==distance[node]+w){
                    ways[v]=(ways[v]+ways[node])%1000000007;
                    minF[v] = Math.min(minF[v], minF[node] + 1);
                    maxF[v] = Math.max(maxF[v], maxF[node] + 1);
                }
            }
        }
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(distance[n] + " " + ways[n]+" "+minF[n]+" "+maxF[n]);
        bw.flush();
    }
}
