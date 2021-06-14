package model;

import java.util.ArrayList;
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
		this.edges = new ArrayList<Edge>();
	}
	public Node() {
		super();
		this.edges = new ArrayList<Edge>();
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
