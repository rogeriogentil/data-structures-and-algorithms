package rogeriogentil.data.structures.chapter14;

import java.util.HashSet;
import java.util.Set;
import rogeriogentil.data.structures.chapter07.LinkedPositionalList;
import rogeriogentil.data.structures.chapter07.PositionalList;
import rogeriogentil.data.structures.chapter10.Map;
import rogeriogentil.data.structures.chapter10.UnsortedTableMap;

/**
 *
 * @author Rogerio J. Gentil
 * @param <V> Vertex
 * @param <E> Edge
 */
public class GraphTraversals<V, E> {

    /**
     * Performs depth-first search (DFS) of graph starting at vertex u.
     *
     * @param <V>
     * @param <E>
     * @param graph
     * @param u
     * @param known
     * @param forest
     */
    public static <V, E> void DFS(Graph<V, E> graph, Vertex<V> u, Set<Vertex<V>> known, Map<Vertex<V>, Edge<E>> forest) {
        known.add(u); // u has been discovered

        for (Edge<E> e : graph.outgoingEdges(u)) {
            Vertex<V> v = graph.opposite(u, e);

            if (!known.contains(v)) {
                forest.put(v, e);           // e is the tree edge that discovered v
                DFS(graph, v, known, forest);
            }
        }
    }

    /**
     * Returns an ordered list of edges comprising the directed path from u to
     * v.
     *
     * @param <V>
     * @param <E>
     * @param graph
     * @param u
     * @param v
     * @param forest
     * @return
     */
    public static <V, E> PositionalList<Edge<E>> constructPath(Graph<V, E> graph,
            Vertex<V> u, Vertex<V> v, Map<Vertex<V>, Edge<E>> forest) {
        PositionalList<Edge<E>> path = new LinkedPositionalList<>();

        if (forest.get(v) != null) {        // v was discovered during the search
            Vertex<V> walk = v;             // we construct the path from back to front

            while (walk != u) {
                Edge<E> edge = forest.get(walk);
                path.addFirst(edge);        // add edge to *front* of path
                walk = graph.opposite(walk, edge);
            }
        }

        return path;
    }

    /**
     * Performs DFS for the entire graph and returns the DFS forest as a map.
     *
     * @param <V>
     * @param <E>
     * @param graph
     * @return
     */
    public static <V, E> Map<Vertex<V>, Edge<E>> DFSComplete(Graph<V, E> graph) {
        Set<Vertex<V>> known = new HashSet<>();
        Map<Vertex<V>, Edge<E>> forest = new UnsortedTableMap<>();  // TODO: change by ProbeHashMap - cap 10
        for (Vertex<V> u : graph.vertices()) {
            if (!known.contains(u)) {
                DFS(graph, u, known, forest);   // (re)start the DFS process at u
            }
        }

        return forest;
    }

    /**
     * Performs breadth-first search (BFS) of graph starting at Vertex s.
     * 
     * @param <V>
     * @param <E>
     * @param graph
     * @param s
     * @param known
     * @param forest 
     */
    public static <V, E> void BFS(Graph<V, E> graph, Vertex<V> s, Set<Vertex<V>> known, Map<Vertex<V>, Edge<E>> forest) {
        PositionalList<Vertex<V>> level = new LinkedPositionalList<>();

        known.add(s);
        level.addLast(s);                       // first level includes only s

        while (!level.isEmpty()) {
            PositionalList<Vertex<V>> nextLevel = new LinkedPositionalList<>();
            
            for (Vertex<V> u : level) {
                for (Edge e : graph.outgoingEdges(s)) {
                    Vertex<V> v = graph.opposite(s, e);
                    
                    if (!known.contains(v)) {
                        known.add(v);
                        forest.put(v, e);       // e is the tree edge that discovered v
                        nextLevel.addLast(v);
                    }
                }
            }
            
            level = nextLevel;
        }
    }
}
