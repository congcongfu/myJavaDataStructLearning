package impl;

import model.Edge;
import model.PriorityQueue;
import model.Queue;
import model.StackX;
import model.Vertex;

public class WeightedGraph {
	private final int MAX_VERTS = 20;
	private final int INFINITY = 1000000;
	private Vertex vertexList[];
	private int adjMat[][];
	private int number;
	
	private int currentVert;
	private PriorityQueue priorityQueue;
	private int nTree;
	
	/**
	 * Create a new Graph all element is 0
	 * */
	public WeightedGraph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		number = 0;
		for(int i = 0; i < MAX_VERTS; i++){
			for(int k = 0; k < MAX_VERTS; k++){
				adjMat[i][k] = 0;
			}
		}
		priorityQueue = new PriorityQueue();
	}
	
	/**
	 * add vertex
	 * @param char
	 * */
	public void addVertex(char lab) {
		vertexList[number++] = new Vertex(lab);
	}

	/**
	 * add edge
	 * @param start to represents the position of of the vertex
	 * @param end to represents the position of of the vertex
	 * */
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	/**
	 * Displays a vertex
	 * @param index of the position to be display
	 * */
	public void displayVertex(int index) {
		System.out.println(vertexList[index].getLabel());
	}

	public int getAdjUnvisitedVertex(int v) {
		for(int i = 0; i < number; i++)
			if(adjMat[v][i] == 1 && vertexList[i].wasVisited == false)
				return i;                  //return first such vertex
		return -1;							//no such vertices
	}
	
	/**
	 * 
	 * */
	public void mstw(){
		currentVert = 0;
		while (nTree < number-1) {
			vertexList[currentVert].wasVisited = true;
			nTree++;
			
			for(int i = 0; i < number; i++){
				if(i == currentVert)
					continue;
				if(vertexList[i].wasVisited)
					continue;
				int distance = adjMat[currentVert][i];
				if(distance == INFINITY)
					continue;
				putInPQ(i, distance);
			}
			if(priorityQueue.isEmpty()){
				System.out.println("GRAPH NOT CONNECTED");
				return;
			}
			Edge thEdge = priorityQueue.removeMin();
			int sourceVert = thEdge.startVert;
			currentVert = thEdge.endVert;
			
			System.out.println(vertexList[sourceVert].getLabel());
			System.out.println(vertexList[currentVert].getLabel());
			System.out.println(" ");
		}
		for(int i = 0; i < number; i++)
			vertexList[i].wasVisited = false;
	}

	private void putInPQ(int vert, int distance) {

		int queueIndex = priorityQueue.find(vert);
		if(queueIndex != -1){
			Edge tempEdge = priorityQueue.peek(queueIndex);
			int oldDis = tempEdge.distance;
			if(oldDis > distance){
				priorityQueue.remove(queueIndex);
				Edge edge = new Edge(currentVert, vert, distance);
				priorityQueue.insert(edge);
			}
		}else {
			Edge edge = new Edge(currentVert, vert, distance);
			priorityQueue.insert(edge);
		}
	}
	
	
}


























