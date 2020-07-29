package com.home.ds.adt;

public interface WeightedGraph<V, E> {

	void addVertex(V v);
	void addEdge(V v1, V v2, E e);
}
