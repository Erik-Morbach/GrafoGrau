package view;

import java.util.Scanner;

import model.Person;

public class Menu {
	private Scanner scanner = new Scanner(System.in);
	
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
				System.out.println("Por favor insira uma opção válida");
				continue;
			}
		}
		
		return option;
	}
	
	public Person readUserInfo() {
		System.out.print("Insira seus dados: ");
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
				System.out.println("Digite uma idade válida");
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
				System.out.println("Digite um nome válido");
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
				System.out.println("Digite uma idade válida");
				continue;		
			}
			person.setAge(age);
			break;
		}	
		
		return person;
	}
}
