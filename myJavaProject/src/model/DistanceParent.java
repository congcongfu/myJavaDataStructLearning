package model;

public class DistanceParent {
	private int distance;
	private int parentVert;
	
	/**
	 *Create a new  DistanceParent
	 *@param parentVert of the parentVert
	 *@param DistanceParent of the distance
	 * */
	public DistanceParent(int parentVert,int distance) {
		this.distance = distance;
		this.parentVert = parentVert;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getParentVert() {
		return parentVert;
	}

	public void setParentVert(int parentVert) {
		this.parentVert = parentVert;
	}
	
}
