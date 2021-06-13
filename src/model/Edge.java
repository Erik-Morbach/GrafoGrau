package model;

public class Edge {
	private int degree;
	private Node destiny;
	
	public Edge() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Edge(int degree, Node destiny) {
		super();
		this.degree = degree;
		this.destiny = destiny;
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	public Node getDestiny() {
		return destiny;
	}
	public void setDestiny(Node destiny) {
		this.destiny = destiny;
	}

	
	
}
