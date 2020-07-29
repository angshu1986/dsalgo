package com.home.ds.graph;

import com.home.ds.adt.UnweightedGraph;

public class UndirectedUnweightedGraph<V> extends AbstractGraph<V, Void> implements UnweightedGraph<V> {

	public UndirectedUnweightedGraph() {
		super(true);
	}
}
