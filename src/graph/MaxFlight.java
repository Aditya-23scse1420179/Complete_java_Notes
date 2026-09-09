package graph;

import java.io.*;

import java.util.*;

public class MaxFlight {
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());//cities
        int m=Integer.parseInt(st.nextToken());//flight
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }int[]parent=new  int[n+1];//to print path
        Arrays.fill(parent,-1);
        int []indegree=new int[n+1];
        int[]countcities=new int[n+1];//dp
        countcities[1]=1;
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
                if(countcities[u]>0&&countcities[u]+1>countcities[v]){
                    countcities[v]=countcities[u]+1;
                    parent[v]=u;
                }indegree[v]--;
                if(indegree[v]==0){
                    q.offer(v);
                }
            }
        }if(countcities[n]==0){
            System.out.println("IMPOSSIBLE");
            return;
        }ArrayList<Integer>path=new ArrayList<>();
        for(int curr=n;curr!=-1;curr=parent[curr]){
            path.add(curr);
        }Collections.reverse(path);
        int pathL=path.size();
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(pathL+"\n");
        for(int val:path){
            bw.write(val+" ");
        }bw.flush();
    }
}
