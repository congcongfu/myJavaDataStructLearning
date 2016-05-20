package model;

/**
 * Edge 
 * @author cong.fu @2016/05/20
 * */
public class Edge {
	public int startVert;
	public int endVert;
	public int distance;
	
	/**
	 * Create a new Edge
	 * @param sv index of a vertex starting edge
	 * @param dv index of a vertex ending edge
	 * @param  d distance from src to dest
	 * */
	public Edge(int sv, int dv, int d){
		this.startVert = sv;
		this.endVert = dv;
		this.distance = d;
	}
}
