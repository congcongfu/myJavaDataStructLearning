package impl;


import java.util.Stack;

import model.DistanceParent;
import model.Vertex;

public class DirectedGraph {
	
	private final int MAX_VERTS = 20;
	private final int INFINITY = 100000;
	private Vertex vertexList[];
	private int adjMat[][];
	private int number;
	private int nTree;
	private DistanceParent sPath[];
	private int currentVert;
	private int startToCurrent;
	
	/**
	 * Create a new empty DirectedGraph
	 * */
	public DirectedGraph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		number = 0;
		nTree = 0;
		for(int i = 0; i< MAX_VERTS; i++){
			for (int j = 0; j < MAX_VERTS; j++) {
				adjMat[i][j] = INFINITY;
			}
		}
		sPath = new DistanceParent[MAX_VERTS];
	}
	
	/**
	 * add vertex
	 * @param String
	 * */
	public void addVertex(String lab) {
		vertexList[number++] = new Vertex(lab);
	}

	/**
	 * add edge
	 * @param start to represents the position of of the vertex
	 * @param end to represents the position of of the vertex
	 * */
	public void addEdge(int start, int end, int distance) {
		adjMat[start][end] = distance;                 //directed
	}
	
	/***
	 * transfer row of distances from adjMat to sPath
	 * */
	private void path(){
		
		int startTree = 0;
		vertexList[startTree].wasVisited = true;
		nTree = 1;
		for(int i = 0; i < number; i++){
			int tempDistance = adjMat[startTree][i];
			sPath[i] = new DistanceParent(startTree, tempDistance);
		}
		
		//until all vertices are in the tree;
		while(nTree < number){
			int indexMin = getMin();
			int minDistance = sPath[indexMin].getDistance();
			
			if(minDistance == INFINITY){
				System.out.println("There are unreachable vertics");
				break;
			}else {
				currentVert = indexMin;
				startToCurrent = sPath[indexMin].getDistance();
				//minimum distance from startTree is to currentVert,
				//and is startToCurrent
			}
			vertexList[currentVert].wasVisited = true;
			nTree++;
			adjust_sPath();
		}
		nTree = 0;
		for(int i = 0; i < number; i++){
			vertexList[i].wasVisited = false;
		}
		
	}
	
	/**
	 * Get minimum distance from sPath
	 * @returns minimum distance from sPath
	 * */
	private int getMin() {
		int minDistance = INFINITY;
		int indexMin = 0;
		for(int i = 0; i < number; i++){
			if( !vertexList[i].wasVisited && sPath[i].getDistance() < minDistance){
				minDistance = sPath[i].getDistance();
				indexMin = i;
			}
		}
		return indexMin;
	}
	
	/**
	 * Adjust values in shortest-path array sPath
	 * */
	private void adjust_sPath() {
		int column = 1;
		while (column < number) {
			if(vertexList[column].wasVisited){
				column++;
				continue;
			}
			//calculate distance for one sPath entry
			//get edge from currentVert to column
			int currentToFringe = adjMat[currentVert][column];
			int startToFringe = startToCurrent + currentToFringe;
			int sPathDistance = sPath[column].getDistance();
			
			//compare distance from start with sPath entry
			if(startToFringe < sPathDistance){
				sPath[column].setParentVert(currentVert);
				sPath[column].setDistance(startToFringe);
			}
			column++;
		}
		
	}
	
	/**
	 * Display the Graph
	 * */
	public void displayPaths() {
		path();
		System.out.println();
		for(int i = 0; i < number; i++){
			System.out.println(vertexList[i].getLabel()+"=");
			if(sPath[i].getDistance() == INFINITY)
				System.out.println("inf");
			else
				System.out.println(sPath[i].getDistance());
			String parent = vertexList[sPath[i].getParentVert()].getLabel();
			System.out.println("("+parent+")");
		}
		System.out.println("");
	}

	/**
	 * Returns a string to represents the shortest path to all the other vertxs
	 * @returns String
	 * */
	public String shortestPath(){
		Stack<String> stack = new Stack<>();
		path();
		String result = "{";
		for (int i = 0; i < number; i++) {
			int pa = sPath[i].getParentVert();
			
			while (pa != 0) {
				pa = sPath[pa].getParentVert();
				stack.push(vertexList[pa].getLabel());
			}
			while(!stack.isEmpty()){
				result += "("+stack.pop()+")-->";

			}
			
			String parent = vertexList[sPath[i].getParentVert()].getLabel();
			
			if(i > 0){
				result += "("+parent+")-->";
			}
			result += vertexList[i].getLabel()+"=";
			if(sPath[i].getDistance() == INFINITY)
				result +="inf,";
			else {
				if(i < number-1)
					result += sPath[i].getDistance()+",";
				else 
					result += sPath[i].getDistance();
			}
		}
		
		return result +"}";
	}

	
	
}










































