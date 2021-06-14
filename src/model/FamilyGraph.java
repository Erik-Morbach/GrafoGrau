package model;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;



public class FamilyGraph {
	private Person user;
	private List<Node> nodes;
	private Map<Person, Node> personMaper;
	private Map<Node,Integer> userShortcutRelations;
	
	public FamilyGraph(Person user) {
		this.nodes = new ArrayList<Node>();
		personMaper = new TreeMap<Person,Node>();
		userShortcutRelations = new HashMap<Node,Integer>();
	
		this.user = user;
		addNode(this.user);
	}
	
	
	public void addNode(Person relative) {
		Node node = new Node(relative);
		this.nodes.add(node);
		this.personMaper.put(relative, node);
	}
	
	public void addEdge(Person person1, Person person2) {
		addEdge(personMaper.get(person1),personMaper.get(person2));
	}
	public void addEdge(Person person1, Person person2, int degree) {
		addEdge(personMaper.get(person1),personMaper.get(person2), degree);
	}
	public void addEdge(Node node1, Node node2, int degree) {
		Edge edge1 = new Edge(node2, degree);
		Edge edge2 = new Edge(node1, degree);
		
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

	
	public int calculateDegree(Person destiny) {
		Hashtable<Node,Boolean> visitedNodes = new Hashtable<Node,Boolean>(); 
		
		Node userNode = personMaper.get(user);
		
		PriorityQueue<Entry<Integer,Node>> queue = new PriorityQueue<Entry<Integer,Node>>();
		
		
		if(userShortcutRelations.size()==0) 
			queue.add(new SimpleEntry<Integer,Node>(0,userNode));
		else
			for(Entry<Node,Integer> edge: userShortcutRelations.entrySet()) {
				queue.add(new SimpleEntry<Integer,Node>(edge.getValue(),edge.getKey()));
			}	
		
		
		while(!queue.isEmpty()) {
			Entry<Integer,Node> currentPair = queue.peek();
			int currentDegree = currentPair.getKey();
			Node currentNode = currentPair.getValue();
			
			if(visitedNodes.containsKey(currentNode)) continue;
			
			if(userShortcutRelations.containsKey(currentNode)) {
				int degreeSaved = userShortcutRelations.get(currentNode);
				userShortcutRelations.remove(currentNode, degreeSaved);
				degreeSaved = Math.min(degreeSaved, currentDegree);
				userShortcutRelations.put(currentNode, degreeSaved);
			}
			
			visitedNodes.put(currentNode, true);
			
			if(currentNode.getPerson().compareTo(destiny)==0) 
				return currentDegree; 
			
			for(Edge currentEdge: currentNode.getEdges()) {
				if(visitedNodes.containsKey(currentEdge.getDestiny())) continue;
					
				int newDegree = currentDegree + currentEdge.getDegree();
				queue.add(new SimpleEntry<Integer,Node>(newDegree, currentEdge.getDestiny()));
			}
		}
		return -1;
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


	public Map<Person, Node> getPersonMaper() {
		return personMaper;
	}


	public void setPersonMaper(Map<Person, Node> personMaper) {
		this.personMaper = personMaper;
	}


	public Map<Node, Integer> getUserShortcutRelations() {
		return userShortcutRelations;
	}


	public void setUserShortcutRelations(Map<Node, Integer> userShortcutRelations) {
		this.userShortcutRelations = userShortcutRelations;
	}

	
	
}
