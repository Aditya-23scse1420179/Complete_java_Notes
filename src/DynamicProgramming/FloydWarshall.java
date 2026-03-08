package DynamicProgramming;

class  FloydWarshall {

    static final int INF = 1000000000; // a big number
    static void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];
        // copy graph → dist
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] = graph[i][j];
        // core Floyd–Warshall
        for (int k = 0; k < V; k++) {            // pick intermediate node
            for (int i = 0; i < V; i++) {        // pick source
                for (int j = 0; j < V; j++) {    // pick destination
                    if (dist[i][k] != INF && dist[k][j] != INF &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        // print result
        printSolution(dist, V);
    }
    static void printSolution(int dist[][], int V) {
        System.out.println("All-pairs shortest path matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int INF = 1000000000;
        int graph[][] = {
                {0,   5,  INF, 10},
                {INF, 0,   3,  INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };
        floydWarshall(graph, 4);
    }
}
