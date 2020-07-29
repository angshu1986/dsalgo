package com.home.ds.graph;

import com.home.ds.adt.WeightedGraph;

public class DirectedWeightedGraph<V, E> extends AbstractGraph<V, E> implements WeightedGraph<V, E> {

	public DirectedWeightedGraph() {
		super(false);
	}
}
