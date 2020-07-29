package com.home.ds.graph;

import com.home.ds.adt.WeightedGraph;

public class UndirectedWeightedGraph<V, E> extends AbstractGraph<V, E> implements WeightedGraph<V, E> {

	public UndirectedWeightedGraph() {
		super(true);
	}
}
