package com.home.ds.graph;

import java.util.HashMap;
import java.util.Map;

import com.home.ds.adt.List;
import com.home.ds.adt.UnweightedGraph;
import com.home.ds.adt.WeightedGraph;
import com.home.ds.linear.ArrayList;

public abstract class AbstractGraph<V, E> implements UnweightedGraph<V>, WeightedGraph<V, E> {

	private boolean isBidirectional;

	private Map<V, List<V>> vertices;

	private static class Edge<V, E> {
		private V v1;
		private V v2;
		private E wt;

		private Edge(V from, V to, E wt) {
			this.v1 = from;
			this.v2 = to;
			this.wt = wt;
		}
	}

	private List<Edge<V, E>> edges;

	protected AbstractGraph(boolean isBidirectional) {
		this.isBidirectional = isBidirectional;
		this.vertices = new HashMap<>();
		this.edges = new ArrayList<>();
	}

	@Override
	public void addVertex(V v) {
		vertices.putIfAbsent(v, new ArrayList<>());

	}

	@Override
	public void addEdge(V v1, V v2) {
		addEdge(v1, v2, null);
	}

	@Override
	public void addEdge(V v1, V v2, E e) {
		vertices.putIfAbsent(v1, new ArrayList<>());
		vertices.putIfAbsent(v2, new ArrayList<>());
		vertices.get(v1).add(v2);
		Edge<V, E> edge = new Edge<V, E>(v1, v2, e);
		edges.add(edge);
		if (isBidirectional) {
			Edge<V, E> edge2 = new Edge<V, E>(v2, v1, e);
			vertices.get(v2).add(v1);
			edges.add(edge2);
		}
	}

}
