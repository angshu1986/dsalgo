package com.home.ds.graph;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.home.ds.adt.IQueue;
import com.home.ds.adt.IStack;
import com.home.ds.adt.WeightedGraph;
import com.home.ds.linear.Queue;
import com.home.ds.linear.Stack;

public class AdjListWeightedGraph<V extends Comparable<V>, E extends Number> implements WeightedGraph<V, E> {

	private boolean isBidirectional;

	private int count;

	private static class Edge<V extends Comparable<V>, E extends Number> {
		private V v1;
		private V v2;
		private E wt;

		private Edge(V v1, V v2, E wt) {
			this.v1 = v1;
			this.v2 = v2;
			this.wt = wt;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((v1 == null) ? 0 : v1.hashCode());
			result = prime * result + ((v2 == null) ? 0 : v2.hashCode());
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
			Edge<V, E> other = (Edge<V, E>) obj;
			if (this.v1.compareTo(other.v1) == 0 && this.v2.compareTo(other.v2) == 0)
				return true;
			return false;
		}

		@Override
		public String toString() {
			return "Edge [v1=" + v1 + ", v2=" + v2 + ", wt=" + wt + "]";
		}
	}

	private Set<V> vertices;
	private Set<Edge<V, E>> edges;

	public AdjListWeightedGraph(boolean isBidirectional) {
		this.isBidirectional = isBidirectional;
		this.vertices = new LinkedHashSet<>();
		this.edges = new LinkedHashSet<>();
	}

	@Override
	public void addVertex(V v) {
		if (v == null)
			throw new IllegalArgumentException("null vertex");
		if (!vertices.contains(v)) {
			vertices.add(v);
			count++;
		}
	}

	@Override
	public void addEdge(V v1, V v2, E wt) {
		addEdge(v1, v2, wt, false);
	}

	private void addEdge(V v1, V v2, E wt, boolean replace) {
		if (wt == null)
			throw new IllegalArgumentException("null edge");
		addVertex(v1);
		addVertex(v2);
		Edge<V, E> newEdge = new Edge<>(v1, v2, wt);
		if (edges.contains(newEdge) && !replace) {
			return;
		}
		edges.add(newEdge);
		if (isBidirectional) {
			Edge<V, E> reverseEdge = new Edge<>(v2, v1, wt);
			if (edges.contains(reverseEdge) && !replace) {
				return;
			}
			edges.add(reverseEdge);
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
		for (Iterator<Edge<V, E>> itr = edges.iterator(); itr.hasNext();) {
			Edge<V, E> next = itr.next();
			if (next.v1.compareTo(start) == 0) {
				if (!visited.contains(next.v2)) {
					curr.add(next.v2);
					getAllPath(next.v2, end, visited, list, curr);
					curr.remove(curr.size() - 1);
				}
			}
		}
		visited.remove(start);
	}

	@Override
	public List<V> bfs() {
		List<V> list = new ArrayList<>();
		if (count == 0)
			return list;
		Set<V> visited = new HashSet<>();
		IQueue<V> q = new Queue<>();
		V first = vertices.iterator().next();
		q.offer(first);
		visited.add(first);
		while (!q.isEmpty()) {
			V polled = q.poll();
			list.add(polled);
			for (Iterator<Edge<V, E>> itr = edges.iterator(); itr.hasNext();) {
				Edge<V, E> next = itr.next();
				if (next.v1.equals(polled)) {
					if (!visited.contains(next.v2)) {
						q.offer(next.v2);
						visited.add(next.v2);
					}
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
		Set<V> visited = new HashSet<>();
		IStack<V> stack = new Stack<>();
		V first = vertices.iterator().next();
		stack.push(first);
		while (!stack.isEmpty()) {
			V popped = stack.pop();
			list.add(popped);
			visited.add(popped);
			for (Iterator<Edge<V, E>> itr = edges.iterator(); itr.hasNext();) {
				Edge<V, E> next = itr.next();
				if (next.v1.equals(popped)) {
					if (!visited.contains(next.v2)) {
						stack.push(next.v2);
					}
				}
			}
		}
		return list;
	}

	@Override
	public void setEdge(V v1, V v2, E wt) {
		addEdge(v1, v2, wt, true);
	}

	@Override
	public String printShortestPath(V start, V end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getShortestPath(V start, V end) {
		// TODO use Bellman Ford
		return null;
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
	public void printEdgesPrettyFormat(OutputStream out) throws IOException {
		int size = edges.size();
		if (size == 0)
			return;
		StringBuilder sb = new StringBuilder();
		int index = 0;
		for (Edge<V, E> edge : edges) {
			sb.append(edge.v1);
			sb.append("---").append(edge.wt).append("--->").append(edge.v2);
			if (++index < size)
				sb.append("\n");
		}
		out.write(sb.toString().getBytes());
		out.write("\n".getBytes());
	}

	@Override
	public boolean hasCycle() {
		if (isBidirectional)
			return hasCycleUnionFind();
		return false; // TODO: use cycle in a directed graph using DFS
	}

	private boolean hasCycleUnionFind() {
		Map<V, V> parent = new HashMap<>(vertices.size());
		Map<V, Integer> rank = new HashMap<>(vertices.size());

		// populate parent as all vertices pointing to itself first
		for (V vertex : vertices) {
			parent.put(vertex, vertex);
			rank.put(vertex, 0);
		}

		class Pair {
			V u;
			V v;
			E wt;

			Pair(V u, V v, E wt) {
				this.u = u;
				this.v = v;
				this.wt = wt;
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((u == null) ? 0 : u.hashCode());
				result = prime * result + ((v == null) ? 0 : v.hashCode());
				result = prime * result + ((wt == null) ? 0 : wt.hashCode());
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
				if (other.wt.equals(wt) && (other.u.equals(u) && other.v.equals(v))
						|| (other.u.equals(v) && other.v.equals(u))) {
					return true;
				}
				return false;
			}
		}

		// TODO: need to think of a better way to handle pair
		List<Pair> pairs = new ArrayList<>();
		for (Edge<V, E> edge : edges) {
			V src = edge.v1;
			V dest = edge.v2;
			Pair pair = new Pair(src, dest, edge.wt);
			if (pairs.contains(pair)) {
				continue;
			}
			pairs.add(pair);
			V u = find(parent, src);
			V v = find(parent, dest);
			if (u.equals(v)) {
				return true;
			} else {
				union(parent, rank, u, v);
			}
		}
		return false;
	}

	private void union(Map<V, V> parent, Map<V, Integer> rank, V v1, V v2) {
		V findX = find(parent, v1);
		V findY = find(parent, v2);
		if (!findX.equals(findY)) {
			int rankX = rank.get(findX);
			int rankY = rank.get(findY);
			if (rankX > rankY) {
				parent.put(findY, findX);
			} else {
				parent.put(findX, findY);
				if (rankX == rankY) {
					rank.put(findY, rank.get(findY) + 1);
				}
			}
		}
	}

	private V find(Map<V, V> parent, V v) {
		if (!parent.get(v).equals(v)) {
			// compress
			parent.put(v, find(parent, parent.get(v)));
		}
		return parent.get(v);
	}
}
