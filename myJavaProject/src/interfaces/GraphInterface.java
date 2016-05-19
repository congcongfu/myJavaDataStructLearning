package interfaces;

public interface GraphInterface {

	/**
	 * add vertex
	 * @param char
	 * */
	public void addVertex(char lab);
	
	/**
	 * add edge
	 * @param start to represents the position of of the vertex
	 * @param end to represents the position of of the vertex
	 * */
	public void addEdge(int start, int end);
	
	/**
	 * Displays a vertex
	 * @param index of the position to be display
	 * */
	public void displayVertex(int index);
	
	// returns an unvisited vertex adjacent to v
	public int getAdjUnvisitedVertex(int v);
	
}


























