package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import model.FamilyGraph;
import model.Person;
import view.Menu;

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
/*
erik
18
1
cresimer
50
1
rosa
80
3
1
bruno
80
2
tati
40
2
fransisco
2
3
3
2
bruna
30
3
2
leila
60
2
millena
23
3
2
henrique
14
3
3
3
3
1
boris
50
1
geni
80
3
1
anselmo
80
3
2
arthur
24
3
3
3
 */