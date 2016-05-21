package test;

import impl.WeightedGraph;

public class WeightGraphTest {

	public static void main(String[] args) {
		WeightedGraph weightedGraph = new WeightedGraph();
		weightedGraph.addVertex('A');
		weightedGraph.addVertex('B');
		weightedGraph.addVertex('C');
		weightedGraph.addVertex('D');
		weightedGraph.addVertex('E');
		weightedGraph.addVertex('F');
		
		weightedGraph.addEdge(0, 1, 6);
		weightedGraph.addEdge(0, 3, 4);
		weightedGraph.addEdge(1, 2, 10);
		weightedGraph.addEdge(1, 3, 7);
		weightedGraph.addEdge(1, 4, 7);
		weightedGraph.addEdge(2, 3, 8);
		weightedGraph.addEdge(2, 4, 5);
		weightedGraph.addEdge(2, 5, 6);
		weightedGraph.addEdge(3, 4, 12);
		weightedGraph.addEdge(4, 5, 7);

		System.out.println("Minimum spanning tree: ");
		weightedGraph.mstw();
		System.out.println();

		
	}

}
