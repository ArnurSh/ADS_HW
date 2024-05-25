public class Main {
    public static void main(String[] args) {
        Vertex<String> v1 = new Vertex<>("A");
        Vertex<String> v2 = new Vertex<>("B");
        Vertex<String> v3 = new Vertex<>("C");
        Vertex<String> v4 = new Vertex<>("D");

        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);

        graph.addEdge(v1, v2, 1);
        graph.addEdge(v1, v3, 4);
        graph.addEdge(v2, v3, 2);
        graph.addEdge(v2, v4, 5);
        graph.addEdge(v3, v4, 1);

        System.out.println("Graph:");
        System.out.println(graph);

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, v1);
        System.out.println("BFS path from A to D: " + bfs.pathTo(v4));

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, v1);
        System.out.println("Dijkstra path from A to D: " + dijkstra.pathTo(v4));
    }
}