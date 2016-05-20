package impl;

import interfaces.GraphInterface;
import model.PriorityQueue;
import model.Queue;
import model.StackX;
import model.Vertex;

public class Graph implements GraphInterface {

	private final int MAX_VERTS = 20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int number;
	private char sortedArray[];
	private StackX stack;
	private Queue queue;
	
	private int currentVert;
	private PriorityQueue priorityQueue;
	private int nTree;
	
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
		sortedArray = new char[MAX_VERTS];
		stack = new StackX();
		queue = new Queue();
		priorityQueue = new PriorityQueue();
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
//		adjMat[end][start] = 1;
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
	
	/**
	 * depth first search
	 * */
	public void depthFirst(){
		vertexList[0].wasVisited = true;
		displayVertex(0);
		stack.push(0);
		
		while ( !stack.isEmpty()) {
			
			int x = getAdjUnvisitedVertex(stack.peek());
			System.out.println("peek= "+stack.peek());
			System.out.println("x= "+x);
			if( x == -1)
				stack.pop();
			else {
				vertexList[x].wasVisited = true;
				displayVertex(x);
				stack.push(x);
			}
		}
		//stack is empty so we're done
		for(int i = 0; i < number; i++)
			vertexList[i].wasVisited = false;
	}
	
	/**
	 * Breadth first search
	 * 
	 * */
	public void breadthFirst(){
		vertexList[0].wasVisited = true;
		displayVertex(0);
		queue.insert(0);
		int temp;
		
		while( !queue.isEmpty()){
			int v1 = queue.remove();
			
			while((temp = getAdjUnvisitedVertex(v1)) != -1){
				System.out.println("temp= "+temp);
				vertexList[temp].wasVisited = true;
				displayVertex(temp);
				queue.insert(temp);
			}
		}
		for( int i = 0; i < number; i++)
			vertexList[i].wasVisited = false;
	}
	
	/**
	 * minimum spanning tree (depth first)
	 * */
	public void ninimumSpanTree(){
		vertexList[0].wasVisited = true;
		stack.push(0);
		
		while(!stack.isEmpty()){
			int currrentVertex = stack.peek();
			int temp = getAdjUnvisitedVertex(currrentVertex);
			if(temp == -1)
				stack.pop();
			else {
				vertexList[temp].wasVisited = true;
				stack.push(temp);
				
				displayVertex(currrentVertex);
				displayVertex(temp);
				System.out.println(" ");
			}
		}
		
		for(int i = 0; i < number; i++)
			vertexList[i].wasVisited = false;
	}
	
	/**
	 * topological sort
	 * */
	public void topologicalSort(){
		int orig_number = number;
		while(number >0){
			int currentVertex = noSuccessors();
			if(currentVertex == -1){
				System.err.println("ERROR: Graph has cycle");
				return;
			}
			sortedArray[number -1] = vertexList[currentVertex].getLabel();
			//insert vertex label in sorted array(start)
			deleteVertext(currentVertex);
		}
		System.out.println("Toplogically sorted order: ");
		for(int i = 0; i < orig_number; i++)
			System.out.println(sortedArray[i]);
		System.out.println("");
	}

	

	/**
	 * Returns vert with no successors
	 * (or -1 if no such verts)
	 * */
	private int noSuccessors() {
		boolean isEdge;     //edge from row to column in adjmat
		
		for(int row = 0; row < number; row++){
			isEdge = false;
			for(int column = 0; column < number; column++){
				int data = adjMat[row][column];
				if(data > 0){
					isEdge = true;
					break;
				}
			}
			if(!isEdge)
				return row;
		}
		return -1;
	}

	/**
	 * Delete vert
	 * @param vert to be deleted
	 * */
	private void deleteVertext(int vert) {
		if(vert != number - 1){
			for(int i = vert; i < number-1; i++)
				vertexList[i] = vertexList[i+1];  
			for(int row = vert; row < number -1; row++)
				moveRowUp(row,number);      //delete row from adjMat
			for(int column = vert; column < number -1; column++)
				movecolumnLeft(column, number-1);
		}
		number--;
	}

	/**
	 * delete row from adjMat
	 * */
	private void moveRowUp(int row, int length) {
		for(int columnn = 0; columnn <length; columnn++)
			adjMat[row][columnn] = adjMat[row+1][columnn];
	}
	
	/**
	 * delete column from adjMat
	 * */
	private void movecolumnLeft(int columnn, int length) {
		for(int row = 0; row < length; row++)
			adjMat[row][columnn] = adjMat[row][columnn+1];
	}

}

































