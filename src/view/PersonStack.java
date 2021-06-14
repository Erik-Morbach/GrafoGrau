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
		if(this.isEmpty()) {
			this.person = person;
			this.last = this; //new PersonStack(person);
			return;
		}
		PersonStack current = this;
		while(true) {
			if(current.next != null) {
				current = current.next;
				continue;
			}
			break;
		}
		this.last = new PersonStack(person);
		current.next = this.last;
		this.last.previous = current;
		
	}
	
	public Person pop() {
		if(this.isEmpty()) return null;
		Person poped = this.last.person;
		this.last = this.last.previous;
		if(this.last!=null) this.last.next = null;
		return poped;
	}
	
	public boolean isStack() {
		return this.last == null;
	}
	
	public boolean isEmpty() {
		return this.person == null;
	}
	
	
	
 }