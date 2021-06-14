package model;

public class Person implements Comparable<Person>{
	private boolean isUser = false;
	private String name;
	private int age;
	
	public Person(boolean isUser) {
		this.isUser = isUser;
	}
	public Person() {
	}
	@Override
	public int compareTo(Person person) {
		return this.name.compareTo(person.getName());
	}
	@Override
	public String toString() {
		return String.format("PARENTE\nnome=$s\nidade=%d",this.name, this.age);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isUser() {
		return isUser;
	}
	
}
