import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private final Map<Vertex<V>, Double> distTo;
    private final Map<Vertex<V>, Vertex<V>> edgeTo;
    private final PriorityQueue<Vertex<V>> pq;
    private final Vertex<V> source;

    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> source) {
        this.source = source;
        distTo = new HashMap<>();
        edgeTo = new HashMap<>();
        pq = new PriorityQueue<>(Comparator.comparing(distTo::get));

        for (Vertex<V> vertex : graph.getMap().keySet()) {
            distTo.put(vertex, Double.POSITIVE_INFINITY);
        }
        distTo.put(source, 0.0);

        pq.add(source);
        while (!pq.isEmpty()) {
            Vertex<V> v = pq.poll();
            for (Map.Entry<Vertex<V>, Double> entry : v.getAdjacentVertices().entrySet()) {
                relax(v, entry.getKey(), entry.getValue());
            }
        }
    }

    private void relax(Vertex<V> v, Vertex<V> w, double weight) {
        if (distTo.get(w) > distTo.get(v) + weight) {
            distTo.put(w, distTo.get(v) + weight);
            edgeTo.put(w, v);
            pq.add(w);
        }
    }

    @Override
    public boolean hasPathTo(Vertex<V> destination) {
        return distTo.get(destination) < Double.POSITIVE_INFINITY;
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