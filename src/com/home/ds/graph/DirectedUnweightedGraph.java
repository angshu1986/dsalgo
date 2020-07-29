package com.home.ds.graph;

import com.home.ds.adt.UnweightedGraph;

public class DirectedUnweightedGraph<V> extends AbstractGraph<V, Void> implements UnweightedGraph<V> {

	public DirectedUnweightedGraph() {
		super(false);
	}
}
