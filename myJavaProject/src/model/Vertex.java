package model;

public class Vertex {

	private char label;
	public boolean wasVisited;
	
	public Vertex(char lab){
		setLabel(lab);
		wasVisited = false;
	}

	public char getLabel() {
		return label;
	}

	private void setLabel(char label) {
		this.label = label;
	}
}
