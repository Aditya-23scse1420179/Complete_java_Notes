package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class pathexistingraph {
    boolean found =false;
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start==end)return true;
        Map<Integer,List<Integer>> graph=new HashMap<>();
        boolean[]visited=new boolean[n];
        for(int i=0;i<n;i++){
            graph.put(i,new ArrayList());
        }
        for(int[]edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }dfs(graph,visited,start,end);
        return found;
    }public void dfs(Map<Integer, List<Integer>>graph, boolean[]visited, int start , int end ){
        if(visited[start]||found)return ;
        visited[start]=true;
        for(int n:graph.get(start)){
            if(n==end){
                found=true;
                break;
            }
            if(!visited[n]){
                dfs(graph,visited,n,end);
            }
        }
    }
}
//TC:O(V+E)