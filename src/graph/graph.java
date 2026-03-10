package graph;

import java.util.ArrayList;
import java.util.List;

class graph {
    /*public static void main(String[] args) {  // space complexity is (v^2)
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int[][] grp = new int[n + 1][n + 1];
        for (int i = 0; i < e; i++) {
            int c = sc.nextInt();
            int m = sc.nextInt();
            grp[c][m] = 1;
            grp[m][c] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(grp[i][j] + " ");
            }
            System.out.println();
        }
    }
    }*/
    public static int main(String[] args) {
        int[][] edge = {{1, 2}, {2, 3}, {1, 4}};
        List<List<Integer>> adjency = new ArrayList<>();
        int n = edge.length;
        int m = edge[0].length;
        for (int i = 0; i < n + 1; i++) {
            adjency.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            adjency.get(u).add(v);
            adjency.get(v).add(u);
        }
        //if we have to find the vertices with max len list
        int max = 0;
        int maxlen = 0;
        for (int i = 1; i <= adjency.size(); i++) {
            if (adjency.get(i).size() > maxlen) {
                maxlen = adjency.get(i).size();
                max = i;
            }
        }
        return max;
    }
}

