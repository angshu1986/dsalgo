package com.home.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
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
		if (vertices.containsKey(v)) {
			return;
		}
		vertices.put(v, new ArrayList<>());
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
		// TODO use Dijkastra for undirected, topological sort for directed acyclic
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
		if (count == 0)
			return false;
		if (isBidirectional)
			return hasCycleUnionFind();
		IStack<V> stack = new Stack<>();
		Set<V> visited = new HashSet<>(count);
		Set<V> inPath = new HashSet<>(count);
		for (V start : vertices.keySet()) {
			stack.push(start);
			inPath.add(start);
			while (!stack.isEmpty()) {
				V popped = stack.pop();
				visited.add(popped);
				Iterator<V> adj = vertices.get(popped).iterator();
				while (adj.hasNext()) {
					V next = adj.next();
					if (inPath.contains(next)) {
						return true;
					}
					if (!visited.contains(next)) {
						stack.push(next);
					}
				}
			}
			inPath.remove(start);
			visited.clear();
		}
		return false;
	}

	private boolean hasCycleUnionFind() {
		Map<V, V> parent = new HashMap<>(vertices.size());

		// populate parent as all vertices pointing to itself first
		for (V vertex : vertices.keySet()) {
			parent.put(vertex, vertex);
		}

		class Pair {
			V u;
			V v;
			
			Pair(V u, V v) {
				this.u = u;
				this.v = v;
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((u == null) ? 0 : u.hashCode());
				result = prime * result + ((v == null) ? 0 : v.hashCode());
				return result;
			}

			@SuppressWarnings("unchecked")
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Pair other = (Pair) obj;
				if ((other.u.equals(u) && other.v.equals(v)) || (other.u.equals(v) && other.v.equals(u))) {
					return true;
				}
				return false;
			}
		}

		// TODO: need to think of a better way to handle pair
		List<Pair> pairs = new ArrayList<>();
		for (V vertex : vertices.keySet()) {
			for (V adj : vertices.get(vertex)) {
				Pair pair = new Pair(vertex, adj);
				if (pairs.contains(pair)) {
					continue;
				}
				pairs.add(pair);
				V u = find(parent, vertex);
				V v = find(parent, adj);
				if (u.equals(v)) {
					return true;
				} else {
					union(parent, u, v);
				}
			}
		}

		return false;
	}

	private void union(Map<V, V> parent, V v1, V v2) {
		V findX = find(parent, v1);
		V findY = find(parent, v2);
		parent.put(findX, findY);
	}

	private V find(Map<V, V> parent, V v) {
		if (parent.get(v).equals(v)) {
			return parent.get(v);
		}
		return find(parent, parent.get(v));
	}

}
