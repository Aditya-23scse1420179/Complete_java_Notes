package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BRoadDsu {
    static int[]parent;
    static int []rank;
    public static void main(String[]args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        ArrayList<Integer>ans=new ArrayList<>();
        for(int j=0;j<m;j++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            unionrank(u,v);
        }for(int i=1;i<=n;i++){
            if(parent[i]==i) {
                ans.add(i);
            }
        }
        System.out.println(ans.size()-1);
        for(int i=1;i<ans.size();i++){
            System.out.println(ans.get(i-1)+" "+ans.get(i));
        }


    }public static int find(int x){
        if(x==parent[x])return x;
        return parent[x]=find(parent[x]);
    }public static boolean unionrank(int x,int y){
        int p_x=find(x);
        int p_y=find(y);
        if(p_x==p_y)return false;
        if(rank[p_x]>rank[p_y]){
            parent[p_y]=p_x;
        }else if(rank[p_y]>rank[p_x]){
            parent[p_x]=p_y;
        }else{
            parent[p_x]=p_y;
            rank[p_y]++;
        }
        return true;
    }
}
