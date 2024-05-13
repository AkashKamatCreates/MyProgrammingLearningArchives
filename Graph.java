import java.util.*;

public class Graph {

    // Primitive implementation of directed graph
    static class DirectedGraph {
        private int V;
        private List<Integer>[] adjList;

        public DirectedGraph(int V) {
            this.V = V;
            adjList = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adjList[i] = new ArrayList<>();
            }
        }

        public void addEdge(int u, int v) {
            adjList[u].add(v);
        }

        public Iterable<Integer> getAdjVertices(int v) {
            return adjList[v];
        }
    }

    // Primitive implementation of undirected graph
    static class UndirectedGraph {
        private int V;
        private List<Integer>[] adjList;

        public UndirectedGraph(int V) {
            this.V = V;
            adjList = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adjList[i] = new ArrayList<>();
            }
        }

        public void addEdge(int u, int v) {
            adjList[u].add(v);
            adjList[v].add(u); // For undirected graph
        }

        public Iterable<Integer> getAdjVertices(int v) {
            return adjList[v];
        }
    }

    // Non-primitive implementation of weighted directed graph
    static class WeightedDirectedGraph {
        private int V;
        private Map<Integer, List<Edge>> adjList;

        public WeightedDirectedGraph(int V) {
            this.V = V;
            adjList = new HashMap<>();
            for (int i = 0; i < V; i++) {
                adjList.put(i, new ArrayList<>());
            }
        }

        public void addEdge(int u, int v, int weight) {
            adjList.get(u).add(new Edge(v, weight));
        }

        public Iterable<Edge> getAdjVertices(int v) {
            return adjList.get(v);
        }

        static class Edge {
            int to;
            int weight;

            Edge(int to, int weight) {
                this.to = to;
                this.weight = weight;
            }
        }
    }

    // Non-primitive implementation of weighted undirected graph
    static class WeightedUndirectedGraph {
        private int V;
        private Map<Integer, List<Edge>> adjList;

        public WeightedUndirectedGraph(int V) {
            this.V = V;
            adjList = new HashMap<>();
            for (int i = 0; i < V; i++) {
                adjList.put(i, new ArrayList<>());
            }
        }

        public void addEdge(int u, int v, int weight) {
            adjList.get(u).add(new Edge(v, weight));
            adjList.get(v).add(new Edge(u, weight)); // For undirected graph
        }

        public Iterable<Edge> getAdjVertices(int v) {
            return adjList.get(v);
        }

        static class Edge {
            int to;
            int weight;

            Edge(int to, int weight) {
                this.to = to;
                this.weight = weight;
            }
        }
    }

    public static void main(String[] args) {
        // Directed Graph
        DirectedGraph directedGraph = new DirectedGraph(5);
        directedGraph.addEdge(0, 1);
        directedGraph.addEdge(0, 2);
        directedGraph.addEdge(1, 3);
        directedGraph.addEdge(2, 4);

        // Undirected Graph
        UndirectedGraph undirectedGraph = new UndirectedGraph(5);
        undirectedGraph.addEdge(0, 1);
        undirectedGraph.addEdge(0, 2);
        undirectedGraph.addEdge(1, 3);
        undirectedGraph.addEdge(2, 4);

        // Weighted Directed Graph
        WeightedDirectedGraph weightedDirectedGraph = new WeightedDirectedGraph(5);
        weightedDirectedGraph.addEdge(0, 1, 10);
        weightedDirectedGraph.addEdge(0, 2, 20);
        weightedDirectedGraph.addEdge(1, 3, 15);
        weightedDirectedGraph.addEdge(2, 4, 25);

        // Weighted Undirected Graph
        WeightedUndirectedGraph weightedUndirectedGraph = new WeightedUndirectedGraph(5);
        weightedUndirectedGraph.addEdge(0, 1, 10);
        weightedUndirectedGraph.addEdge(0, 2, 20);
        weightedUndirectedGraph.addEdge(1, 3, 15);
        weightedUndirectedGraph.addEdge(2, 4, 25);
    }
}
