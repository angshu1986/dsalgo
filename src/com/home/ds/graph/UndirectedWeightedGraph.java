package com.home.ds.graph;

public class UndirectedWeightedGraph<V, E> extends AbstractGraph<V, E> implements WeightedGraph<V, E> {

	public UndirectedWeightedGraph() {
		super(true);
	}
}
