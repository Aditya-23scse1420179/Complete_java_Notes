package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JuhuBhai {
    static class pair{
        int node;
        long dist;
        public pair(int node,long dist){
            this.node=node;
            this.dist=dist;
        }
    }static class state{
        int sadak;
        long cost;
        int via;
        public state(int sadak,long cost,int via){
            this.sadak=sadak;
            this.cost=cost;
            this.via=via;
        }
    }
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new  StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<pair>>list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());

        }
        for(int i=1;i<=m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            list.get(u).add(new pair(v,w));
            list.get(v).add(new pair(u,w));
        }long[]distance=new long[n+1];
        Arrays.fill(distance,Long.MAX_VALUE);
        distance[1]=0;
        PriorityQueue<state> q=new PriorityQueue<>((a,b)->Long.compare(a.cost,b.cost));
        q.offer(new state(1,0,0));//0 represent road,1 represet road
        for(int i=0;i<k;i++){
            st=new StringTokenizer(br.readLine());
            int ncity=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            q.offer(new state(ncity,c,1));
        }int remove=0;
        boolean[]visit=new boolean[n+1];
        while(!q.isEmpty()){
            state cur = q.poll();
            int u = cur.sadak;
            long weight = cur.cost;
            int via = cur.via;
            if(via == 1){
                if(distance[u] <= weight){
                    remove++;
                    continue;
                }
                distance[u]=weight;
            } else {
                if(weight>distance[u]) continue;
            }
            for(pair a:list.get(u)){
                int v = a.node;
                long C = a.dist;
                if(distance[v]>weight+C){
                    distance[v]=weight+C;
                    q.offer(new state(v,distance[v],0));
                }
            }
        }
        System.out.println(remove);

    }
}
