package model;

public class Person implements Comparable<Person>{
	private String name;
	@Override
	public int compareTo(Person person) {
		return this.name.compareTo(person.getName());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
