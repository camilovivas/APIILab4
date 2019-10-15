package ui;

import java.util.Scanner;

import model.*;

public class Main {
	private Scanner reader;
	private Federation relation;

	public static void main(String[] args) {
		Main m = new Main();
	}
	
	public Main() {
		reader = new Scanner(System.in);
		relation = new Federation();
		int i = menu();
		option(i);
	}
	
	public int menu() {
		int option = 0;
		System.out.println("ingrese el numero de la opcion que deseda realizar");		
		System.out.println("1. buscar a un participante");		
		System.out.println("2. buscar a una persona inscrita");		
		System.out.println("3. ver participantes de un pais");		
		System.out.println("3. ver inscritos de un pais");		
		
		return option;
	}
	
	public void option(int i) {
		switch(i) {
		case 1:
			
		case 2:
			
		case 3:
			
		case 4:	
		}
	}
	

}
