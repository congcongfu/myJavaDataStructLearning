package model;

public class Vertex {

	private String label;
	public boolean wasVisited;
	
	public Vertex(String lab){
		this.label = lab;
		wasVisited = false;
	}

	public String getLabel() {
		return label;
	}

	private void setLabel(String label) {
		this.label = label;
	}
}
