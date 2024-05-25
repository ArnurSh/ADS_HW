import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private Map<Vertex<V>, Vertex<V>> edgeTo;
    private Set<Vertex<V>> marked;
    private final Vertex<V> source;

    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> source) {
        this.source = source;
        edgeTo = new HashMap<>();
        marked = new HashSet<>();
        bfs(graph, source);
    }

    private void bfs(WeightedGraph<V> graph, Vertex<V> source) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        marked.add(source);
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex<V> v = queue.poll();
            for (Vertex<V> w : v.getAdjacentVertices().keySet()) {
                if (!marked.contains(w)) {
                    edgeTo.put(w, v);
                    marked.add(w);
                    queue.add(w);
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(Vertex<V> destination) {
        return marked.contains(destination);
    }

    @Override
    public List<Vertex<V>> pathTo(Vertex<V> destination) {
        if (!hasPathTo(destination)) return null;
        List<Vertex<V>> path = new ArrayList<>();
        for (Vertex<V> x = destination; x != source; x = edgeTo.get(x)) {
            path.add(x);
        }
        path.add(source);
        Collections.reverse(path);
        return path;
    }
}
