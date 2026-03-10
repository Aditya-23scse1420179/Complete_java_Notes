package graph;

import java.util.Scanner;

public class InDegreeAndOutDegree {
    public static void main(String[] args) {
        int n =3;
        int[][] trust = {
                {1, 3},
                {2, 3},
                {3, 1}
        };
        int []indegree=new int [n+1];
        int []outdegree=new int [n+1];
        for(int i=0;i<trust.length;i++){
            int u=trust[i][0];
            int v=trust[i][1];
            indegree[v]++;
            outdegree[u]++;
        }for(int i=1;i<=n;i++){
            if(indegree[i]==n-1&&outdegree[i]==0){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

}
