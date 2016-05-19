package impl;

import interfaces.GraphInterface;
import model.Vertex;

public class Graph implements GraphInterface {

	private final int MAX_VERTS = 20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int number;
	
	/**
	 * Create a new Graph all element is 0
	 * */
	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		number = 0;
		for(int i = 0; i < MAX_VERTS; i++){
			for(int k = 0; k < MAX_VERTS; k++){
				adjMat[i][k] = 0;
			}
		}
	}
	
	/**
	 * add vertex
	 * @param char
	 * */
	@Override
	public void addVertex(char lab) {
		vertexList[number++] = new Vertex(lab);
	}

	/**
	 * add edge
	 * @param start to represents the position of of the vertex
	 * @param end to represents the position of of the vertex
	 * */
	@Override
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	/**
	 * Displays a vertex
	 * @param index of the position to be display
	 * */
	@Override
	public void displayVertex(int index) {
		System.out.println(vertexList[index].getLabel());
	}

	@Override
	public int getAdjUnvisitedVertex(int v) {
		for(int i = 0; i < number; i++)
			if(adjMat[v][i] == 1 && vertexList[i].wasVisited == false)
				return i;                  //return first such vertex
		return -1;							//no such vertices
	}

}

































