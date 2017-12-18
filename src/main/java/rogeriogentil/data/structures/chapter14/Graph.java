/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
//package net.datastructures;
package rogeriogentil.data.structures.chapter14;

/**
 * An interface for a graph structure. A graph can be declared as either directed or undirected.
 * In the case of an undirected graph, methods outgoingEdges and incomingEdges return the same collection,
 * and outDegree and inDegree return the same value.
 *
 * Every vertex stores an element of type V (possibly null).
 * Every edge stores an element of type E (possibly null).
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public interface Graph<V,E> {

  /** Returns the number of vertices of the graph */
  int numVertices();

  /** Returns the number of edges of the graph */
  int numEdges();

  /** Returns the vertices of the graph as an iterable collection */
  Iterable<Vertex<V>> vertices();

  /** Returns the edges of the graph as an iterable collection */
  Iterable<Edge<E>> edges();

  /**
   * Returns the number of edges leaving vertex v.
   * Note that for an undirected graph, this is the same result
   * returned by inDegree
   * @throws IllegalArgumentException if v is not a valid vertex
   */
  int outDegree(Vertex<V> v) throws IllegalArgumentException;

  /**
   * Returns the number of edges for which vertex v is the destination.
   * Note that for an undirected graph, this is the same result
   * returned by outDegree
   * @throws IllegalArgumentException if v is not a valid vertex
   */
  int inDegree(Vertex<V> v) throws IllegalArgumentException;

  /**
   * Returns an iterable collection of edges for which vertex v is the origin.
   * Note that for an undirected graph, this is the same result
   * returned by incomingEdges.
   * @throws IllegalArgumentException if v is not a valid vertex
   */
  Iterable<Edge<E>> outgoingEdges(Vertex<V> v) throws IllegalArgumentException;

  /**
   * Returns an iterable collection of edges for which vertex v is the destination.
   * Note that for an undirected graph, this is the same result
   * returned by outgoingEdges.
   * @throws IllegalArgumentException if v is not a valid vertex
   */
  Iterable<Edge<E>> incomingEdges(Vertex<V> v) throws IllegalArgumentException;

  /** Returns the edge from u to v, or null if they are not adjacent. */
  Edge<E> getEdge(Vertex<V> u, Vertex<V> v) throws IllegalArgumentException;

  /**
   * Returns the vertices of edge e as an array of length two.
   * If the graph is directed, the first vertex is the origin, and
   * the second is the destination.  If the graph is undirected, the
   * order is arbitrary.
   */
  Vertex<V>[] endVertices(Edge<E> e) throws IllegalArgumentException;

  /** Returns the vertex that is opposite vertex v on edge e. */
  Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws IllegalArgumentException;

  /** Inserts and returns a new vertex with the given element. */
  Vertex<V> insertVertex(V element);

  /**
   * Inserts and returns a new edge between vertices u and v, storing given element.
   *
   * @throws IllegalArgumentException if u or v are invalid vertices, or if an edge already exists between u and v.
   */
  Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E element) throws IllegalArgumentException;

  /** Removes a vertex and all its incident edges from the graph. */
  void removeVertex(Vertex<V> v) throws IllegalArgumentException;

  /** Removes an edge from the graph. */
  void removeEdge(Edge<E> e) throws IllegalArgumentException;
}
