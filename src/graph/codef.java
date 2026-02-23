package graph;

import java.util.Scanner;

/*public class codef {
    static int n;
    static int[]x;
    static int[]y;
    static boolean[]visit;
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        x=new int[n];
        y=new int[n];
        visit=new boolean[n];
        for(int i=0;i<n;i++){
            x[i]=sc.nextInt();
            y[i]=sc.nextInt();
        }int comp=0;
        for(int i=0;i<n;i++){
            if(!visit[i]){
                dfs(i);
                comp++;
            }
        }
        System.out.println(comp-1);

    }public static void dfs(int i){
        visit[i]=true;
        for(int j=0;j<n;j++){
            if(!visit[j]&&(x[i]==x[j]||y[i]==y[j])){
                dfs(j);
            }
        }
    }
}*/
import java.util.*;
public class codef {
    static int n;
    static int[] x, y;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = new int[n];
        y = new int[n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                bfs(i);
                components++;
            }
        }
        System.out.println(components - 1);
    }

    public static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visit[i] = true;
        while (!q.isEmpty()) {
            int node = q.remove();
            for (int j = 0; j < n; j++) {
                if (!visit[j] && (x[node] == x[j] || y[node] == y[j])) {
                    visit[j] = true;
                    q.offer(j);
                }
            }
        }
    }
}