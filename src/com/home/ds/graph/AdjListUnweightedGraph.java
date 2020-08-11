package com.home.ds.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.home.ds.adt.IQueue;
import com.home.ds.adt.IStack;
import com.home.ds.adt.UnweightedGraph;
import com.home.ds.linear.Queue;
import com.home.ds.linear.Stack;

public class AdjListUnweightedGraph<V> implements UnweightedGraph<V> {

	private boolean isBidirectional;

	private int count;

	private Map<V, List<V>> vertices;

	protected AdjListUnweightedGraph(boolean isBidirectional) {
		this.isBidirectional = isBidirectional;
		this.vertices = new LinkedHashMap<>();
	}

	@Override
	public void addVertex(V v) {
		vertices.putIfAbsent(v, new ArrayList<>());
		count++;
	}

	@Override
	public void addEdge(V v1, V v2) {
		if (!vertices.containsKey(v1))
			count++;
		if (!vertices.containsKey(v2))
			count++;
		vertices.putIfAbsent(v1, new ArrayList<>());
		vertices.putIfAbsent(v2, new ArrayList<>());
		vertices.get(v1).add(v2);
		if (isBidirectional) {
			vertices.get(v2).add(v1);
		}
	}

	@Override
	public List<List<V>> getAllPath(V start, V end) {
		List<List<V>> list = new ArrayList<>();
		Set<V> visited = new HashSet<>(count);
		List<V> curr = new ArrayList<>();
		curr.add(start);
		getAllPath(start, end, visited, list, curr);
		return list;
	}

	private void getAllPath(V start, V end, Set<V> visited, List<List<V>> list, List<V> curr) {
		visited.add(start);
		if (start.equals(end)) {
			list.add(new ArrayList<>(curr));
			visited.remove(start);
			return;
		}
		Iterator<V> adj = vertices.get(start).iterator();
		while (adj.hasNext()) {
			V next = adj.next();
			curr.add(next);
			if (!visited.contains(next)) {
				getAllPath(next, end, visited, list, curr);
			}
			curr.remove(curr.size() - 1);
		}
		visited.remove(start);
	}

	@Override
	public List<V> bfs() {
		List<V> list = new ArrayList<>();
		if (count == 0)
			return list;
		V start = vertices.entrySet().iterator().next().getKey();
		IQueue<V> q = new Queue<>();
		Set<V> visited = new HashSet<>(count);
		q.offer(start);
		visited.add(start);
		while (!q.isEmpty()) {
			V polled = q.poll();
			list.add(polled);
			Iterator<V> adj = vertices.get(polled).iterator();
			while (adj.hasNext()) {
				V next = adj.next();
				if (!visited.contains(next)) {
					visited.add(next);
					q.offer(next);
				}
			}
		}
		return list;
	}

	@Override
	public List<V> dfs() {
		List<V> list = new ArrayList<>();
		if (count == 0)
			return list;
		V start = vertices.entrySet().iterator().next().getKey();
		IStack<V> stack = new Stack<>();
		Set<V> visited = new HashSet<>(count);
		stack.push(start);
		while (!stack.isEmpty()) {
			V popped = stack.pop();
			list.add(popped);
			visited.add(popped);
			Iterator<V> adj = vertices.get(popped).iterator();
			while (adj.hasNext()) {
				V next = adj.next();
				if (!visited.contains(next)) {
					stack.push(next);
				}
			}
		}
		return list;
	}

	@Override
	public String printShortestPath(V start, V end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getShortestPath(V start, V end) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeVertex(V v) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeEdge(V from, V to) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasCycle() {
		if (isBidirectional)
			return true;
		return false;
	}
}
