package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class partycf {
    static int ans=0;
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        int []parents=new int[n+1];
        for(int i=1;i<=n;i++){
            parents[i]=sc.nextInt();
            if(parents[i]!=-1){
                list.get(parents[i]).add(i);//parent-->child
            }
        }for(int i=1;i<=n;i++){
            if(parents[i]==-1){
                dfs(i,list,1);
            }
        }
        System.out.println(ans);
    }public static void dfs(int src,ArrayList<ArrayList<Integer>>list,int depth){
        ans=Math.max(ans,depth);
        for(int child:list.get(src)) {
            dfs(child, list, depth + 1);
        }
    }
}
