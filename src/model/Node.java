package model;

import java.util.List;

public class Node{
	private List<Edge> edges;
	private Person person;
	public Node(List<Edge> edges, Person person) {
		super();
		this.edges = edges;
		this.person = person;
	}
	public Node(Person person) {
		super();
		this.person = person;
	}
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Edge> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
