package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Person;

public class Menu {
	private Scanner scanner = new Scanner(System.in);
	private final String erroMsg = "Por favor insira um valor válido";
	
	public Menu() {
		System.out.print("Bem vindo ao GrafoGrau, uma aplicação para medir grau de parentesco entre você e seus parentes!!\n\n");
	}
	
	public void displayDegree(int degree) {
		if(degree < 0)
			System.out.print("Algo de ruim aconteceu :c");
		System.out.printf("Parente de %d° Grau", degree);
	}
	
	public int readRelativeIndexOnFamily(ArrayList<Person> family) {
		int option = 0;
		while(true) {
			int count = 0;
			for (Person relative : family)
				System.out.printf("%d. %s\n",++count, relative.getName());
			
			option = this.scanner.nextInt();
			
			if(option <= 0) {
				System.out.println(erroMsg);
			}
			break;
		}
		return option-1;
	}
	
	public int readRelativeOption(String name) {
		System.out.printf("O que quer adicionar para %s\n\n", name);

		int option = 0;
		
		loop: while(true) {
			System.out.println("1. Pai/Mãe\n2. Filho/Filha\n3. Parar\n");
			option = this.scanner.nextInt();
			switch (option) {
			case 1: 
				break loop;
			case 2: 
				break loop;
			case 3: 
				break loop;
			default:
				System.out.println(erroMsg);
				continue;
			}
		}
		
		return option;
	}
	
	public Person readUserInfo() {
		System.out.print("Insira seus dados\n\n");
		Person user = new Person(true);
		
		String name = "";
		while(true) {
			System.out.print("nome: ");
			name = this.scanner.nextLine();
			if(name.length() <= 0) {
				System.out.println("Digite um nome válido");
				continue;
			}				
			user.setName(name);
			break;
		}
		
		int age = 0;
		while(true) {
			System.out.print("idade: ");
			age = this.scanner.nextInt();
			if(age <= 0) {
				System.out.println(erroMsg);
				continue;		
			}
			user.setAge(age);
			break;
		}
		return user;
	}
	
	public Person readRelativeInfo() {
		System.out.println("Digite os dados deste parente");
		Person person = new Person();
		
		String name = "";
		while(true) {
			System.out.print("nome: ");
			name = this.scanner.nextLine();
			if(name.length() <= 0) {
				System.out.println(erroMsg);
				continue;
			}				
			person.setName(name);
			break;
		}
		
		int age = 0;
		while(true) {
			System.out.print("idade: ");
			age = this.scanner.nextInt();
			if(age <= 0) {
				System.out.println(erroMsg);
				continue;		
			}
			person.setAge(age);
			break;
		}	
		
		return person;
	}
}
