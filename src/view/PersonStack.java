package view;

import model.Person;

public class PersonStack {
	private PersonStack previous;
	private PersonStack next;
	private PersonStack last;
	private Person person;
	
	public PersonStack() {
		this.next = null;
		this.last = null;
		this.previous = null;
		this.person = null;
	}
	
	public PersonStack(Person person) {
		this.next = null;
		this.last = null;
		this.previous = null;
		this.person = person;
	}
	
	public PersonStack(Person person, PersonStack previous) {
		this.next = null;
		this.last = null;
		this.previous = previous;
		this.person = person;
	}
	
	public void add(Person person) {
		this.last = new PersonStack(person);
		PersonStack stack = this;
		while(true) {
			if(stack.next != null) {
				stack = stack.next;
				continue;
			}
			break;
		}
		this.person = person;
		stack.next = this.last;
		
	}
	
	public Person pop() {
		if(this.isEmpty()) return null;
		Person poped = this.last.person;
		this.last = this.last.previous;
		return poped;
	}
	
	public boolean isStack() {
		return this.last == null;
	}
	
	public boolean isEmpty() {
		return this.person == null;
	}
	
	
	
 }