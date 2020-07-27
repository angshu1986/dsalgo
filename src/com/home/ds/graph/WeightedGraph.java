package com.home.ds.graph;

public interface WeightedGraph<V, E> {

	void addVertex(V v);
	void addEdge(V v1, V v2, E e);
}
