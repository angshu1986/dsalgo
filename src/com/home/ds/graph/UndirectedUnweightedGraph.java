package com.home.ds.graph;

public class UndirectedUnweightedGraph<V> extends AbstractGraph<V, Void> implements UnweightedGraph<V> {

	public UndirectedUnweightedGraph() {
		super(true);
	}
}
