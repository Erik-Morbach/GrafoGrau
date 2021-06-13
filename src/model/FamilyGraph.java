package model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class FamilyGraph {
	private Person user;
	private List<Node> nodes;
	private TreeMap<Person, Node> treeMap;
	
	public FamilyGraph(Person user) {
		this.user = user;
		this.nodes = new ArrayList<Node>();
	}
	
	public void addNode(Person relative) {
		Node node = new Node(relative);
		this.nodes.add(node);
		this.treeMap.put(relative, node);
	}
	
	public void addEdge(Node node1, Node node2, int grade) {
		Edge edge1 = new Edge(node2, grade);
		Edge edge2 = new Edge(node1, grade);
		
		List<Edge> edgesNode1 = node1.getEdges();
		edgesNode1.add(edge1);
		node1.setEdges(edgesNode1);
		
		List<Edge> edgesNode2 = node2.getEdges();
		edgesNode2.add(edge2);
		node2.setEdges(edgesNode2);
	}
	
	public void addEdge(Node node1, Node node2) {
		this.addEdge(node1, node2, 1);
	}

	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public TreeMap<Person, Node> getTreeMap() {
		return treeMap;
	}

	public void setTreeMap(TreeMap<Person, Node> treeMap) {
		this.treeMap = treeMap;
	}
	
}
