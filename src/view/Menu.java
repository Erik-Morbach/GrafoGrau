package view;

import java.util.Scanner;

public class Menu {
	private Scanner scanner = new Scanner(System.in);
	
	public int readAddRelativeOption(String name) {
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
	
	public String readUserName() {
		System.out.print("Insira seu nome: ");
		String name = this.scanner.nextLine();
		System.out.print("\n\n");
		return name;
	}
	
	public readPersonInfo() {
		
	}
}
