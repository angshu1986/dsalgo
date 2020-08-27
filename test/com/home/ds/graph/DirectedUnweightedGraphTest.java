package com.home.ds.graph;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.home.ds.adt.UnweightedGraph;

public class DirectedUnweightedGraphTest {
	
	private UnweightedGraph<Integer> graph;

	@Before
	public void setUp() throws Exception {
		graph = new AdjListUnweightedGraph<>(true);
		graph.addVertex(10);
		graph.addEdge(10, 20);
		graph.addEdge(10, 30);
		graph.addEdge(20, 50);
		graph.addEdge(30, 40);
		graph.addEdge(40, 50);
		graph.addEdge(30, 60);
		graph.addEdge(40, 60);
		graph.addEdge(50, 60);
	}

	@Test
	public void testDfs() {
		System.out.println(graph.bfs());
		System.out.println(graph.dfs());
		System.out.println(graph.getAllPath(10, 60));
		System.out.println(graph.hasCycle());
	}

}
