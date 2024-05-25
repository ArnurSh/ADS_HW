import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Edge<Vertex<V>>>> map;

    public WeightedGraph() {
        map = new HashMap<>();
    }

    public void addVertex(Vertex<V> vertex) {
        map.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight) {
        Edge<Vertex<V>> edge = new Edge<>(source, dest, weight);
        map.get(source).add(edge);
        source.addAdjacentVertex(dest, weight);
    }

    public Map<Vertex<V>, List<Edge<Vertex<V>>>> getMap() {
        return map;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertex<V> vertex : map.keySet()) {
            sb.append(vertex.toString()).append(": ");
            for (Edge<Vertex<V>> edge : map.get(vertex)) {
                sb.append(edge.getDest().toString()).append("(").append(edge.getWeight()).append(") ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}