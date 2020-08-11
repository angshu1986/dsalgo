package com.home.ds.graph;

import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.Before;
import org.junit.Test;

import com.home.ds.adt.WeightedGraph;

public class DirectedWeightedGraphTest {
	
	private WeightedGraph<Integer, Integer> graph;

	@Before
	public void setUp() throws Exception {
		graph = new AdjListWeightedGraph<>(false);
		graph.addVertex(10);
		graph.addEdge(10, 20, 5);
		graph.addEdge(10, 30, 3);
		graph.addEdge(20, 50, 4);
		graph.addEdge(30, 40, 1);
		graph.addEdge(40, 50, 6);
		graph.addEdge(30, 60, 2);
		graph.addEdge(40, 60, 4);
		graph.addEdge(50, 60, 1);
	}

	@Test
	public void testDfs() throws IOException {
		System.out.println(graph.bfs());
		System.out.println(graph.dfs());
		System.out.println(graph.getAllPath(10, 60));
		graph.printEdgesPrettyFormat(System.out);
	}

}
