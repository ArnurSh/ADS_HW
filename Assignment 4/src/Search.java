import java.util.List;

public interface Search<V> {
    List<Vertex<V>> pathTo(Vertex<V> destination);
    boolean hasPathTo(Vertex<V> destination);
}