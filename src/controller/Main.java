package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import model.FamilyGraph;
import model.Person;
import view.Menu;
import view.PersonStack;

public class Main {
	private static ArrayList<Person> family;
	private static FamilyGraph graph;
	private static Menu menu;
	private static Stack<Person> stack; 
	
	private static void setup() {
		menu = new Menu();
		stack = new Stack<Person>();
		Person user = menu.readUserInfo();
		stack.add(user);
		graph = new FamilyGraph(user);
		family = new ArrayList<Person>();
		family.add(user);
		
	}
	
	private static void loop() {
		Person person = stack.pop();
		int option = menu.readRelativeOption(person.getName());
		if(option == 3) return;
		stack.add(person);
		Person relative = menu.readRelativeInfo();
		family.add(relative);
		graph.addNode(relative);
		graph.addEdge(person, relative);
		stack.add(relative);
	}
	
	private static void search() {
		int index = menu.readRelativeIndexOnFamily(family);
		Person relative = family.get(index);
		int degree = graph.calculateDegree(relative);
		menu.displayDegree(degree);
	}

	public static void main(String[] args) {
			setup();
			while(!stack.isEmpty())
				loop();
			
			while(true)
				search();
	}

}
