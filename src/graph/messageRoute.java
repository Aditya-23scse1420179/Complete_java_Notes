package graph;

import java.io.*;
import java.util.*;

public class messageRoute {
    public static void main(String[]args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        ArrayList<Integer>ans=new ArrayList<>();
        boolean[] visit=new boolean[n+1];
        int[]parent=new int[n+1];
        Arrays.fill(parent,-1);
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }
        Queue<Integer> q=new LinkedList<>();
        q.offer(1);
        visit[1]=true;
        while(!q.isEmpty()){
            int curr=q.remove();
            for(int a:list.get(curr)){
                if(!visit[a]){
                    q.offer(a);
                    visit[a]=true;
                    parent[a]=curr;
                }
            }
        }
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        if(!visit[n]){
            bw.write("IMPOSSIBLE");
            bw.flush();
        }else{
            for(int curr=n;curr!=-1;curr=parent[curr]){
                ans.add(curr);
            }Collections.reverse(ans);
            bw.write(ans.size()+"\n");
            for(int a:ans) {
                bw.write(a + " ");

                bw.flush();
            }
        }
    }
}
