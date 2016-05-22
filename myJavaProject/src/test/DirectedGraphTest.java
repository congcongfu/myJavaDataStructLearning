package test;

import impl.DirectedGraph;

public class DirectedGraphTest {

	public static void main(String[] args) {
		DirectedGraph directedGraph = new DirectedGraph();
		directedGraph.addVertex("Quzhou");
		directedGraph.addVertex("HangZhou");
		directedGraph.addVertex("ShangHai");
		directedGraph.addVertex("BeiJing");
		directedGraph.addVertex("DaLian");
		directedGraph.addVertex("Tianjing");
		
		directedGraph.addEdge(0,1,50);
		directedGraph.addEdge(0,3,80);
		directedGraph.addEdge(1,2,60);
		directedGraph.addEdge(1,3,90);
		directedGraph.addEdge(2,4,40);
		directedGraph.addEdge(3,2,20);
		directedGraph.addEdge(3,4,70);
		directedGraph.addEdge(4, 1, 50);
		directedGraph.addEdge(3, 5, 10);
		System.out.println("Shortest paths");
		System.out.println(directedGraph.shortestPath());
	}

}
