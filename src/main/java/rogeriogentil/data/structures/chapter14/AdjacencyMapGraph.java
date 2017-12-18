package rogeriogentil.data.structures.chapter14;

import rogeriogentil.data.structures.chapter07.LinkedPositionalList;
import rogeriogentil.data.structures.chapter07.Position;
import rogeriogentil.data.structures.chapter07.PositionalList;
import rogeriogentil.data.structures.chapter10.Map;
import rogeriogentil.data.structures.chapter10.UnsortedTableMap;

/**
 *
 * @author Rogerio J. Gentil
 * @param <V> Vertex
 * @param <E> Edge
 */
public class AdjacencyMapGraph<V, E> implements Graph<V, E> {

    /**
     * A vertex of an adjacency map graph representation.
     *
     * @param <V>
     */
    private class InnerVertex<V> implements Vertex<V> {

        private V element;
        private Position<Vertex<V>> position;
        private Map<Vertex<V>, Edge<E>> outgoing, incoming;

        /**
         * Constructs a new InnerVertex instance storing the given element.
         *
         * @param element
         * @param graphIsDirected
         */
        public InnerVertex(V element, boolean graphIsDirected) {
            this.element = element;
            outgoing = new UnsortedTableMap<>();

            if (graphIsDirected) {
                incoming = new UnsortedTableMap<>();
            } else {
                incoming = outgoing;        // if undirected, alias outgoing map
            }
        }

        @Override
        public V getElement() {
            return this.element;
        }

        public void setPosition(Position<Vertex<V>> position) {
            this.position = position;
        }

        public Position<Vertex<V>> getPosition() {
            return this.position;
        }

        /**
         * Returns reference to the underlying map of outgoing edges.
         *
         * @return
         */
        public Map<Vertex<V>, Edge<E>> getOutgoing() {
            return this.outgoing;
        }

        /**
         * Returns reference to the underlying map of incoming edges.
         *
         * @return
         */
        public Map<Vertex<V>, Edge<E>> getIncoming() {
            return this.incoming;
        }

        /**
         * Validates that this edge instance belongs to the given graph.
         */
        public boolean validate(Graph<V, E> graph) {
            return AdjacencyMapGraph.this == graph && position != null;
        }
    } //------------ end of InnerVertex class ------------

    private class InnerEdge<E> implements Edge<E> {

        private E element;
        private Position<Edge<E>> position;
        private Vertex<V>[] endpoints;

        /**
         * Constructs InnerEdge instance from u to v, storing the given element.
         *
         * @param u
         * @param v
         * @param element
         */
        public InnerEdge(Vertex<V> u, Vertex<V> v, E element) {
            this.element = element;
            endpoints = (Vertex<V>[]) new Vertex[]{u, v};   // array of length 2
        }

        @Override
        public E getElement() {
            return this.element;
        }

        public Vertex<V>[] getEndPoints() {
            return this.endpoints;
        }

        public void setPosition(Position<Edge<E>> position) {
            this.position = position;
        }

        public Position<Edge<E>> getPosition() {
            return this.position;
        }

        /**
         * Validates that this edge instance belongs to the given graph.
         */
        public boolean validate(Graph<V, E> graph) {
            return AdjacencyMapGraph.this == graph && position != null;
        }
    } //------------ end of InnerEdge class ------------

    private boolean isDirected;
    private PositionalList<Vertex<V>> vertices = new LinkedPositionalList<>();
    private PositionalList<Edge<E>> edges = new LinkedPositionalList<>();

    /**
     * Constructs an empty graph (either undirected or directed).
     *
     * @param isDirected
     */
    public AdjacencyMapGraph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    @Override
    public int numVertices() {
        return vertices.size();
    }

    @Override
    public int numEdges() {
        return edges.size();
    }

    @Override
    public Iterable<Vertex<V>> vertices() {
        return vertices;
    }

    @Override
    public Iterable<Edge<E>> edges() {
        return edges;
    }

    @Override
    public int outDegree(Vertex<V> vertex) throws IllegalArgumentException {
        InnerVertex<V> vert = validate(vertex);
        return vert.getOutgoing().size();
    }

    @Override
    public int inDegree(Vertex<V> vertex) throws IllegalArgumentException {
        InnerVertex<V> vert = validate(vertex);
        return vert.getIncoming().size();
    }

    @Override
    public Iterable<Edge<E>> outgoingEdges(Vertex<V> vertex) throws IllegalArgumentException {
        InnerVertex<V> vert = validate(vertex);
        return vert.getOutgoing().values();     // edges are the values in the adjacency map
    }

    @Override
    public Iterable<Edge<E>> incomingEdges(Vertex<V> vertex) throws IllegalArgumentException {
        InnerVertex<V> vert = validate(vertex);
        return vert.getIncoming().values();     // edges are the values in the adjacency map
    }

    @Override
    public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) throws IllegalArgumentException {
        InnerVertex<V> origin = validate(u);
        InnerVertex<V> dest = validate(v);
        return origin.getOutgoing().get(dest);  // will be null if no edge from u to v
    }

    @Override
    public Vertex<V>[] endVertices(Edge<E> edge) throws IllegalArgumentException {
        InnerEdge<E> e = validate(edge);
        return e.getEndPoints();
    }

    /**
     * Returns the vertex that is opposite vertex v on edge e.
     *
     * @param vertex
     * @param edge
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Vertex<V> opposite(Vertex<V> vertex, Edge<E> edge) throws IllegalArgumentException {
        validate(vertex);
        InnerEdge<E> e = validate(edge);

        Vertex<V>[] endpoints = e.getEndPoints();
        if (endpoints[0] == vertex) {
            return endpoints[1];
        } else if (endpoints[1] == vertex) {
            return endpoints[0];
        } else {
            throw new IllegalArgumentException("v is not incident to this edge");
        }
    }

    @Override
    public Vertex<V> insertVertex(V element) {
        InnerVertex<V> v = new InnerVertex<>(element, isDirected);
        Position<Vertex<V>> position = vertices.addLast(v);
        v.setPosition(position);
        return v;
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E element) throws IllegalArgumentException {
        if (getEdge(u, v) == null) {
            InnerEdge<E> e = new InnerEdge<>(u, v, element);
            Position<Edge<E>> position = edges.addLast(e);
            e.setPosition(position);
            InnerVertex<V> origin = validate(u);
            InnerVertex<V> dest = validate(v);
            origin.getOutgoing().put(u, e);
            origin.getIncoming().put(u, e);
            return e;
        } else {
            throw new IllegalArgumentException("Edge from u to v exists");
        }
    }

    @Override
    public void removeVertex(Vertex<V> vertex) throws IllegalArgumentException {
        InnerVertex<V> v = validate(vertex);

        // remove all incident edges from the graph
        for (Edge<E> e : v.getOutgoing().values()) {
            removeEdge(e);
        }

        for (Edge<E> e : v.getIncoming().values()) {
            removeEdge(e);
        }

        vertices.remove(v.getPosition());
    }

    @Override
    public void removeEdge(Edge<E> e) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings({"unchecked"})
    private InnerVertex<V> validate(Vertex<V> v) {
        if (!(v instanceof InnerVertex)) {
            throw new IllegalArgumentException("Invalid vertex");
        }
        InnerVertex<V> vert = (InnerVertex<V>) v;     // safe cast
        if (!vert.validate(this)) {
            throw new IllegalArgumentException("Invalid vertex");
        }
        return vert;
    }

    @SuppressWarnings({"unchecked"})
    private InnerEdge<E> validate(Edge<E> e) {
        if (!(e instanceof InnerEdge)) {
            throw new IllegalArgumentException("Invalid edge");
        }
        InnerEdge<E> edge = (InnerEdge<E>) e;     // safe cast
        if (!edge.validate(this)) {
            throw new IllegalArgumentException("Invalid edge");
        }
        return edge;
    }
}
