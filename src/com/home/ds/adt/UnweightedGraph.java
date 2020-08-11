package com.home.ds.adt;

import java.util.List;

public interface UnweightedGraph<V> {

	void addVertex(V v);

	void addEdge(V v1, V v2);

	List<List<V>> getAllPath(V start, V end);

	List<V> bfs();

	List<V> dfs();

	String printShortestPath(V start, V end);

	int getShortestPath(V start, V end);

	void removeVertex(V v);

	void removeEdge(V from, V to);
	
	boolean hasCycle();

}
