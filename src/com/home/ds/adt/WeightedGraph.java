package com.home.ds.adt;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public interface WeightedGraph<V extends Comparable<V>, E extends Number> {

	void addVertex(V v);

	void addEdge(V v1, V v2, E wt);

	void setEdge(V v1, V v2, E wt);

	List<List<V>> getAllPath(V start, V end);

	List<V> bfs();

	List<V> dfs();

	String printShortestPath(V start, V end);

	E getShortestPath(V start, V end);

	void removeVertex(V v);

	void removeEdge(V from, V to);
	
	void printEdgesPrettyFormat(OutputStream out) throws IOException;
	
	boolean hasCycle();
}
